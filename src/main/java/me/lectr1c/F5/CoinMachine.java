package me.lectr1c.F5;

public class CoinMachine {

    public static void main(String[] args) {
        System.out.println(eval(1, 109));
    }

    public static int eval(int currPoints, int goalPoints){
        if (currPoints > goalPoints) return -1;

        if (currPoints == goalPoints) return 0;

        int add = eval(currPoints + 4, goalPoints);
        int multiply = eval(currPoints * 3, goalPoints);

        if (add < 0 && multiply < 0) return -1;

        if (add < 0) return multiply + 10;

        if (multiply < 0) return add + 5;

        return Math.min(add + 5, multiply + 10);
    }
}
