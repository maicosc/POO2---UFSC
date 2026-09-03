package exercicios.exe7_25;

public class exe7_25b {
    static final int SIZE = 8;
    static int[] columns = new int[SIZE];
    static int solutionCount = 0;

    public static void main(String[] args) {
        placeQueen(0);
        System.out.println("Total solutions found: " + solutionCount);
    }

    private static void placeQueen(int row) {
        if (row == SIZE) {
            solutionCount++;
            if (solutionCount == 1) {
                printBoard();
            }
            return;
        }

        for (int column = 0; column < SIZE; column++) {
            columns[row] = column;
            if (isValid(row)) {
                placeQueen(row + 1);
            }
        }
    }

    private static boolean isValid(int row) {
        for (int previousRow = 0; previousRow < row; previousRow++) {
            if (columns[previousRow] == columns[row]) {
                return false;
            }
            if (Math.abs(columns[previousRow] - columns[row]) == Math.abs(previousRow - row)) {
                return false;
            }
        }
        return true;
    }

    private static void printBoard() {
        System.out.println("First solution found:");
        for (int row = 0; row < SIZE; row++) {
            for (int column = 0; column < SIZE; column++) {
                System.out.print(column == columns[row] ? " Q " : " . ");
            }
            System.out.println();
        }
    }
}
