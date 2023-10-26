package Puzzle8Problem;


public class Main {
    static  Puzzle8_65050988 game;

    public static void main(String[] args) {
        int [] seq = new int[]{
            9, 0, 0,
            1, 0, 1,
            3, 0, 2,

            4, 1, 0,
            2, 1, 1,
            5, 1, 2,

            7, 2, 0,
            8, 2, 1,
            6, 2, 2
        };

        game = new Puzzle8_65050988(seq);

        demo1();
        demo2();
        demo3();
    }

    static void demo1()
    {
        System.out.println("Displaying Board (initialzed with puzzle problem).");
        game.displayBoard();
    }

    static void demo2()
    {
        // System.out.println("demo 2 try to create moves possible from currenrt state in dfs concept");
        // game.generateNextMoves();
    }

    static void demo3()
    {
        game.nextMoveWithStack();
        System.out.printf("Demo 3 create real move to dfs, explored size = %d\n",
            game.explored.size()
        );
        System.out.print("partial explored states below ....\n");
        // game.nextMoveWithStack();
        for (Puzzle8State st : game.explored)
        {
            // if (st.sequence[0] == 1 && st.sequence[1] == 2 && 
            //     st.sequence[2] == 3 && st.sequence[3] == 4
            //     )
            // {
            //     st.displaySequence(true);
            // }
            st.displaySequence(false);
        }
        System.out.println("note that the program terminates prior to pusing goal state into explored !!");
    }
}
