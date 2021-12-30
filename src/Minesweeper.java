import java.util.Arrays;
import java.util.Scanner;

public class Minesweeper {
    int row;
    int col;
    int mineNumber;
    
    Minesweeper(int row, int col) {
        this.row = row;
        this.col = col;
        this.mineNumber = (row * col) / 4;
    }

    void game() {
        char[][] mineField = new char[this.row][this.col];
        for (char[] c: mineField)
            Arrays.fill(c, '-');

        for (int i = 0; i < mineField.length; i++) {
            int mineLocation = (int) (Math.random() * row);

            for (int j = 0; j < mineField[i].length; j++) {
                if (mineField[i][mineLocation] != '*') {
                    if (this.mineNumber != 0) {
                        mineField[i][mineLocation] = '*';
                        this.mineNumber--;
                    }
                }
            }
        }
        printField(mineField);

        chooseLocation(mineField);
    }

    void chooseLocation(char[][] mineField) {
        Scanner scanner = new Scanner(System.in);
        int row, col;

        while (true) {
            System.out.println("Input row: ");
            row = scanner.nextInt();

            System.out.println("Input col");
            col = scanner.nextInt();

            if (mineField[row][col] == '*') {
                System.out.println("You loose the game... :(");
                break;
            } else {
                for (int i = 0; i < mineField.length; i++) {
                    for (int j = 0; j < mineField[0].length; j++) {
                        if (mineField[i][col] == '*' || mineField[row][j] == '*') {
                            if (Math.abs(i - row) == 1) {
                                mineField[i][j] = '1';
                            }

                            if (Math.abs(j - col) == 1) {
                                mineField[i][j] = '1';
                            }
                        }
                    }
                }
            }
        }
    }

    void printField(char[][] field) {
        System.out.println("=======================");
        for (char[] c: field) {
            for (char ch: c) {
                System.out.print(ch + " ");
            }
            System.out.println("");
        }
    }
}
