package examples;

import java.util.Scanner;

public class RollTwoDice {
    private static int rollCount = 0;
    private static int identicalCount = 0;
    private static int totalSum = 0;
    private static int maxSum = 0;
    private static int[] faceCounts = new int[6];

    public static void main(String[] args) {
        System.out.println("Velkommen til spillet, rul to terninger. Lavet af Asger, Rasmus og Rasmus");
        printRules();
        System.out.println();

        playTwoDie();

        System.out.println();
        System.out.println("Tak for at spille, rul to terninger.");
    }

    private static void printRules() {
        System.out.println("=====================================================");
        System.out.println("Regler for rul to terninger");
        System.out.println("Spilleren ruller to terninger, så længde man lyster.");
        System.out.println("=====================================================");
    }

    private static void playTwoDie() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Rul to terninger terning? ('ja/nej') ");
        String answer = scanner.nextLine();
        while (!answer.equals("nej")) {
            int[] dice = rollDice();
            int die1 = dice[0];
            int die2 = dice[1];
            System.out.println("Du rullede: " + die1 + " og " + die2);
            System.out.println();
            int sum = die1 + die2;

            updateStatistics(dice);

            System.out.print("Rul to terninger? ('ja/nej') ");
            answer = scanner.nextLine();
        }
        printStatistics();
        scanner.close();
    }

    public static int[] rollDice() {
        int[] dice = new int[2];
        dice[0] = (int) (Math.random() * 6 + 1);
        dice[1] = (int) (Math.random() * 6 + 1);
        return dice;
    }

    private static void updateStatistics(int[] faces) {
        rollCount++;
        totalSum += faces[0] + faces[1];
        if (faces[0] == faces[1]) {
            identicalCount++;
        }
        int sum = faces[0] + faces[1];
        if (sum > maxSum) {
            maxSum = sum;
        }
        for (int i = 0; i < faces.length; i++) {
            //I kan inline variablen her, da den kun bliver brugt en gang.
            faceCounts[faces[i] - 1]++;
        }

    }

    private static void printStatistics() {
        System.out.println("\nResults:");
        System.out.println("-------");
        System.out.printf("%17s %4d\n", "Antal rul:", rollCount);
        System.out.printf("%17s %4d\n", "Total sum:", totalSum);
        System.out.printf("%17s %4d\n", "Antal ens rul:", identicalCount);
        System.out.printf("%17s %4d\n", "Største slag opnået er:", maxSum);
        System.out.println();

        //Måske en for løkke til 6 gentagelser
        System.out.println("Antal 1'ere: " + faceCounts[0]);
        System.out.println("Antal 2'ere: " + faceCounts[1]);
        System.out.println("Antal 3'ere: " + faceCounts[2]);
        System.out.println("Antal 4'ere: " + faceCounts[3]);
        System.out.println("Antal 5'ere: " + faceCounts[4]);
        System.out.println("Antal 6'ere: " + faceCounts[5]);

        for (int index = 0; index < faceCounts.length; index++) {
            System.out.println("Antal "+ (index + 1) +"'ere: " + faceCounts[index]);
        }

    }

}
