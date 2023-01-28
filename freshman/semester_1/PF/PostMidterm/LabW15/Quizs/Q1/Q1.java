// package LabW15.Quizs;
package LabW15.Quizs.Q1;

import java.util.Arrays;
// import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;


public class Q1 {
    static public class ProFun14Employee {
        String name;
        String dept;
        int salary;
        int yearStart;

        ProFun14Employee(String n, String d,
        int sal, int yr) {
            name = n;
            dept = d;
            salary = sal;
            yearStart = yr;
        }

        public String toString() {
            return String.format(
                "%s %s(%d) %d",
                dept, name,yearStart, salary);
        }
    }

    static Scanner sc = new Scanner(System.in);
    public static ProFun14Employee[] getKeyboardInput(int N)
    {
        // Scanner sc = new Scanner(System.in);
        ProFun14Employee[] retArr = new ProFun14Employee[N];
        // System.out.println("N = " + N);
        for (int i = 0; i < N; i++)
        {
            String inp = "";
            for (int j = 0; j < 4; j++) {
                inp += sc.next() + " ";
            }
            String[] inputs = inp.split(" ");
            int sal = Integer.parseInt(inputs[2]);
            int yearStart = Integer.parseInt(inputs[3]);

            ProFun14Employee emp = new ProFun14Employee(
                inputs[0], inputs[1], sal, yearStart
            );
            retArr[i] = emp;
        }
        // sc.close();
        return retArr;
    }

    public static void main(String[] args) {
        // ProFun14StreamDemo demo = new ProFun14StreamDemo();
        // demo.
        // demo.eList.get(0);
        // Scanner sc = new Scanner(System.in);
        // System.out.println("Enter N :");
        int N = sc.nextInt();
        ProFun14Employee[] dm = getKeyboardInput(N);
        List<ProFun14Employee> demo = Arrays.asList(dm).stream().collect(
            Collectors.toList()
        );
        // List<String> nameList =  demo.stream().
        //         map(e -> e.name).
        //         collect(Collectors.toList());
        List<ProFun14Employee> empBefore2015;
        empBefore2015 = demo.stream()
            .filter(e -> e.yearStart < 2015)
            .collect(Collectors.toList());

        System.out.println(empBefore2015.toString());
    }
}
