package me.lectr1c.LABA.LAB2;

import java.util.InputMismatchException;

public class LetterSorterArray {
    public static void main(String[] args) {
        var pkgSorter = new LetterSorterArray();
        var bfsSorter = new LetterSorterBFS();
        System.out.println("DFS: " + pkgSorter.sort("adecb"));
        System.out.println("BFS: " + bfsSorter.sort("adecb"));
        System.out.println("Hi?");
    }

    public LetterSorterArray(){ }

    public String sort(String startStr){
        if (!startStr.contains("a") || !startStr.contains("b") ||
        !startStr.contains("c") || !startStr.contains("d") || !startStr.contains("e"))
            throw new InputMismatchException("Incorrect Letters");

        var input = startStr.toCharArray();
        if (input.length != 5) throw new InputMismatchException("Length doesn't match");
        return sort(input, 0);
    }

    private String sort(char[] packages, int limit) {
        if (isSorted(packages)) return "";
        if (limit > 15) return "XXXXXXXXXEXCEEDEDDEPTHXXXXXXXX";

        swapLastTwo(packages);
        String swap = "b" + sort(packages, limit + 1);
        swapLastTwo(packages);
        moveToEnd(packages);
        String move = "s" + sort(packages, limit + 1);
        reverseMove(packages);


        return move.length() < swap.length() ? move : swap;
    }

    private void swapLastTwo(char[] packages) {
        char temp = packages[0];
        packages[0] = packages[1];
        packages[1] = temp;
    }

    private void moveToEnd(char[] packages) {
        char rightChar = packages[packages.length - 1];
        for (int i = packages.length - 1; i > 0; i--){
            packages[i] = packages[i - 1];
        }
        packages[0] = rightChar;
    }

    private void reverseMove(char[] packages) {
        char leftChar = packages[0];
        for (int i = 0; i < packages.length - 1; i++){
            packages[i] = packages[i+1];
        }
        packages[packages.length - 1] = leftChar;
    }

    private boolean isSorted(char[] packages) {
        return packages[0] == 'a' &&
                packages[1] == 'b' &&
                packages[2] == 'c' &&
                packages[3] == 'd' &&
                packages[4] == 'e';
    }
}
