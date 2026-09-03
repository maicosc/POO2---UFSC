package exercicios.exe7_24;

public class exe7_24 {
    static final int SIZE = 8;

    public static void main(String[] args) {
        boolean[][] eliminated = new boolean[SIZE][SIZE];
        int[] queenRow = new int[SIZE];
        int[] queenColumn = new int[SIZE];
        int queensPlaced = 0;

        while (queensPlaced < SIZE) {
            int bestRow = -1;
            int bestColumn = -1;
            int bestScore = Integer.MAX_VALUE;

            for (int row = 0; row < SIZE; row++) {
                for (int column = 0; column < SIZE; column++) {
                    if (!eliminated[row][column]) {
                        int score = countElimination(eliminated, row, column);
                        if (score < bestScore) {
                            bestScore = score;
                            bestRow = row;
                            bestColumn = column;
                        }
                    }
                }
            }

            if (bestRow == -1) {
                break;
            }

            queenRow[queensPlaced] = bestRow;
            queenColumn[queensPlaced] = bestColumn;
            queensPlaced++;
            markEliminated(eliminated, bestRow, bestColumn);
        }

        if (queensPlaced == SIZE) {
            System.out.println("Solution found:");
            printBoard(queenRow, queenColumn);
        } else {
            System.out.println("Heuristic stopped after placing " + queensPlaced + " queens");
        }
    }

    private static int countElimination(boolean[][] eliminated, int row, int column) {
        int count = 1;

        for (int i = 0; i < SIZE; i++) {
            if (i != column && !eliminated[row][i]) {
                count++;
            }
            if (i != row && !eliminated[i][column]) {
                count++;
            }
        }

        for (int i = 1; i < SIZE; i++) {
            int r1 = row + i;
            int c1 = column + i;
            if (r1 < SIZE && c1 < SIZE && !eliminated[r1][c1]) {
                count++;
            }
            int r2 = row - i;
            int c2 = column - i;
            if (r2 >= 0 && c2 >= 0 && !eliminated[r2][c2]) {
                count++;
            }
            int r3 = row + i;
            int c3 = column - i;
            if (r3 < SIZE && c3 >= 0 && !eliminated[r3][c3]) {
                count++;
            }
            int r4 = row - i;
            int c4 = column + i;
            if (r4 >= 0 && c4 < SIZE && !eliminated[r4][c4]) {
                count++;
            }
        }

        return count;
    }

    private static void markEliminated(boolean[][] eliminated, int row, int column) {
        for (int i = 0; i < SIZE; i++) {
            eliminated[row][i] = true;
            eliminated[i][column] = true;
        }

        for (int i = 1; i < SIZE; i++) {
            if (row + i < SIZE && column + i < SIZE) {
                eliminated[row + i][column + i] = true;
            }
            if (row - i >= 0 && column - i >= 0) {
                eliminated[row - i][column - i] = true;
            }
            if (row + i < SIZE && column - i >= 0) {
                eliminated[row + i][column - i] = true;
            }
            if (row - i >= 0 && column + i < SIZE) {
                eliminated[row - i][column + i] = true;
            }
        }
    }

    private static void printBoard(int[] queenRow, int[] queenColumn) {
        int[][] board = new int[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            board[queenRow[i]][queenColumn[i]] = 1;
        }

        for (int row = 0; row < SIZE; row++) {
            for (int column = 0; column < SIZE; column++) {
                System.out.print(board[row][column] == 1 ? " Q " : " . ");
            }
            System.out.println();
        }
    }
}
