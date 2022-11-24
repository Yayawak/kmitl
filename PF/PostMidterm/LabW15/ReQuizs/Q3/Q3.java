// package LabW15.Quizs;
package LabW15.Quizs.Q3;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class Q3 {
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
        ProFun14Employee[] retArr = new ProFun14Employee[N];
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
        return retArr;
    }

    public static void main(String[] args) {
        int N = sc.nextInt();
        ProFun14Employee[] dm = getKeyboardInput(N);

        int min = Integer.MAX_VALUE;
        int minIdx = 0;
        for (int i = 0; i < N; i++)
        {
            if (dm[i].getSalary() < min)
            {
                min = dm[i].getSalary();
                minIdx = i;
            }
        }
        System.out.println(dm[minIdx]);

    }
}
