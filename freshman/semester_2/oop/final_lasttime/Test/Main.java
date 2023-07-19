package Test;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
// import java.util.concurrent.ConcurrentLinkedQueue;

class Main {
    public static void main(String[] args) {
        // // * COLLECTIONS -> เก็บ
        // List<String> l;
        // int[] ages = {18, 19, 20};

        // // ? List -> ArrayList, LinkedList
        // // * foreach
        // for (int age : ages) {
        //     System.out.println(age);
        // }
        // // * for loop
        // for (int i = 0; i < ages.length; i++) {
        //     System.out.println(ages[i]);
        // }

        // mapDictionary();

        StackDemo();
        // Queue<String> q = new ArrayList();
        // setAnimal();

    }

    public static void qDemo() {
        Queue<String> q = new PriorityQueue<>();
        q.add("J");
        q.add("J");
        q.add("J");
        q.add("B");
        q.add("M");

    }

    public static void mapDictionary() {
        // ?       Key, Value
        HashMap<String, String> englishDictionary;

        // ! initialize
        englishDictionary = new HashMap<>();
        // difficult -> very hard hard
        // EZ -> ศัพืฟื slate for teen
        englishDictionary.put("difficult", "very hard hard");
        englishDictionary.put("EZ", "ez in game");
        englishDictionary.put("zzzzzzz", "kkkkkkkkkkk");


        // ? .get
        // System.out.println(englishDictionary.get("difficult"));

        // System.out.println(englishDictionary.values());
        // * foreach
        for (String key : englishDictionary.keySet()) {
            System.out.format("key is %s : ", key);
            String value = englishDictionary.get(key);
            System.out.format("------> value is %s\n", value);
        }
    }

    public static void setAnimal() {
        Set<String> animalSet;

        animalSet = new HashSet<>();

        animalSet.add("Dog");
        animalSet.add("Dog");
        animalSet.add("Dog");
        animalSet.add("Dog");
        animalSet.add("Dog");
        animalSet.add("Dog");
        animalSet.add("Dog");
        animalSet.add("Dog");
        animalSet.add("Dogs");
        animalSet.add("Dog");
        animalSet.add("Dog");
        animalSet.add("Dog");

        System.out.println(animalSet);
        // Bird b = new Bird();
        // CanFly b = new Bird();
        // b.fly();
    }

    public static void StackDemo() {
        Stack<String> stk;

        stk = new Stack<>();

        stk.push("A");
        stk.push("B");
        stk.push("C");
        stk.push("D");
        // stk.push()
        // ! stack
        // |   |
        // | D |
        // | C |
        // | B |
        // |_A_|
        // System.out.println(stk.isEmpty());
        while (!stk.isEmpty())
            System.out.println(stk.pop());
        // System.out.println(stk.pop());
    }
}
