package me.lectr1c.F7;

public class NQueens {
    public static void main(String[] args) {
        addQueen(8);
    }

    private static int nrOfSolutions;

    public static void addQueen(int size){
        boolean[][] board = new boolean[size][size];
        boolean[][] diagonals = new boolean[2][size*2];
        nrOfSolutions = 0;
        addQueen(board, 0, diagonals);
    }

    public static void addQueen(boolean[][] board, int row, boolean[][] diagonals){
        for (int col = 0; col < board.length; col++) {
            if (isAvailable(board, col, row, diagonals)) {
                diagonals[0][row + col] = true;
                diagonals[1][row - col + board.length] = true;
                board[col][row] = true;

                if (row == board.length-1) {
                    nrOfSolutions++;
                    printBoard(board);
                    System.out.println("Nr of solutions: " + nrOfSolutions);
                } else {
                    addQueen(board, row + 1, diagonals);
                }

                diagonals[0][row + col] = false;
                diagonals[1][row - col + board.length] = false;
                board[col][row] = false;
            }
        }
    }

    private static void printBoard(boolean[][] board) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board.length; j++){
                char ch = board[i][j] ? 'Q' : '.';
                sb.append(ch).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    private static boolean isAvailable(boolean[][] board, int col, int row, boolean[][] diagonals) {
        int neDiagonal = col + row;
        int nwDiagonal = row - col + board.length;
        for (int i = 0; i < board.length; i++){
            if (board[col][i]) return false;
        }
        if (diagonals[0][neDiagonal]) return false;
        if (diagonals[1][nwDiagonal]) return false;
        return true;
    }

}
