import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        FSMGraph<String> fsm = new FSMGraph<>();
        ArrayList<State<String>> V = new ArrayList<>();
        V.add(new State<String>("S0", true, false));
        V.add(new State<String>("S1", false, false));
        // V.add(new State<String>("S2", false, true));
        // sc.
        System.out.println("Enter State data...");
        while (true) {
            System.out.println("Enter state name :");
            String stateName = sc.nextLine();
            System.out.println("is this state initial ? [y]");
            boolean isInitial = false;
            if (sc.nextLine().contains("y"))
                isInitial = true;
            System.out.println("is this state final ? [y]");
            boolean isFinal = false;
            if (sc.nextLine().contains("y"))
                isFinal = true;

            V.add(new State<String>(stateName, isInitial, isFinal));

            System.out.println("End adding state [y]");
            if (sc.nextLine().contains("y"))
                break;
        }
        // sc.nextLine()
        System.out.println("print V");
        System.out.println(V);

        for (var v : V) {
            fsm.addState(v);
        }

        // -1 is can't go
        for (int i = 0; i < V.size(); i++) {
            for (int j = 0; j < V.size(); j++) {
                System.out.format("is %s connect to %s [y]\n",
                    V.get(i), V.get(j));
                // if (String weighEdgeLabel = sc.nextLine())
                String ans = sc.nextLine();
                if (!ans.contains("y")) { continue; }
                System.out.println("Enter transition label [01] to this edge.");
                String weightLabelInput = sc.nextLine();
                if (weightLabelInput.charAt(0) == '0') {
                    fsm.addTransitionEdge(V.get(i), V.get(j), 0);
                }
                else if (weightLabelInput.charAt(0) == '1') {
                    fsm.addTransitionEdge(V.get(i), V.get(j), 1);
                }
            }
        }
        int testCases = 20;
        for (int i = 0; i < testCases; i++) {
            testCaseFsmInputing(fsm);
        }
        sc.close();
    }

    public static void testCaseFsmInputing(FSMGraph<?> fsm) {
        int inputMaxLength = 8;
        int inputLength =  3 + (int)(Math.random() * inputMaxLength);
        char[] inputString = {'0', '1'};
        StringBuilder builder = new StringBuilder("");
        for (int i = 0; i < inputLength; i++) {
            int ran = (int)(Math.random() * inputString.length);
            builder.append(inputString[ran]);
        }
        boolean accept = fsm.checkIsAcceptingInput(builder.toString());
        System.out.format("inputs : %s -> %s\n", builder.toString(), accept);

    }
}
