// import java.util.Arrays;
import java.util.Scanner;
// import java.lang.Math;

class Real
{
    public static void main(String[] args) {
        // String paranString = "<{})(><<][]}><{()][]><{]><}{)()({}><{]{{}>[}({}<({<>}{][)([}[}><";
        Scanner scanner = new Scanner(System.in);
        String paranString = scanner.nextLine();
        int l = paranString.length();
        if (!(l > 0 && l < 1000000))
            return;
        // String paranString = "()[]{}<>({[<<[{(]}>)";
        char[] paransChars = paranString.toCharArray();
        char[] openParans = {'(', '[', '{', '<'};
        char[] closeParans = {')', ']', '}', '>'};
        int[] pairs = new int[12];
        for (int i = 0; i < 4; i++)
            pairs[i] = 0;
        for (int i = 0; i < paransChars.length; i++)
        {
            for (int j = 0; j < 4; j++)
            {
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
        for (int i = 0; i < pairs.length; i++)
        {
            System.out.println(pairs[i]);
        }
        System.out.println(999999);
        scanner.close();
    }
}
