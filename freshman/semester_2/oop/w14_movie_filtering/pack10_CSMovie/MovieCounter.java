package pack10_CSMovie;

import java.io.IOException;
import java.nio.file.Paths;
import java.security.cert.CollectionCertStoreParameters;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.Set;
import java.util.Map.Entry;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

import javax.print.DocFlavor.STRING;

public class MovieCounter {
    ArrayList<CSMovie> mList = new ArrayList<>();
    Set<String> uniqueTitle = new HashSet<>();
    public MovieCounter() {
        String row;
        int rowCount = 1;
        int incompleteCount = 0;
        String title;
        String rating;
        String genre;
        Integer year;
        String skipped_released;
        Double score;
        Integer votes;
        String director;
        String skipped_writer;
        String star;
        String country;
        Integer budget;
        Integer gross;
        String company;
        Integer runtime;

        try(Scanner input = new Scanner(Paths.get("pack10_CSMovie/movies.csv"))) {
            input.nextLine(); //skip header row
            while (input.hasNext()) {
                row = input.nextLine();
                rowCount++;
                String[] tokens = row.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
                if (tokens.length < 15) {
                    incompleteCount++;
                    System.out.println(rowCount + " " + incompleteCount + " is incompleted");
                    continue; //skip this row
                }
                title = tokens[0];
                rating = tokens[1];
                genre = tokens[2];
                year = Integer.parseInt(tokens[3]);
                skipped_released = tokens[4];
                score = Double.parseDouble(parseDouble(tokens[5]));
                votes = (int) (Double.parseDouble(parseDouble(tokens[6])));
                director = tokens[7];
                star = tokens[9];
                country = tokens[10];
                budget = (int) (Double.parseDouble(parseDouble(tokens[11])));
                gross = (int) (Double.parseDouble(parseDouble(tokens[12])));
                company = tokens[13];
                runtime = (int) (Double.parseDouble(parseDouble(tokens[14])));

                if (!uniqueTitle.contains(title)) {
                    mList.add(new CSMovie(title, rating, genre,
                    year, score, votes,
                    director, star, country,
                    budget, gross, company,
                    runtime));
                }
                uniqueTitle.add(title);
            }
            System.out.print("There are " + incompleteCount + " rows of incompleted data ");
            System.out.println("from " + rowCount + " rows. (" + uniqueTitle.size()+ ") unique titles.");
            System.out.println("list size is " + mList.size());
        } catch (IOException e) {
            System.out.println("from IO error");
            e.printStackTrace();
        }
    }
    private static String parseDouble(String str) {
        if (str.isEmpty())
            return ".0";
        return str;
    }

    // find mean
    public Double q1() {
        // int n = mList.size();
        // mList.stream().reduce((a, b) -> a.getScore() + b.getScore());
        // double sum = mList.stream().mapToDouble(m -> m.getScore()).sum();
        double av = mList.stream().mapToDouble(m -> m.getScore()).average().getAsDouble();
            // .sum
        // return 0d;
        // return (sum / n);
        return av;
    }

    public List<CSMovie> q2() {
        // List<CSMovie> greaterThan19 = mList.stream().filter(
        return mList.stream().filter(
            m -> m.getVotes() > 1_900_000
        ).toList();

    }

    // high gross revenue movie
    public CSMovie q3() {
        // return mList.stream().max((m) -> m.)
        return mList.stream().max(new Comparator<CSMovie>() {
            @Override
            public int compare(CSMovie o1, CSMovie o2) {
                return o1.getGross() - o2.getGross();
            }
        }).get();
    }
    // number of genre
    public List<String> q4() {
        return mList.stream().map((m) -> m.getGenre()).distinct().toList();
    }

    //top 5 least runtime including 0 runtime
    public List<String> q5() {
        return mList.stream().sorted((m1, m2) ->
            m1.getRuntime().compareTo(m2.getRuntime())
        ).map(m -> m.getTitle()).limit(5).toList();
        // ).peek(System.out::println)
        // .map(m -> m.getTitle()).limit(5).
        // toList();
    }

    public CSMovie[] q6() {
        //highest and lowest budget
        // CSMovie
        // return
        CSMovie minMv = mList.stream().min((m1, m2) -> m1.getBudget() - m2.getBudget()).get();
        CSMovie maxMv = mList.stream().max((m1, m2) -> m1.getBudget() - m2.getBudget()).get();
        // CSMovie[0] =
        return new CSMovie[] { minMv, maxMv };
    }

    public List<CSMovie> q7(String genre) {
        // top 3 action movies
        return mList.stream().filter( m -> m.getGenre().equals(genre))
            .sorted(Comparator.comparing(CSMovie::getScore)
                .reversed()
                .thenComparing(CSMovie::getVotes)
            )
        .limit(3).toList();
    }

    //top 4 action movies then by title
    public List<CSMovie> q8() {
        return mList.stream()
            .sorted(Comparator.comparing(CSMovie::getScore)
                .reversed()
                .thenComparing(CSMovie::getVotes)
                .thenComparing(CSMovie::getTitle)
        ).limit(4).toList();
    }
    public Map<String,Long> q9() {
        //subtotal gross revenue of each genre
        return mList.stream().collect(Collectors.groupingBy(
            CSMovie::getGenre, Collectors.summingLong(CSMovie::getGross)
        ));
    }
    public Map<String,Long> q10() {
        // 10 companies with most movies produced
        return mList.stream().collect(Collectors.groupingBy(
                CSMovie::getCompany, Collectors.counting()
            )).entrySet().stream()
            .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
            .limit(10)
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    // show title with most 'a'
    public CSMovie q11() {
        // Function most 'a'
        Function<CSMovie, Integer> countA = m -> {
            int cnt = 0;
            String title = m.getTitle();
            for (int i = 0; i < title.length(); i++) {
                if (title.charAt(i) == 'a' || title.charAt(i) == 'A')
                    cnt++;
            }
            return cnt;
            // String title = m.getTitle().toLowerCase();
            // return (int) title.chars()
            //     .filter(c -> c == 'a').count();
        };
        Optional<CSMovie> movieWithMostA = mList.stream()
            .max(Comparator.comparing(countA));

        return movieWithMostA.orElse(null);
    }
}
// https://www.baeldung.com/java-split-string-commas
