import java.util.Scanner;

/*************
 * ttc_driver.java
 * Tic Tac Toe
 * @author Chris Georgiades
 * 04.29.19
 *************/

public class ttc_driver {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        boolean win = false;
        int count = 0;
        String x = new String("x");
        String o = new String("o");
        String[] players = {x, o};
        TTC ttc = new TTC();
        String outcome = null;

        System.out.print("Who goes first? 0 for 'x', 1 for 'o': ");
        int i = input.nextInt();
        int choice;

        ttc.PrintBoard();

        while (!win) {

            System.out.print("Player " + players[i] + " make your move: ");
            choice = input.nextInt();
            ttc.MakeMove(players[i], choice);
            ttc.PrintBoard();
            ++i;
            i %= 2;
            ++count;

            if (count > 4) {

                outcome = ttc.Win();

                if (outcome.equals("x") || outcome.equals("o")) {
                    win = true;
                    System.out.println("The winner is: " + outcome + ". Congrats!");
                } else if (outcome.equals("draw")) {
                    win = true;
                    System.out.println("The game ended in a draw");
                }
            }
        }
        input.close();
    }
}

