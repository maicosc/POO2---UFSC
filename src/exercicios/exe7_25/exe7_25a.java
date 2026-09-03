package exercicios.exe7_25;

import java.util.Random;

public class exe7_25a {
    static final int SIZE = 8;

    public static void main(String[] args) {
        Random random = new Random();
        int[] columns = new int[SIZE];
        long attempts = 0;
        boolean solved = false;

        while (!solved) {
            for (int row = 0; row < SIZE; row++) {
                columns[row] = random.nextInt(SIZE);
            }
            attempts++;
            solved = isValidPlacement(columns);
        }

        System.out.println("Solution found after " + attempts + " attempts");
        printBoard(columns);
    }

    private static boolean isValidPlacement(int[] columns) {
        for (int row1 = 0; row1 < SIZE; row1++) {
            for (int row2 = row1 + 1; row2 < SIZE; row2++) {
                if (columns[row1] == columns[row2]) {
                    return false;
                }
                if (Math.abs(columns[row1] - columns[row2]) == Math.abs(row1 - row2)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void printBoard(int[] columns) {
        for (int row = 0; row < SIZE; row++) {
            for (int column = 0; column < SIZE; column++) {
                System.out.print(column == columns[row] ? " Q " : " . ");
            }
            System.out.println();
        }
    }
}
