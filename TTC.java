import java.util.InputMismatchException;

/*************
 * TTC.java
 * Tic Tac Toe
 * @author Chris Georgiades
 * 04.29.19
 *************/

public class TTC {

    /*
     * using String array instead of char because of the methods for String.
     * Char + Char does not work and would add a lot of unnecessary for loops
     */

    private String[] board_;

    // function declarations
    public TTC() {
        board_ = new String[9]; // create the board
    }

    public boolean IsEmpty(int loc) {
        return (this.board_[loc - 1] == null);
    }

    public boolean HasOpenPlay() {
        boolean open = false;
        for (int i = 0; i < 9; ++i) {
            if (this.IsEmpty(i + 1)) {
                open = true;
            }
        }
        return open;
    }

    public void MakeMove(String c, int loc) {
        try {
            if (this.IsEmpty(loc)) {
                board_[loc - 1] = c;
            } else {
                throw new InputMismatchException();
            }
        } catch (InputMismatchException e) {
            System.out.println("This slot has already been played. Try again.");
        }
    }

    public String Win() {
        // I got some inspiration for the win check here: https://gist.github.com/xaviablaza-zz/3844825
        String result = null;
        String outcome = "noresult";

        // 8 possible win scenarios:
        for (int i = 0; i < 8; ++i) {

            switch (i) {
                case 0: {
                    result = board_[0] + board_[1] + board_[2];
                    break;
                }
                case 1: {
                    result = board_[3] + board_[4] + board_[5];
                    break;
                }
                case 2: {
                    result = board_[6] + board_[7] + board_[8];
                    break;
                }
                case 3: {
                    result = board_[0] + board_[3] + board_[6];
                    break;
                }
                case 4: {
                    result = board_[1] + board_[4] + board_[7];
                    break;
                }
                case 5: {
                    result = board_[2] + board_[5] + board_[8];
                    break;
                }
                case 6: {
                    result = board_[6] + board_[4] + board_[2];
                    break;
                }
                case 7: {
                    result = board_[0] + board_[4] + board_[8];
                    break;
                }
            }

            if (result.equals("xxx")) {
                outcome = "x";
                break;

            } else if (result.equals("ooo")) {
                outcome = "o";
                break;
            }
        }
        if (!this.HasOpenPlay()) {
            outcome = "draw";
        }
        return outcome;
    }


    public void PrintBoard() {

        // make a copy to show location #'s
        String[] board = new String[9];
        System.arraycopy(this.board_, 0, board, 0, 9);

        for (int i = 0; i < 9; ++i) {
            if (this.IsEmpty(i + 1)) {
                board[i] = Integer.toString(i + 1);
            }
        }
        System.out.print("\n  | FSU: Tic Tac Toe |\n");
        System.out.printf("\n   %s   |   %s   |   %s   \n", board[0], board[1], board[2]);
        System.out.printf("\n   %s   |   %s   |   %s   \n", board[3], board[4], board[5]);
        System.out.printf("\n   %s   |   %s   |   %s   \n", board[6], board[7], board[8]);
        System.out.print("\n  | Chris Georgiades |\n\n");
    }
}
