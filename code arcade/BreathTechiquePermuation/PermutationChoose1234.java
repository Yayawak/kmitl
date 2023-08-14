package BreathTechiquePermuation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PermutationChoose1234 {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

	static void printDistinctPermutn(String str,
									String ans)
    {

		// If string is empty
		if (str.length() == 0) {

			// print ans
			System.out.print(ans + " ");
			return;
		}

		// Make a boolean array of size '26' which
		// stores false by default and make true
		// at the position which alphabet is being
		// used
		boolean alpha[] = new boolean[26];

		for (int i = 0; i < str.length(); i++) {

			// ith character of str
			char ch = str.charAt(i);

			// Rest of the string after excluding
			// the ith character
			String ros = str.substring(0, i) +
						str.substring(i + 1);

			// If the character has not been used
			// then recursive call will take place.
			// Otherwise, there will be no recursive
			// call
			if (alpha[ch - 'a'] == false)
				printDistinctPermutn(ros, ans + ch);
			alpha[ch - 'a'] = true;
		}
	}

    // public static byte[] iterByte(int n)
    public static String[] iterByte(int length)
    {
        int n = (int)Math.pow(2, length);
        String[] ret = new String[n];
        // for (int i = 0; i < n; i++)
        // {
        //     ret[i] = Integer.toBinaryString(i);
        //     System.out.println(Integer.toBinaryString(i));
        // }
        // // int i 
        // System.out.println(n);
        while (--n >= 0)
        {
            // ret[n] = Integer.toString(n);
            // ret[n] = Integer.toBinaryString(n);
            ret[n] = new StringBuilder(Integer.toBinaryString(n)).reverse().toString();

            // StringBuilder.re
            // System.out.println(ret[n]);
        }
        return ret;
    }

    public static char[] mapArrayIntToChar(int[] A)
    {
        char c = 'A';
        // int sum = Arrays.stream(A).sum();
        // System.out.println("sum = " + sum);
        // char[] ret = new char[sum];
        String s = "";
        int i = 0;
        while (i < A.length)
        {
            int j = 0;
            while (j < A[i])
            {
                // ret[i + j] = c;
                s += String.valueOf(c);
                // System.out.print(c);
                // System.out.println(c);
                j++;
            }
            c++;
            i++;
        }
        // return ret;    
        // System.out.println();
        // System.out.println("-------------------------------");
        return s.toCharArray();    
    }

    public static String[] fullfillZero(int fullLen, String[] reversedBytes)
    {
        for (int i = 0; i < reversedBytes.length; i++)
        {
            StringBuilder sb = new StringBuilder(reversedBytes[i]);
            while (sb.length() < fullLen)
            {
                sb.append("0");
            }
            reversedBytes[i] = sb.toString();
            // System.out.println(reversedBytes[i]);
        }
        // System.out.println();
        return reversedBytes;
    }

    // public static char[] createCharFromEncodedBinary(String encodedString, char[] symbolicArray)
    public static ArrayList<Character> createCharFromEncodedBinary(String encodedString, char[] symbolicArray)
    {
        // (encodedString.length) will == (symbolicArray.length)
        int n = encodedString.length();
        // char[] ret = new char[n];
        ArrayList<Character> ret = new ArrayList<Character>();
        for (int i = 0; i < n; i++)
        {
            if (encodedString.charAt(i) == '1')
            {
                ret.add(symbolicArray[i]);
            }
        }
        return (ret);
    }

    // @SuppressWarnings("unchecked")
    // public static <T> Set<T> removeDuplicatedArrayLists(List<T> A)
    public static Set<ArrayList<Character>> removeDuplicatedArrayLists(List<ArrayList<Character>> A)
    {
        Set<ArrayList<Character>> s = new HashSet<ArrayList<Character>>();
        A = (List<ArrayList<Character>>)A;
        for (ArrayList<Character> a : A)
        {
            s.add(a);
        }
        return s;
        // if (A.get(0) instanceof Character)
        // if (A instanceof ArrayList<Character>)
        // {

        // }
        // if (A.get(0) instanceof String)
        // {

        // }
        // Set<T> uniques = new HashSet<T>();
        // for (T val : A)
        // {
        //     uniques.add(val);
        // }
        // return uniques;
    }

    public static Set<String> permutationFinder(String str) {
        Set<String> perm = new HashSet<String>();
        //Handling error scenarios
        if (str == null) {
            return null;
        } else if (str.length() == 0) {
            perm.add("");
            return perm;
        }
        char initial = str.charAt(0); // first character
        String rem = str.substring(1); // Full string without first character
        Set<String> words = permutationFinder(rem);
        for (String strNew : words) {
            for (int i = 0;i<=strNew.length();i++){
                perm.add(charInsert(strNew, initial, i));
            }
        }
        return perm;
    }

    public static String charInsert(String str, char c, int j) {
        String begin = str.substring(0, j);
        String end = str.substring(j);
        return begin + c + end;
    }

    public static String condenseCharListToString(List<Character> l)
    {
        StringBuilder sb = new StringBuilder("");
        l.stream().forEach(c -> {
            sb.append(c);
        });
        return sb.toString();
    }

    // private static char randcharCoolCool(int scaler, int shiftUp)
    private static char randcharCoolCool(int bot, int top)
    {
        Random rd = new Random();
        // return (char)(Math.random() * scaler + shiftUp);
        // return (char)(Math.random() * scaler + shiftUp);
        return (char)(rd.nextInt(bot, top));
    }

    // Driver code
    public static void main(String[] args) {
        int minJpnCharCode = 0x4e00;
        int maxJpnCharCode = 0x4f80;
        // String s = "geek";
        // String s = "ab";
        // printDistinctPermutn(s, "");
        // char[]
        // int[] input = {1, 2, 1, 2};
        int[] input = {1, 1, 0, 2, 1};
        // int[] input = {1, 2, 1, 1};
        // int[] input = {1, 2, 1, 0, 1};
        // int[] input = { 1, 2, 1 };
        // Scanner sc = new Scanner(System.in);
        // int[] input = new int[5];
        // // for (int i = 0; i < input.length; i++)
        // //     input[i]= sc.nextInt();
        // int sum = 0;
        // String A = sc.nextLine();
        // int i = 0;
        // for (String s : A.split(" "))
        // {
        //     input[i] = Integer.parseInt(s);
        //     i++;
        // }
        // if (sum > 10)
        // {
        //     sc.close();
        //     return ;
        // }
        // System.out.println();


        // System.out.println(iterByte(16));

        char[] symbolicArray = mapArrayIntToChar(input);
        // System.out.println(symbolicArray.toString() + "\n");
        String[] reversedByteStrings = iterByte(symbolicArray.length);
        String[] fullfilledZeroBytesString = fullfillZero(symbolicArray.length, reversedByteStrings);
        // System.out.println(Arrays.toString(fullfilledZeroBytesString));

        // for (String s : fullfilledZeroBytesString)
        // {
        // List<Character> l = createCharFromEncodedBinary(s, symbolicArray);
        // System.out.println(l);
        // }
        Set<ArrayList<Character>> noDuplicated = removeDuplicatedArrayLists(
            List.of(fullfilledZeroBytesString).stream().map(str -> createCharFromEncodedBinary(str, symbolicArray))
                    .toList());
        // System.out.println(noDuplicated);
        // System.out.println("--------------------------------");
        // permuation each sub list

        Iterator<ArrayList<Character>> iter = noDuplicated.iterator();
        // Set<String> permNoDuplicted2 = new HashSet<>();
        // * Tree use to sort
        Set<String> permNoDuplicted2 = new TreeSet<>();
        // Set<String> permNoDuplicted2 = new HashSet<>();
        while (iter.hasNext()) 
        {
            ArrayList<Character> charList = iter.next();
            String s = condenseCharListToString(charList);
            Set<String> perm = permutationFinder(s);
            // System.out.println(perm);
            permNoDuplicted2.addAll(perm);
        }
        // System.out.println("--------------------------------");
        // permNoDuplicted2.remove("");
        // System.out.println(permNoDuplicted2);
        // System.out.println(permNoDuplicted2.size());
        // System.out.println("--------------------------------");
        for (String perm : permNoDuplicted2)
        {
            StringBuilder sb = new StringBuilder("");
            for (char c : perm.toCharArray())
            {
                sb.append(ANSI_RESET);
                if (c == 'A')
                    sb.append(ANSI_YELLOW);
                else if (c == 'B')
                    sb.append(ANSI_RED);
                else if (c == 'C')
                    sb.append(ANSI_GREEN);
                else if (c == 'D')
                    sb.append(ANSI_PURPLE);
                else if (c == 'E')
                    sb.append(ANSI_CYAN);
                sb.append(c);
                sb.append(ANSI_RESET);
                try {
                    Thread.sleep(10);
                } catch (Exception e) { }
                // sb.append(
                //     new Random().nextInt(100) > 95 ?
                //     randcharCoolCool(minJpnCharCode, maxJpnCharCode)
                //     : ""
                // );
            }
            System.out.println(sb.toString());
            // System.out.print(sb.toString() + '\t');
        }


        // sc.close();
    }

}
