package me.lectr1c.LABA.LAB3;

public class Puzzle {

    public static void main(String[] args) {
        var puzzle = new Puzzle(4, 4, 5, 8);
        puzzle.solve();
    }

    public static class Piece {
        public int x1, y1, x2, y2, x3, y3;
        public int rotation;
        public char pieceChar;

        public Piece(int x, int y, int rotation) {
            this.x1 = x;
            this.y1 = y;

            this.rotation = rotation;
            switch (rotation) {
                case 0 -> {
                    x2 = x;
                    y2 = y + 1;
                    x3 = x - 1;
                    y3 = y + 1;
                    pieceChar = 'O';
                }
                case 1 -> {
                    x2 = x - 1;
                    y2 = y;
                    x3 = x - 1;
                    y3 = y - 1;
                    pieceChar = 'R';
                }
                case 2 -> {
                    x2 = x;
                    y2 = y - 1;
                    x3 = x + 1;
                    y3 = y - 1;
                    pieceChar = 'S';
                }
                case 3 -> {
                    x2 = x + 1;
                    y2 = y;
                    x3 = x + 1;
                    y3 = y + 1;
                    pieceChar = 'M';
                }
            }
        }
    }

    private static class Cell {
        public boolean state;
        public char cellChar;

        public Cell(boolean state, char cellChar) {
            this.state = state;
            this.cellChar = cellChar;
        }
    }

    private final Cell[][] board;
    private int noSolutions = 0;
    private final int availablePcs;

    public Puzzle(int xGrey, int yGrey, int boardSize, int solveCondition) {
        board = new Cell[boardSize][boardSize];
        this.availablePcs = solveCondition;
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                board[i][j] = new Cell(false, ' ');
            }
        }
        board[yGrey][xGrey] = new Cell(true, 'X');
    }

    public void solve() {
        solve(0, 0, 0);
        System.out.println(noSolutions == 0 ? "No solutions found" : noSolutions + " solutions found");
    }

    private void solve(int placedPieces, int rowIn, int columnIn) {
        if (rowIn >= board.length) {
            return;
        }

        if (placedPieces == availablePcs) {
            noSolutions++;
            System.out.println(this);
            return;
        }

        for (int column = columnIn; column < board[rowIn].length; column++) {
            for (int rotation = 0; rotation < 4; rotation++) {
                var piece = new Piece(column, rowIn, rotation);
                if (canPlace(piece)) {
                    place(piece);
                    solve(placedPieces + 1, rowIn, column + 1);
                    unplace(piece);
                }
            }
        }
        if (isFullRow(rowIn)) {
            solve(placedPieces, rowIn + 1, 0);
        }
    }

    private boolean canPlace(Piece piece) {
        boolean trappedCellinMiddle = false;
        boolean trappedCellinTop = false;
        boolean trappedCellinSides = false;

        if (!board[0][0].state){

        }

        for (int x = 1; x < board.length - 1; x++){
            if (!board[x][0].state) {
                if (board[x-1][0].state && board[x][1].state && board[x+1][0].state) return false;
            }
        }

        for (int y = 1; y < piece.y1 - 1; y++){
            for (int x = 1; x < board.length - 1; x++){
                if (!board[x][y].state) {
                    trappedCellinMiddle = board[x-1][y].state && board[x][y-1].state && board[x][y+1].state && board[x+1][y].state;
                }
            }
        }

        if (trappedCellinMiddle || trappedCellinTop || trappedCellinSides) return false;


        return isValidPlace(piece.x1, piece.y1) && isValidPlace(piece.x2, piece.y2) && isValidPlace(piece.x3, piece.y3);
    }

    private boolean isValidPlace(int x, int y) {
        return x >= 0 && x < board.length && y >= 0 && y < board.length && !board[x][y].state;
    }

    private boolean isFullRow(int row) {
        boolean full = true;
        for (int i = 0; i < row; i++) {
            if (!board[row][i].state) {
                full = false;
                break;
            }
        }
        return full;
    }

    private void place(Piece piece) {
        setBoardState(piece.x1, piece.y1, new Cell(true, piece.pieceChar));
        setBoardState(piece.x2, piece.y2, new Cell(true, piece.pieceChar));
        setBoardState(piece.x3, piece.y3, new Cell(true, piece.pieceChar));
    }

    private void unplace(Piece piece) {
        setBoardState(piece.x1, piece.y1, new Cell(false, piece.pieceChar));
        setBoardState(piece.x2, piece.y2, new Cell(false, piece.pieceChar));
        setBoardState(piece.x3, piece.y3, new Cell(false, piece.pieceChar));
    }

    private void setBoardState(int x, int y, Cell cell) {
        board[x][y] = cell;
    }

    @Override
    public String toString() {
        var builder = new StringBuilder();
        for (var row : board) {
            for (var coord : row) {
                builder.append(" ").append(coord.cellChar).append(" ");
            }
            builder.append("\n");
        }
        return builder.toString();
    }
}
