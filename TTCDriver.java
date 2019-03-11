import java.util.Scanner;
import java.util.Arrays;

public class TTCDriver {

    private char[][] board = new char[3][3];
    private boolean win = false;
    private char play;

    public void Init(char fill) {
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                board[i][j] = fill;
            }
        }
    }

    public void Menu() {

        String line = new String(new char[21]).replace('\0', '-');
        System.out.println(line);
        System.out.print("|         FSU       |\n");
        System.out.println(line);
        System.out.printf("\n   %c  |   %c   |   %c   \n", board[0][0], board[0][1], board[0][2]);
        System.out.println(line);
        System.out.printf("   %c  |   %c   |   %c   \n", board[1][0], board[1][1], board[1][2]);
        System.out.println(line);
        System.out.printf("   %c  |   %c   |   %c   \n\n", board[2][0], board[2][1], board[2][2]);
    }
    public static void main(String[] args) {

        TTCDriver ttcd = new TTCDriver();
        TicTacToe p1 = new TicTacToe();
        TicTacToe p2 = new TicTacToe();
        Scanner input = new Scanner(System.in);

        System.out.print("Enter player 1's name: ");
        p1.SetName(input.next());
        p1.SetType('x');
        System.out.printf("Player 1 is: %c\n", p1.GetType());

        System.out.print("Enter player 2's name: ");
        p2.SetName(input.next());
        p2.SetType('o');
        System.out.printf("Player 2 is: %c\n", p2.GetType());

        ttcd.Init('*');
        ttcd.Menu();

        while (!ttcd.win) {
                        
        }
    }
}