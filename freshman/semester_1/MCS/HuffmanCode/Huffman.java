import java.util.PriorityQueue;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;

class HuffmanNode {
    int data;
    char c;

    HuffmanNode left;
    HuffmanNode right;
}

class MyComparator implements Comparator<HuffmanNode> {
    public int compare(HuffmanNode x, HuffmanNode y) {
        return x.data - y.data;
    }
}

public class Huffman {
    public static void printCode(HuffmanNode root, String s) {
        if (root.left == null && root.right == null) {
            // System.out.println("ascii(" + (int) root.c + ") : " + s);
            return;
        }
        printCode(root.left, s + "0");
        printCode(root.right, s + "1");
    }

    public static void countLengths(HuffmanNode root, int[] charBitLength, int length) {
        if (root.left == null && root.right == null) {
            charBitLength[(int) root.c] = length;
            return;
        }
        countLengths(root.left, charBitLength, length + 1);
        countLengths(root.right, charBitLength, length + 1);
    }

    static void buildCharFreqFromFile(char[] charArray, int[] charFreq, String bookName) {
        for (int i = 0; i < charArray.length; i++) {
            charArray[i] = (char) i;
            // charFreq[i] = i;
            charFreq[i] = 1;
            // charFreq[i] = 0;
        }

        String superData = "";
        try {
            // File myObj = new File("Book 1 - The Philosopher's Stone.txt");
            File myObj = new File(bookName);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String lineData = myReader.nextLine();
                superData += lineData;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        for (int i = 0; i < charArray.length; i++)
            for (int j = 0; j < superData.length(); j++)
                if (superData.charAt(j) == charArray[i])
                    charFreq[i]++;
    }

    static double Driver(String bookName)
    {
        char[] charArray = new char[256];
        // charArray = {'a', 'b', 'z'}
        int[] charFreq = new int[256];

        buildCharFreqFromFile(charArray, charFreq, bookName);
        // System.out.println(Arrays.toString(charArray));
        // System.out.println(Arrays.toString(charFreq));
        for (int i = 0; i < 256 / 2; i++)
        {
            // System.out.printf("(%c,%d), ", charArray[i], charFreq[i]);
        }
        int n = charArray.length;

        // [ก, ก ก ก ก ก กง ง ง ง ง ง]
        PriorityQueue<HuffmanNode> q = new PriorityQueue<HuffmanNode>(n, new MyComparator());

        for (int i = 0; i < n; i++) {
            HuffmanNode hn = new HuffmanNode();

            hn.c = charArray[i];
            hn.data = charFreq[i];

            hn.left = null;
            hn.right = null;

            q.add(hn);
        }

        HuffmanNode root = null;

        while (q.size() > 1) {
            // HuffmanNode x = q.dequeue();
            HuffmanNode x = q.peek();
            q.poll();

            HuffmanNode y = q.peek();
            q.poll();

            HuffmanNode f = new HuffmanNode();

            f.data = x.data + y.data;
            f.left = x;
            f.right = y;
            q.add(f);
        }
        root = q.peek();

        int[] charBitLength = new int[n];
        printCode(root, "");
        countLengths(root, charBitLength, 0);

        int sumBit = 0;
        int sumChar = 0;
        for (int i = 0; i < n; i++) {
            // System.out.println("ascii(" + i + "): " + charBitLength[i] + " ");
            sumBit += (charBitLength[i] * charFreq[i]);
            sumChar += charFreq[i];
        }
        System.out.println(bookName);
        System.out.printf("Sum char : %d\n", sumChar);
        // System.out.printf("Sum char : %d\n", sumChar);
        double avg = sumBit / (double) sumChar;
        System.out.println("Average bits per char:" + avg);
        System.out.println("---------------------------");

        // return avg;
        return sumChar;
    }

    // main function
    public static void main(String[] args) {
        String[] books = {
            "Book 1 - The Philosopher's Stone.txt",
            "Book 2 - The Chamber of Secrets.txt",
            "Book 3 - The Prisoner of Azkaban.txt",
            "Book 4 - The Goblet of Fire.txt",
            "Book 5 - The Order of the Phoenix.txt",
            "Book 6 - The Half Blood Prince.txt",
            "Book 7 - The Deathly Hallows.txt"
        };

        double sum = 0;
        for (int i = 0; i < books.length; i++)
        {
            double sumChar = Driver(books[i]);
            sum += sumChar;
        }
        System.out.println("SUM ALL = " + sum);
    }
}

// This code is contributed by Kunwar Desh Deepak Singh
