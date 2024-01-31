package Puzzle8Problem;

// public class Puzzle8State implements Comparable<Puzzle8State>
public class Puzzle8State
{
    public static final String RED_BACKGROUND = "\033[41m"; // RED
    public static final String RESET = "\033[0m"; // Text Reset
    public static final String GREEN_BACKGROUND = "\033[42m";  // GREEN

    public int[] sequence;

    public Puzzle8State(int[] temporalySex)
    {
        // sequence = temporalySex;
        assert temporalySex.length == 9 * 9;
        sequence = new int[temporalySex.length];
        for (int i = 0; i < temporalySex.length; i++)
        {
            sequence[i] = temporalySex[i];
        }
    }

    @Override
    // public boolean equals(Puzzle8State other)
    public boolean equals(Object ot)
    {
        Puzzle8State other = (Puzzle8State) ot;
        for (int i = 0; i < other.sequence.length; i++)
        {
            if (sequence[i] != other.sequence[i])
            {
                // System.out.println("not equals");
                return false;
            }
        }
        return true;
    }

    public void displaySequence(boolean fullformat)
    {
        // if ()
        System.out.print("[");
        for (int i = 0; i < sequence.length; i++)
        {
            if (fullformat)
                System.out.printf("%d, ", sequence[i]);
            else
            {
                if (i % 3 == 0)
                    System.out.printf("%d, ", sequence[i]);
            }
        }
        System.out.println("]");
    }

    // @Override
    // public int compareTo(Puzzle8State o) {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'compareTo'");
    // }

    void displaySeq()
    {
        int[][] mat = new int[3][3];
        // for (int i = 0; i < sequence.length; i++) {
        for (int i = 0; i < sequence.length / 3; i++) {
            // int row = i / 9;
            int row = i / 3;
            int col = i % 3;
            // System.out.printf("[%d,%d]\n", row, col);

            mat[row][col] = sequence[3 * i];
        }

        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                // String a = "\e[0;31m";
                System.out.printf("%s %s",
                    mat[i][j] == 9 
                        ? 
                        RED_BACKGROUND + " " + RESET
                        // GREEN_BACKGROUND + " " + RESET
                        :
                        String.valueOf(mat[i][j])
                    ,
                    j == 2 ? "\n" : ""
                );
            }
        }
    }
}
