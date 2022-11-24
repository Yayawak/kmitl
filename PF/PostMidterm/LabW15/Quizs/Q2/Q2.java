// package LabW15.Quizs;
package LabW15.Quizs.Q2;

import java.util.Arrays;
// import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class Q2 {
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

        int getSalary() {
            return salary;
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
                // sc.nextLine()
                inp += sc.next() + " ";
            }
            // String inp = sc.next();
            // String inp = sc.nextLine();
            // sc.next
            // System.out.println("inp = " + inp);
            // String inp = sc.next();
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
        // sc.close();
        // System.out.println("Enter EMPS :");
        ProFun14Employee[] dm = getKeyboardInput(N);
        List<ProFun14Employee> demo = Arrays.asList(dm).stream().collect(
            Collectors.toList()
        );
        // demo.eList.to
        // List<String> nameList =  demo.eList.stream().
        // List<String> nameList =  demo.stream().
        //         map(e -> e.name).
        //         collect(Collectors.toList());
        int sum = demo.stream()
            .collect(Collectors.summingInt(
                // ProFun14Employee::new
                ProFun14Employee::getSalary
            ));

        System.out.println(sum);
        // demo.eList.stream().forEach(e -> System.out.println(e););


        // demo.
        // sc.close();
    }
}
