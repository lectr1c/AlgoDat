package me.lectr1c.F6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Labyrinth {

    int rows, columns;
    public enum Cell{WALL, OPEN, CORRECT, VISITED};
    private Position currentP, goal, start;
    Cell[][] mazeMatrix;


    public Labyrinth() {
        try {
            String directory = System.getProperty("user.dir");
            BufferedReader in = new BufferedReader(new FileReader(directory + "\\Labyrint.txt"));
            rows = Integer.parseInt(in.readLine()) + 2;
            columns = Integer.parseInt(in.readLine()) + 2;
            mazeMatrix = new Cell[rows][columns];
            for (int j = 0; j < columns; j++) {
                mazeMatrix[0][j] = Cell.WALL;
                mazeMatrix[rows - 1][j] = Cell.WALL;
            }
            for (int i = 1; i < rows - 1; i++) {
                mazeMatrix[i][0] = Cell.WALL;
                mazeMatrix[i][columns - 1] = Cell.WALL;
            }
            for (int i = 1; i < rows - 1; i++) {
                String s = in.readLine();
                for (int j = 1; j < columns - 1; j++) {
                    mazeMatrix[i][j] = Cell.OPEN;
                    if (s.charAt(j - 1) == '*')
                        mazeMatrix[i][j] = Cell.WALL;
                    else if (s.charAt(j - 1) == 'g') {
                        goal = new Position(i, j);
                    } else if (s.charAt(j - 1) == 's') {
                        currentP = new Position(i, j);
                        start = currentP;
                    }
                }
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace(System.err);
            System.exit(1);
        }
    }

    private class Position{
        int row,column;
        public Position(int r, int c){
            row=r;
            column=c;
        }

        public boolean equals(Position p){
            return (row==p.row&&column==p.column);
        }
    }

    public boolean solve(){
        return solve(currentP);
    }

    private boolean solve(Position p){
        if (p.equals(goal)) {
            setCellState(p, Cell.CORRECT);
            return true;
        }

        var state = getCellState(p);
        if (state == Cell.WALL || state == Cell.VISITED) {
            return false;
        }
        setCellState(p, Cell.VISITED);

        boolean pathFound = solve(new Position(p.row - 1, p.column)) ||
                solve(new Position(p.row, p.column - 1)) ||
                solve(new Position(p.row + 1, p.column)) ||
                solve(new Position(p.row, p.column + 1));

        if (pathFound) {
            setCellState(p, Cell.CORRECT);
        }
        return pathFound;
    }

    private Cell getCellState(Position p) {
        return mazeMatrix[p.row][p.column];
    }

    private Cell setCellState(Position p, Cell cell) {
        return mazeMatrix[p.row][p.column] = cell;
    }

    public void print(){
        for (int i = 1; i < rows - 1; i++) {
            for (int j = 1; j < columns - 1; j++) {
                if (new Position(i, j).equals(start)) {
                    System.out.print("S");
                } else if (new Position(i, j).equals(goal)) {
                    System.out.print("G");
                } else {
                    switch (mazeMatrix[i][j]) {
                        case CORRECT -> System.out.print("X");
                        case WALL -> System.out.print(".");
                        case VISITED, OPEN -> System.out.print("-");
                        default -> System.out.print(mazeMatrix[i][j].ordinal());
                    }
                }
            }
            System.out.println();
        }
    }
}
