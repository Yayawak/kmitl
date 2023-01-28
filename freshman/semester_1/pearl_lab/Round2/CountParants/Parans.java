import java.util.Arrays;
import java.util.Scanner;
import java.lang.Math;

class Parans
{
    public static void main(String[] args) {
        // String paranString = "<{})(><<][]}><{()][]><{]><}{)()({}><{]{{}>[}({}<({<>}{][)([}[}><";
        String paranString = "()[]{}<>({[<<[{(]}>)";
        char[] paransChars = paranString.toCharArray();
        char[] openParans = {'(', '[', '{', '<'};
        char[] closeParans = {')', ']', '}', '>'};
        String[] colors = {
            ForeGroundColor.ANSI_RED,
            ForeGroundColor.ANSI_CYAN,
            ForeGroundColor.ANSI_PURPLE,
            ForeGroundColor.ANSI_YELLOW,
        };
        int[] pairs = new int[12];
        // int[] pairs = new int[4];
        // System.out.println(Arrays.toString(paransChars));
        System.out.print("[");
        for (int i = 0; i < paransChars.length; i++)
        {
            for (int j = 0; j < openParans.length; j++)
            {
                if (paransChars[i] == openParans[j]
                    || paransChars[i] == closeParans[j])
                {
                    System.out.print(colors[j]);
                    System.out.printf("%c", paransChars[i]);
                    String end = (i == (paransChars.length - 1)) ? "" : ", ";
                    System.out.print(ForeGroundColor.ANSI_WHITE + end);
                }
            }
        }
        System.out.print("]");
        for (int i = 0; i < 4; i++)
            pairs[i] = 0;
        for (int i = 0; i < paransChars.length; i++)
        {
            for (int j = 0; j < 4; j++)
            {
                // if == '('
                if (paransChars[i] == openParans[j])
                {
                    for (int k = i + 1; k < paransChars.length; k++)
                    {
                        if (paransChars[k] == closeParans[j])
                        {
                            paransChars[i] = '_';
                            paransChars[k] = '*';
                            pairs[j]++;
                            break;
                        }
                    }
                }
            }
        }
        for (int i = 0; i < paransChars.length; i++)
        {
            for (int j = 0; j < openParans.length; j++)
            {
                if (paransChars[i] == openParans[j])
                    pairs[4 + j * 2]++;
                if (paransChars[i] == closeParans[j])
                    pairs[5 + j * 2]++;
            }
        }
        // System.out.println("\n");
        System.out.println();
        System.out.println(Arrays.toString(paransChars));
        // System.out.println("\n");
        System.out.println("Count pairs");
        System.out.println(Arrays.toString(pairs));

        // System.out.println("Sum");
        int sum = 0;
        for (int num : pairs)
        {
            sum += num;
        }
        // sum = 12
        //432866
        // System.out.println(sum);
        // System.out.println(69420 * sum);
    }
}
