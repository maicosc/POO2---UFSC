package exercicios.exe7_22;

public class exe7_22d {
    static int[] horizontal = {2, 1, -1, -2, -2, -1, 1, 2};
    static int[] vertical = {-1, -2, -2, -1, 1, 2, 2, 1};

    public static void main(String[] args) {
        int[][] board = new int[8][8];
        int moveCount = runTour(board, 4, 4);
        printBoard(board);
        System.out.println("Moves completed: " + moveCount);
    }

    private static int runTour(int[][] board, int startRow, int startColumn) {
        int currentRow = startRow;
        int currentColumn = startColumn;
        board[currentRow][currentColumn] = 1;
        int moveCount = 1;

        while (moveCount < 64) {
            int candidateCount = 0;
            int[] candidateRows = new int[8];
            int[] candidateColumns = new int[8];
            int[] candidateAccessibility = new int[8];
            int bestAccessibility = 9;

            for (int moveNumber = 0; moveNumber < 8; moveNumber++) {
                int nextRow = currentRow + vertical[moveNumber];
                int nextColumn = currentColumn + horizontal[moveNumber];
                if (isValidMove(board, nextRow, nextColumn)) {
                    int accessibility = countAccessibility(board, nextRow, nextColumn);
                    candidateRows[candidateCount] = nextRow;
                    candidateColumns[candidateCount] = nextColumn;
                    candidateAccessibility[candidateCount] = accessibility;
                    candidateCount++;
                    if (accessibility < bestAccessibility) {
                        bestAccessibility = accessibility;
                    }
                }
            }

            if (candidateCount == 0) {
                break;
            }

            int chosenRow = -1;
            int chosenColumn = -1;
            int bestLookAhead = 9;

            for (int i = 0; i < candidateCount; i++) {
                if (candidateAccessibility[i] == bestAccessibility) {
                    board[candidateRows[i]][candidateColumns[i]] = moveCount + 1;
                    int lookAhead = countBestNextAccessibility(board, candidateRows[i], candidateColumns[i]);
                    board[candidateRows[i]][candidateColumns[i]] = 0;
                    if (chosenRow == -1 || lookAhead < bestLookAhead) {
                        bestLookAhead = lookAhead;
                        chosenRow = candidateRows[i];
                        chosenColumn = candidateColumns[i];
                    }
                }
            }

            currentRow = chosenRow;
            currentColumn = chosenColumn;
            moveCount++;
            board[currentRow][currentColumn] = moveCount;
        }

        return moveCount;
    }

    private static int countBestNextAccessibility(int[][] board, int row, int column) {
        int best = 9;
        for (int moveNumber = 0; moveNumber < 8; moveNumber++) {
            int nextRow = row + vertical[moveNumber];
            int nextColumn = column + horizontal[moveNumber];
            if (isValidMove(board, nextRow, nextColumn)) {
                int accessibility = countAccessibility(board, nextRow, nextColumn);
                if (accessibility < best) {
                    best = accessibility;
                }
            }
        }
        return best;
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
