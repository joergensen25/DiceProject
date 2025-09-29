package opgave03;

import static opgave02.Craps.scanner;

public class Pigs {
    public static void main(String[] args) {
        playCraps();
    }

    public static void playCraps() {
        System.out.println("Klar til at begynde? ('ja/nej')");
        String answer = scanner.nextLine();
        while (answer.equalsIgnoreCase("nej")) {
            System.out.println("Okay, hvad med nu? ('ja/nej')");
            answer = scanner.nextLine();
        }
        while (!answer.equalsIgnoreCase("nej")) {
            int face = rollDie();

            if (face == 1) {
                System.out.println("Du rullede: " + face);
                System.out.println("Du får ingen point, og turen går videre");
            }
            else {
                int pointRound = face;
                System.out.println("Du rullede: " + face);
                System.out.println("Point er sat til: " + pointRound);

                }
            }
            System.out.println();
            System.out.println("Vil du rulle igen tast 1. Vil du give turen videre tast 2. ('1/2')");
            answer = scanner.nextLine();
        }


    private static int rollDie () {return (int) (Math.random() * 6 + 1);}
            }