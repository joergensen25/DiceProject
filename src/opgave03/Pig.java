//package opgave03; // byt til korrekt pakkenavn
//
//import java.util.Scanner;
//
//public class Pig {
//    public static final Scanner scanner = new Scanner(System.in);
//
//    public static void main(String[] args) {
//        System.out.println("Velkommen til spillet Pig (100).");
//        printRules();
//        System.out.println();
//
//        playPig();
//
//        System.out.println();
//        System.out.println("Tak for at spille Pig.");
//    }
//
//    private static void printRules() {
//        System.out.println("=====================================================");
//        System.out.println("Regler for Pig (100):");
//        System.out.println("Spillet spilles af to spillere, der skiftes til at kaste en terning.");
//        System.out.println("- En spiller kan blive ved med at kaste, indtil han selv vælger at stoppe,");
//        System.out.println("  eller indtil han slår en 1’er.");
//        System.out.println("- Slår spilleren en 1’er, mister han alle point fra denne runde.");
//        System.out.println("- Stopper spilleren frivilligt, lægges rundens point til hans samlede score.");
//        System.out.println("- Første spiller der når 100 point eller mere, vinder spillet.");
//        System.out.println("=====================================================");
//    }
//
//    public static void playPig() {
//
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Rul en terning? ('ja/nej') ");
//        String answer = scanner.nextLine();
//        while (!answer.equals("nej")) {
//            int face = rollDie();
//            if (face != 1) {
//                System.out.println("Spiller 1 rullede: " + face);
//                System.out.println();
//
//                sumPlayer1 += face;
//            } else {
//                sumPlayer1 = 0;
//            }
//// Vi blev ikke færdige med opgave 3.