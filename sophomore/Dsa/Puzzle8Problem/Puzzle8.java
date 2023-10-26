package Puzzle8Problem;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Puzzle8
{
    int size = 3;
    int[] sequence; // 3 * 9
    ArrayList<Puzzle8State> explored;
    Stack<Puzzle8State> dfs;

    public Puzzle8(int[] seq)
    {
        sequence = seq;
        dfs = new Stack<>();
        explored = new ArrayList<>();

        // for (int i = 0; i < seq.length; i++)
        // {
        //     int row = i / seq.length;
        //     int col = i % 3;
        //     System.out.printf("[y,x] = [%d,%d] = %d\n", row, col, seq[i]);
        // }
        Puzzle8State init = new Puzzle8State(sequence);
        dfs.push(init);
        explored.add(init);
    }


    public void nextMoveWithStack()
    {
        generateNextMoves();
        // generateNextMoves();
        // generateNextMoves(); generateNextMoves(); generateNextMoves(); generateNextMoves();
        // generateNextMoves(); generateNextMoves(); generateNextMoves(); generateNextMoves();
    }


    private Puzzle8State createMoveFromSwapWithEmptyTile(Puzzle8State currentState, int blackPos, int swapPos)
    {
        // Puzzle8State currentTopSeq = dfs.peek();    
        assert currentState != null;

        Puzzle8State dup = new Puzzle8State(currentState.sequence);
        dup.sequence[blackPos] = currentState.sequence[swapPos];
        dup.sequence[swapPos] = 9;

        // System.out.println(Arrays.toString(dup.sequence));
        // dup.displaySequence(false);
        // if (dup.equals(dup))
        // explored.add(dup);

        // dfs.push(dup);
        return dup;
    }

    private boolean isThisStateInExploredStates(Puzzle8State state)
    {
        // System.out.println("isThisStateInExploredStates ssssssssj;dfkjs;dkfjf");
        // System.out.println(explored.size());
        for (Puzzle8State st :  explored)
        {
            if (st.equals(state))
            {
                // System.out.println("-");
                return true;
            }
        }
        // System.out.println("yyyyyyyyyy");
        return false;
    }

    public void generateNextMoves()
    {
        // int blackPos = 
        // Stream.of(sequence).filter(num -> num == 9).collect(Collectors.toList()).get(0);
        // int blackPos = Arrays.stream(sequence).filter(num -> num == 9).findFirst().getAsInt();
        // int blackPos = Arrays.stream(sequence).map(num -> num == 9)

        int blackPos = -1;
        // int[] currentSequ
        // Puzzle8State currentState = dfs.peek();
        Puzzle8State currentState = dfs.pop();
        assert currentState != null;

        // for (int i = 0; i < sequence.length; i++) 
        for (int i = 0; i < currentState.sequence.length; i++) 
        {
            // if (sequence[i] == 9)
            if (currentState.sequence[i] == 9)
                blackPos = i;
        }
        assert blackPos != -1;

        // currentState.displaySequence(false);

        // System.out.println(blackPos);
        Puzzle8State[] possibleNewStates = new Puzzle8State[4];
        // ! go south if possible nah
        for (int i = 0; i < 4; i++)
            possibleNewStates[i] = null;
        // if (blackPos + 3 < size * size)
        // if (blackPos + 3 < size * size && blackPos + 9 < size * size)
        if (blackPos + 3 < 27 && blackPos + 9 < 27)
        {
            // createMoveFromSwapWithEmptyTile()
            // System.out.print("pusing south");
            possibleNewStates[0] = createMoveFromSwapWithEmptyTile(currentState, blackPos, blackPos + 9);
        }
        // * go north 
        if (blackPos - 3 > -1 && blackPos - 9 > -1)
        // if (blackPos - 3 > -1)
        {
            possibleNewStates[1] = createMoveFromSwapWithEmptyTile(currentState, blackPos, blackPos - 9);
        }
        // ! go east 
        // if (blackPos %3 < 2)
        if (blackPos %3 <= 2 && blackPos + 3 < 27)
        // if (blackPos %3 <= 2)
        {
            // System.out.print("pusing east");
            possibleNewStates[2] = createMoveFromSwapWithEmptyTile(currentState, blackPos, blackPos + 3);
        }
        // * go west 
        // if (blackPos %3 > 0)
        if (blackPos %3 > 0 && blackPos - 3 < -1)
        {
            possibleNewStates[3] = createMoveFromSwapWithEmptyTile(currentState, blackPos, blackPos - 3);

        }

        for (int i = 0; i < 4; i++)
        {
            // System.out.printf("I = %d\n", i);
            if (possibleNewStates[i] != null)
            {
                if (!isThisStateInExploredStates(possibleNewStates[i]))
                {
                    dfs.push(possibleNewStates[i]);
                    explored.add(possibleNewStates[i]);

                    possibleNewStates[i].displaySequence(false);
                    // possibleNewStates[i].displaySeq();

                    System.out.println();
                    // System.exit(-1);
                    // System.out.println("pusing pusing pusing ");
                }

                if (isGoal(possibleNewStates[i].sequence))
                {
                    System.out.println("Found goal now");
                    System.exit(0);
                }

            }
        }
        // else
        // {
        //     nextMoveWithStack();
        // }
        // try { long l = 1l; Thread.sleep(l); } catch (Exception e) { }
        nextMoveWithStack();
    }

    public boolean isGoal(int[] seq)
    {
        int[] finalConfigurationSeq = new int[27];

        for (int i = 0; i < 9; i++)
        {
            int j = i * 3;
            finalConfigurationSeq[j + 0] = i + 1;
            // finalConfigurationSeq[j + 1] = -1;
            // finalConfigurationSeq[j + 2] = -1;

            if (seq[j] != finalConfigurationSeq[j])
                return false;
        }
        return true;
    }

    void displayBoard()
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
                System.out.printf("%s %s",
                    mat[i][j] == 9 ? " " : String.valueOf(mat[i][j]),
                    j == 2 ? "\n" : ""
                );
            }
        }
    }

}