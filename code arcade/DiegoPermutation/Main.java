package DiegoPermutation;

import java.util.ArrayList;
import java.util.Scanner;

class DiegoChallenge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] attackCounts = new int[5];
        for (int i = 0; i < 5; i++) {
            attackCounts[i] = scanner.nextInt();
        }
        scanner.close();

        ArrayList<String> attackPatterns = new ArrayList<>();
        generateAttackPatterns(attackCounts, new StringBuilder(), attackPatterns, 0);

        for (String pattern : attackPatterns) {
            System.out.println(pattern);
        }
    }

    public static void generateAttackPatterns(int[] attackCounts, StringBuilder currentPattern,
                                            ArrayList<String> attackPatterns, int attackIndex) {
        if (attackIndex == attackCounts.length) {
            attackPatterns.add(currentPattern.toString());
            return;
        }

        for (int i = 0; i <= attackCounts[attackIndex]; i++) {
            StringBuilder updatedPattern = new StringBuilder(currentPattern);
            for (int j = 0; j < i; j++) {
                updatedPattern.append((char) ('A' + attackIndex));
            }
            generateAttackPatterns(attackCounts, updatedPattern, attackPatterns, attackIndex + 1);
        }
    }
}

public class Main {
    public void specialPerm(char[] chars, int pivotIndex) {

        // specialPerm(chars, pivotIndex);
    }

    public static void main(String[] args) {
        String form = "ABBC";
        Main mmm = new Main();
        mmm.specialPerm(form.toCharArray(), 2);
    }
}
