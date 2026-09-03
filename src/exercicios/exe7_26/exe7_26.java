package exercicios.exe7_26;

public class exe7_26 {
    static int[] horizontal = {2, 1, -1, -2, -2, -1, 1, 2};
    static int[] vertical = {-1, -2, -2, -1, 1, 2, 2, 1};

    public static void main(String[] args) {
        int[][] board = new int[8][8];
        int startRow = 3;
        int startColumn = 3;
        int moveCount = runTour(board, startRow, startColumn);

        printBoard(board);
        System.out.println("Moves completed: " + moveCount);

        if (moveCount == 64) {
            if (isClosedTour(board, startRow, startColumn)) {
                System.out.println("This is a closed tour");
            } else {
                System.out.println("This is an open tour");
            }
        } else {
            System.out.println("Tour did not complete, closed tour test does not apply");
        }
    }

    private static boolean isClosedTour(int[][] board, int startRow, int startColumn) {
        for (int moveNumber = 0; moveNumber < 8; moveNumber++) {
            int testRow = startRow + vertical[moveNumber];
            int testColumn = startColumn + horizontal[moveNumber];
            if (testRow >= 0 && testRow < 8 && testColumn >= 0 && testColumn < 8) {
                if (board[testRow][testColumn] == 64) {
                    return true;
                }
            }
        }
        return false;
    }

    private static int runTour(int[][] board, int startRow, int startColumn) {
        int currentRow = startRow;
        int currentColumn = startColumn;
        board[currentRow][currentColumn] = 1;
        int moveCount = 1;

        while (moveCount < 64) {
            int bestRow = -1;
            int bestColumn = -1;
            int bestAccessibility = 9;

            for (int moveNumber = 0; moveNumber < 8; moveNumber++) {
                int nextRow = currentRow + vertical[moveNumber];
                int nextColumn = currentColumn + horizontal[moveNumber];
                if (isValidMove(board, nextRow, nextColumn)) {
                    int accessibility = countAccessibility(board, nextRow, nextColumn);
                    if (accessibility < bestAccessibility) {
                        bestAccessibility = accessibility;
                        bestRow = nextRow;
                        bestColumn = nextColumn;
                    }
                }
            }

            if (bestRow == -1) {
                break;
            }

            currentRow = bestRow;
            currentColumn = bestColumn;
            moveCount++;
            board[currentRow][currentColumn] = moveCount;
        }

        return moveCount;
    }

    private static int countAccessibility(int[][] board, int row, int column) {
        int count = 0;
        for (int moveNumber = 0; moveNumber < 8; moveNumber++) {
            int nextRow = row + vertical[moveNumber];
            int nextColumn = column + horizontal[moveNumber];
            if (isValidMove(board, nextRow, nextColumn)) {
                count++;
            }
        }
        return count;
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
