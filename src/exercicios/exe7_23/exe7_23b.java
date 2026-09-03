package exercicios.exe7_23;

import java.util.Random;

public class exe7_23b {
    static int[] horizontal = {2, 1, -1, -2, -2, -1, 1, 2};
    static int[] vertical = {-1, -2, -2, -1, 1, 2, 2, 1};

    public static void main(String[] args) {
        int[] lengthCount = new int[65];
        Random random = new Random();
        int bestLength = 0;

        for (int trial = 0; trial < 1000; trial++) {
            int length = runRandomTour(random);
            lengthCount[length]++;
            if (length > bestLength) {
                bestLength = length;
            }
        }

        System.out.println("Length  Count");
        for (int length = 1; length <= 64; length++) {
            if (lengthCount[length] > 0) {
                System.out.printf("%4d %8d%n", length, lengthCount[length]);
            }
        }
        System.out.println("Best result: " + bestLength);
    }

    private static int runRandomTour(Random random) {
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

        return moveCount;
    }

    private static boolean isValidMove(int[][] board, int row, int column) {
        return row >= 0 && row < 8 && column >= 0 && column < 8 && board[row][column] == 0;
    }
}
