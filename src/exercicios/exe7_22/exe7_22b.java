package exercicios.exe7_22;

public class exe7_22b {
    public static void main(String[] args) {
        int[][] board = new int[8][8];
        int[] horizontal = {2, 1, -1, -2, -2, -1, 1, 2};
        int[] vertical = {-1, -2, -2, -1, 1, 2, 2, 1};

        int currentRow = 4;
        int currentColumn = 4;
        board[currentRow][currentColumn] = 1;
        int moveCount = 1;
        boolean moved = true;

        while (moveCount < 64 && moved) {
            moved = false;
            for (int moveNumber = 0; moveNumber < 8; moveNumber++) {
                int nextRow = currentRow + vertical[moveNumber];
                int nextColumn = currentColumn + horizontal[moveNumber];
                if (isValidMove(board, nextRow, nextColumn)) {
                    currentRow = nextRow;
                    currentColumn = nextColumn;
                    moveCount++;
                    board[currentRow][currentColumn] = moveCount;
                    moved = true;
                    moveNumber = 7;
                }
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
