import java.util.Arrays;
import java.util.Scanner;

public class Minesweeper {
    int row;
    int col;
    int mineNumber;
    int rights;
    
    Minesweeper(int row, int col) {
        this.row = row;
        this.col = col;
        this.mineNumber = (row * col) / 4;
        this.rights = (row * col) - this.mineNumber;
    }

    void game() {
        char[][] mineField = new char[this.row][this.col];
        for (char[] c: mineField)
            Arrays.fill(c, '-');

        for (int i = 0; i < mineField.length; i++) {
            int mineLocation;

            while(true) {
                mineLocation = (int) (Math.random() * row);

                if (mineLocation < col) {
                    break;
                }
            }

            for (int j = 0; j < mineField[i].length; j++) {
                if (mineField[i][mineLocation] != '*') {
                    if (this.mineNumber != 0) {
                        mineField[i][mineLocation] = '*';
                        this.mineNumber--;
                    }
                }
            }
        }

        printMinelessField(mineField);
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
                printField(mineField);
                break;
            } else {
                winTheGame(row, col, mineField);

                this.rights--;
                if (this.rights == 0) {
                    System.out.println("You win the game... :)");
                    break;
                }
            }
        }
    }

    void printField(char[][] field) {
        System.out.println("=======================");
        for (char[] c: field) {
            for (char ch: c) {
                if (ch == '1' || ch == '2') {
                    System.out.print('-' + " ");
                } else {
                    System.out.print(ch + " ");
                }
            }
            System.out.println("");
        }
    }

    void printMinelessField(char[][] field) {
        System.out.println("=======================");
        for (char[] c: field) {
            for (char ch: c) {
                if (ch == '*') {
                    System.out.print('-' + " ");
                } else {
                    System.out.print(ch + " ");
                }
            }
            System.out.println("");
        }
    }

    void winTheGame(int row, int col, char[][] array) {
        if (row != 0) {
            if (array[row - 1][col] == '*') {
                if (array[row][col] != '1') {
                    array[row][col] = '1';
                } else {
                    array[row][col]++;
                }
            }
            if (row < array.length - 1) {
                if (array[row + 1][col] == '*') {
                    if (array[row][col] != '1') {
                        array[row][col] = '1';
                    } else {
                        array[row][col]++;
                    }
                }
            }
        } else {
            if (array[row + 1][col] == '*') {
                if (array[row][col] != '1') {
                    array[row][col] = '1';
                } else {
                    array[row][col]++;
                }
            }
        }

        if (col != 0) {
            if (array[row][col - 1] == '*') {
                if (array[row][col] != '1') {
                    array[row][col] = '1';
                } else {
                    array[row][col]++;
                }
            }

            if (col < array[row].length - 1) {
                if (array[row][col + 1] == '*') {
                    if (array[row][col] != '1') {
                        array[row][col] = '1';
                    } else {
                        array[row][col]++;
                    }
                }
            }
        } else {
            if (array[row][col + 1] == '*') {
                if (array[row][col] != '1') {
                    array[row][col] = '1';
                } else {
                    array[row][col]++;
                }
            }
        }

        printMinelessField(array);
    }
}
