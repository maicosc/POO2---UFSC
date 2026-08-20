//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        System.out.println("Inicio aula 2");
        int[][] movesKnight = {{-1, 2},
                                {-2,1},
                                {-2, -1},
                                {-1, -2},
                                {1, -2},
                                {2, -1},
                                {2, 1},
                                {1, 2}};
        int[][] board = new int[8][];
        for(int s = 0; s< board.length; s++){
            board[s] = new int[8];
        }
        int counter = 1;
        int currentRow = 3;
        int currentColumn = 4;
        boolean isThereHoleSquares = true;
        while (isThereHoleSquares && counter <= 64){
            board[currentRow][currentColumn] = counter;
            boolean toContinue = true;
            int m = 0;
            while (toContinue && m < movesKnight.length){
                int row = currentRow + movesKnight[m][0];
                int column = currentColumn + movesKnight[m][1];
                if ( row < board.length && column < board[0].length && row >= 0 && column >= 0 && board[row][column] == 0){
                    currentRow += movesKnight[m][0];
                    currentColumn += movesKnight[m][1];
                    counter++;
                    toContinue = false;
                }
                m++;
            }
            isThereHoleSquares = !toContinue;
        }

        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                System.out.printf("%2d ", board[i][j]);
            }
            System.out.printf("\n");
        }
        board = new int[][]{{2, 2, 3, 3, 4, 4, 4, 4},
                            {3, 3, 4, 4, 6, 6, 6, 6},
                            {4, 4, 6, 6, 8, 8, 8, 8},
                            {4, 4, 6, 6, 8, 8, 8, 8},
                            {4, 4, 6, 6, 8, 8, 8, 8},
                            {4, 4, 6, 6, 8, 8, 8, 8},
                            {3, 3, 4, 4, 6, 6, 6, 6},
                            {2, 2, 3, 3, 4, 4, 4, 4}};
        counter = 1;
        currentRow = 3;
        currentColumn = 4;
        isThereHoleSquares = true;
        while (isThereHoleSquares && counter <= 64){
            board[currentRow][currentColumn] = -1;
            boolean toContinue = true;
            int m = 0;
            while (toContinue && m < movesKnight.length){
                int row = currentRow + movesKnight[m][0];
                int column = currentColumn + movesKnight[m][1];
                if ( row < board.length && column < board[0].length && row >= 0 && column >= 0 && board[row][column] > 0){
                    currentRow += movesKnight[m][0];
                    currentColumn += movesKnight[m][1];
                    counter++;
                    toContinue = false;
                } else if (row < board.length && column < board[0].length && row >= 0 && column >= 0 && board[row][column] == -1) {
                    currentRow += movesKnight[m][0];
                    currentColumn += movesKnight[m][1];
                    counter++;
                    toContinue = false;
                }
                m++;
            }
            isThereHoleSquares = !toContinue;
        }

    }
}