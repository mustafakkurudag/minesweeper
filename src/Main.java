import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int row, col;

        System.out.println("What is the row: ");
        row = scanner.nextInt();

        System.out.println("What is the col: ");
        col = scanner.nextInt();

        Minesweeper minesweeper = new Minesweeper(row, col);
        minesweeper.game();
    }
}
