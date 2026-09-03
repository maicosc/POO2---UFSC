package exercicios.exe7_22;

public class exe7_22c {
    static int[] horizontal = {2, 1, -1, -2, -2, -1, 1, 2};
    static int[] vertical = {-1, -2, -2, -1, 1, 2, 2, 1};

    public static void main(String[] args) {
        int[][] board = new int[8][8];
        printBoard(board);
        int moveCount = runTour(board, 4, 4);
        printBoard(board);
        System.out.println("Moves completed starting at (4,4): " + moveCount);

        int completeTours = 0;
        for (int startRow = 0; startRow < 8; startRow++) {
            for (int startColumn = 0; startColumn < 8; startColumn++) {
                int[][] testBoard = new int[8][8];
                int result = runTour(testBoard, startRow, startColumn);
                if (result == 64) {
                    completeTours++;
                }
            }
        }
        System.out.println("Complete tours out of 64 starting squares: " + completeTours);
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
                moveCount = 64;
            }

            currentRow = bestRow;
            currentColumn = bestColumn;
            moveCount++;
            if (moveCount <= 64) {
                board[currentRow][currentColumn] = moveCount;
            }
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
