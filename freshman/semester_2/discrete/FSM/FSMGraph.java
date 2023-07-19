import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

public class FSMGraph<T> extends WeighedGraph<T> {
    private Map<State<T>, List<TransitionEdge<T>>> adjListMap;


    public FSMGraph() {
        adjListMap = new HashMap<State<T>, List<TransitionEdge<T>>>();
    }

    public void addState(State<T> s) {
        adjListMap.put(s, new LinkedList<TransitionEdge<T>>());
    }

    public void addTransitionEdge(State<T> src, State<T> dst, int weight) {
        TransitionEdge<T> edge = new TransitionEdge<>(src, dst, weight);
        adjListMap.get(src).add(edge);
    }
    public void printGraph() {
        System.out.println("print from fsm");
        System.out.println(adjListMap.keySet());
        for (State<T> vertex : this.adjListMap.keySet()) {
            System.out.printf("From source : \"%s\"\n", vertex);
            if (adjListMap.get(vertex).size() == 0) {
                System.out.println("No a single destination");
            } else {
                System.out.println("To");
                for (Edge<T> connectedEdge : adjListMap.get(vertex)) {
                    System.out.printf("\t%s", connectedEdge);
                }
            }
            System.out.println("------".repeat(20));
        }
    }

    public State<T> findInitalState() {
        return adjListMap.keySet().stream().filter(st -> st.isInitialState == true)
            .findFirst()
            .orElseGet(() -> {
                System.out.println("No a single inital state provided in this machine.");
                return null;
            });
    }

    public List<State<T>> findFinalStates() {
        return adjListMap.keySet().stream().filter(st -> st.isFinalState == true).toList();
    }

    // "0101101"
    public boolean checkIsAcceptingInput(String inputs) {
        State<T> initialState = findInitalState();
        // State<T> currentState = initialState;
        AtomicReference<State<T>> currentState = new AtomicReference<State<T>>(initialState);
        for (int i = 0; i < inputs.length(); i++) {
            // System.out.format("------------- check current input \"%s\"------------------\n",
            //     inputs.charAt(i));
            for (TransitionEdge<T> adjacentState : adjListMap.get(currentState.get())) {
                char labelOfEdge = (char)(adjacentState.weight + '0');
                // Character.valueOf(adjacentState.weight);
                // System.out.format("lable of edge is \"%s\"\n", labelOfEdge);
                // if '0' == '0'
                if (inputs.charAt(i) == labelOfEdge) {
                    // currentState = adjacentState.dst;
                    currentState.set(adjacentState.dst);
                    // System.out.println("traverse to new state");
                    // System.out.format("\t-> %s\n", currentState);
                }
            }
            // System.out.println("\n");
        }
        return findFinalStates().stream().
            // filter(finalState -> finalState.equals(currentState)).toList().isEmpty();
            filter(finalState -> finalState.equals(currentState.get())).count() != 0;
        // return currentState.equals(find);
    }
}
