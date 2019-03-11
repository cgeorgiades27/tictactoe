import java.util.Scanner;

public class TicTacToe {
    // private char [][] board = new char[3][3];
    private char c;
    private String name_;
    boolean win = false;

    public boolean CheckWin(char[][] board) {

        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                if (board[i][j] == this.c)
                    win = true;
                win = false;
            }
        }
        return win;
    }

    public void SetName(String name) {
        this.name_ = name;
    }

    public void SetType(char input) {
        this.c = input;
    }

    public char GetType() {
        return this.c;
    }
}