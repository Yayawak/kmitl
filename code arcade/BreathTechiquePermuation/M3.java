package BreathTechiquePermuation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class M3 {

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

    public static Set<ArrayList<Character>> removeDuplicatedArrayLists(List<ArrayList<Character>> A)
    {
        Set<ArrayList<Character>> s = new HashSet<ArrayList<Character>>();
        A = (List<ArrayList<Character>>)A;
        for (ArrayList<Character> a : A)
        {
            s.add(a);
        }
        return s;
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

    // Driver code
    public static void main(String[] args) {
        // int[] input = {1, 2, 1, 3};
        // int[] input = { 1, 2, 1 };
        Scanner sc = new Scanner(System.in);
        int[] input = new int[5];
        int sum = 0;

        for (int i = 0; i < input.length; i++)
        {
            input[i]= sc.nextInt();
            sum += input[i];
        }
        
        if (sum > 10)
        {
            sc.close();
            return ;
        }
        // int[] input = { 1, 2, 1 };
        // System.out.println();


        // // System.out.println(iterByte(16));

        char[] symbolicArray = mapArrayIntToChar(input);
        // System.out.println(symbolicArray.toString() + "\n");
        String[] reversedByteStrings = iterByte(symbolicArray.length);
        String[] fullfilledZeroBytesString = fullfillZero(symbolicArray.length, reversedByteStrings);
        // System.out.println(Arrays.toString(fullfilledZeroBytesString));

        // // for (String s : fullfilledZeroBytesString)
        // // {
        // // List<Character> l = createCharFromEncodedBinary(s, symbolicArray);
        // // System.out.println(l);
        // // }
        // List<ArrayList<Character>> k = List.of(fullfilledZeroBytesString).stream().map(str -> createCharFromEncodedBinary(str, symbolicArray))
        //             .toList();
        List<ArrayList<Character>> k= new ArrayList<ArrayList<Character>>();
        for (String s : fullfilledZeroBytesString)
        {
            ArrayList<Character> ca = createCharFromEncodedBinary(s, symbolicArray);
            k.add(ca);
        }
        System.out.println(k);
        // Set<ArrayList<Character>> noDuplicated = removeDuplicatedArrayLists(
        //   k
        //     );
        // // System.out.println(noDuplicated);
        // // System.out.println("--------------------------------");
        // // permuation each sub list

        // Iterator<ArrayList<Character>> iter = noDuplicated.iterator();
        // // Set<String> permNoDuplicted2 = new HashSet<>();
        // // * Tree use to sort
        // Set<String> permNoDuplicted2 = new TreeSet<>();
        // // Set<String> permNoDuplicted2 = new HashSet<>();
        // while (iter.hasNext()) 
        // {
        //     ArrayList<Character> charList = iter.next();
        //     String s = condenseCharListToString(charList);
        //     Set<String> perm = permutationFinder(s);
        //     // System.out.println(perm);
        //     permNoDuplicted2.addAll(perm);
        // }
        // // System.out.println("--------------------------------");
        // permNoDuplicted2.remove("");
        // // System.out.println(permNoDuplicted2);
        // // System.out.println(permNoDuplicted2.size());
        // // System.out.println("--------------------------------");
        // for (String perm : permNoDuplicted2)
        // {
        //     System.out.println(perm);
        // }


        // sc.close();
    }

}
