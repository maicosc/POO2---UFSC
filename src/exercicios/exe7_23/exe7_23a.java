package exercicios.exe7_23;

import java.util.Random;

public class exe7_23a {
    static int[] horizontal = {2, 1, -1, -2, -2, -1, 1, 2};
    static int[] vertical = {-1, -2, -2, -1, 1, 2, 2, 1};

    public static void main(String[] args) {
        Random random = new Random();
        int[][] board = new int[8][8];
        int currentRow = random.nextInt(8);
        int currentColumn = random.nextInt(8);
        board[currentRow][currentColumn] = 1;
        int moveCount = 1;
        boolean moved = true;

        while (moveCount < 64 && moved) {
            int[] validMoves = new int[8];
            int validCount = 0;

            for (int moveNumber = 0; moveNumber < 8; moveNumber++) {
                int nextRow = currentRow + vertical[moveNumber];
                int nextColumn = currentColumn + horizontal[moveNumber];
                if (isValidMove(board, nextRow, nextColumn)) {
                    validMoves[validCount] = moveNumber;
                    validCount++;
                }
            }

            if (validCount == 0) {
                moved = false;
            } else {
                int chosen = validMoves[random.nextInt(validCount)];
                currentRow += vertical[chosen];
                currentColumn += horizontal[chosen];
                moveCount++;
                board[currentRow][currentColumn] = moveCount;
            }
        }

        printBoard(board);
        System.out.println("Total moves: " + moveCount);
    }

    private static boolean isValidMove(int[][] board, int row, int column) {
        return row >= 0 && row < 8 && column >= 0 && column < 8 && board[row][column] == 0;
    }

    private static void printBoard(int[][] board) {
        for (int row = 0; row < 8; row++) {
            for (int column = 0; column < 8; column++) {
                System.out.printf("%3d", board[row][column]);
            }
            System.out.println();
        }
    }
}
