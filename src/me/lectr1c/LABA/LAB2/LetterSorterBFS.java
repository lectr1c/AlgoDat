package me.lectr1c.LABA.LAB2;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Queue;

public class LetterSorterBFS {
    public static void main(String[] args) {
        var pkgSorter = new LetterSorterBFS();
        System.out.println(pkgSorter.sort("adecb"));
    }

    public LetterSorterBFS(){ }

    public String sort(String startStr){
        if (!startStr.contains("a") || !startStr.contains("b") ||
                !startStr.contains("c") || !startStr.contains("d") || !startStr.contains("e"))
            throw new InputMismatchException("Incorrect Letters");

        var packages = startStr.toCharArray();
        if (packages.length != 5) throw new InputMismatchException("Length doesn't match");

        Queue<State> callQueue = new LinkedList<>();
        State current = new State(packages, "");


        while(!isSorted(current.packages)) {
            swapLastTwo(current.packages);
            callQueue.offer(new State(current.packages.clone(), current.steps + "b"));
            swapLastTwo(current.packages);
            moveToEnd(current.packages);
            callQueue.offer(new State(current.packages.clone(), current.steps + "s"));
            current = callQueue.poll();
        }

        return current.steps;
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

    private static class State {
        public char[] packages;
        public String steps;

        public State(char[] packages, String steps){
            this.packages = packages;
            this.steps = steps;
        }
    }
}
