package BasicSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MyArrDemo<T> {
    public final int MAX_SIZE = 9;
    private int size = 0;
    private Object[] arr = new Object[MAX_SIZE];
    // private T[] arr = new T[MAX_SIZE];

    public void add(T instance) {
        arr[size++] = instance;
    }

    public void set(int i, T instance) {
        arr[i] = instance;
    }

    public T get(int i) {
        @SuppressWarnings("unchecked")
        final T element = (T) arr[i];
        return element;
    }

    public void swap(int i, int j) {
        // your code
        Object temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public int currentSize() {
        return size;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("My snapshot looks like this -> ");
        for (int i = 0; i < size; i++)
            sb.append(arr[i] + ",");
        return sb.toString();
    }

    static void demo4() {
        System.out.println("-demo4----");
        
        MyArrDemo<SillyLuckyNumber> arr = new MyArrDemo<>();
        arr.add(new SillyLuckyNumber("Terrier"));
        arr.add(new SillyLuckyNumber("Jack"));
        arr.add(new SillyLuckyNumber("Pom"));
        arr.add(new SillyLuckyNumber("Beagle"));
        System.out.println(arr);
        arr.swap(1,3);
        System.out.println(arr);
    }
    
    static void demo5() {
        System.out.println("-demo5----");
        MyArrDemo<SillyLuckyNumber> arr = new MyArrDemo<>();
        arr.add(new SillyLuckyNumber("Terrier"));
        arr.add(new SillyLuckyNumber("Jack"));
        arr.add(new SillyLuckyNumber("Pom"));
        arr.add(new SillyLuckyNumber("Beagle"));
        arr.add(new SillyLuckyNumber("Cocker Spaniel"));
        arr.add(new SillyLuckyNumber("Basenji"));
        System.out.println(arr);
        selectionSort(arr);
        System.out.println(arr);
    }

    // static void selectionSort(List<SillyLuckyNumber> arr)
    static void selectionSort(MyArrDemo<SillyLuckyNumber> arr)
    {
        for (int i = 0; i < arr.size; i++)
        {
            // int min = 500000;
            // SillyLuckyNumber pivot = arr.get(i);
            // SillyLuckyNumber minSLN = pivot;
            int minIndex = i;
            for (int j = i + 1; j < arr.size; j++)
            {
                SillyLuckyNumber considering = arr.get(j);
                // if (arr.get(j).getLuckyNumber() < min)
                // if (considering.getLuckyNumber() < minSLN.getLuckyNumber())
                if (considering.getLuckyNumber() < arr.get(minIndex).getLuckyNumber())
                // if (considering.getLuckyNumber() < arr.get(j).getLuckyNumber())
                {
                    // min = arr.get(j).getLuckyNumber();
                    // minSLN = considering;
                    minIndex = j;
                }
            }
            // swap
            if (minIndex != i)
                arr.swap(i, minIndex);
        }
    }

    public static void main(String[] args) {
        // demo4();
        demo5();
    }

}