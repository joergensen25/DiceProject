package opgave02;

import java.util.Scanner;

public class Craps {
    public static final Scanner scanner = new Scanner(System.in);

    private static int wins = 0;
    private static int losses = 0;

    public static void main(String[] args) {
        System.out.println("Velkommen til spillet Craps. Lavet af Asger, Rasmus og Rasmus");
        printRules();
        System.out.println();

        playCraps();

        System.out.println();

        printStatistics();
        System.out.println("Tak for at spille Craps.");
    }
    private static void printRules() {
        System.out.println("=====================================================");
        System.out.println("Regler for Craps:");
        System.out.println("Spilleren ruller to terninger. Udfaldet af et kast er " +
                "summen af øjne på de to terninger.");
        System.out.println("Det første kast er 'come out roll.");
        System.out.println("Spilleren vinder med det samme, hvis første kast er 7 eller 11.");
        System.out.println("Spilleren taber med det samme, hvis første kast er 2, 3 eller 12.");
        System.out.println("Slår spilleren et andet tal mellem 1-12, er dette spillerens 'point'.");
        System.out.println("Spillet fortsætter, indtil spilleren slår 7 eller sit 'point'.");
        System.out.println("Slår spilleren sit 'point', vinder spilleren. Slår spilleren 7, taber spilleren.");
        System.out.println("=====================================================");
    }

    public static void playCraps() {
        System.out.println("Klar til at begynde? ('ja/nej')");
        String answer = scanner.nextLine();

        while (answer.equalsIgnoreCase("nej")) {
            System.out.println("Okay, hvad med nu? ('ja/nej')");
            answer = scanner.nextLine();
        }
        while (!answer.equalsIgnoreCase("nej")) {
            int first = rollTwoDice();
            System.out.println("Come out roll: " + first + ".");

            if (first == 7 || first == 11) {
                System.out.println("Resultat: DU VINDER (7 eller 11 på come out roll).");
                wins++;
            } else if (first == 2 || first == 3 || first == 12) {
                System.out.println("Resultat: DU TABER (2, 3 eller 12 på come out roll).");
                losses++;
            } else {
                //Ingen grund til at introducerer en ny variable
                System.out.println("Point er sat til: " + first + ". Der kastes indtil point eller 7.");
                //Højreklik på 'gotPoint' -> Refactor -> Inline variable
                boolean gotPoint = rollForPoint(first);
                if (gotPoint) {
                    System.out.println("Resultat: DU VINDER (du rullede dit point igen).");
                    wins++;
                } else {
                    System.out.println("Resultat: DU TABER (du rullede 7.");
                    losses++;
                }
            }
            System.out.println();
            System.out.println("Vil du spille igen? ('ja/nej')");
            answer = scanner.nextLine();
        }

    }
    public static boolean rollForPoint (int point) {
        while (true) {
            waitForEnter();
            int roll = rollTwoDice();
            System.out.println("Du rullede: " + roll);
            if (roll == point) {
                return true;
            }
            else if (roll == 7) {
                return false;
            }
        }
    }


    private static int rollTwoDice() {
        int d1 = (int) (Math.random() * 6 + 1); // Ruller en terning med 6 sider
        int d2 = (int) (Math.random() * 6 + 1); // Ruller en anden terning med 6 sider
        System.out.println("Terning 1: " + d1 + " Terning 2: " + d2);
        return d1 + d2;
    }

    private static void waitForEnter() {
        System.out.println("Klar til at slå? (tryk på Enter)");
        scanner.nextLine();
    }

    private static void printStatistics() {
        System.out.println("\nResults: ");
        System.out.println("---------");
        System.out.println("Antal sejre: " + wins);
        System.out.println("Antal tabte: " + losses);

    }
}
