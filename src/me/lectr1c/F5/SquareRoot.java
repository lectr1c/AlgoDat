package me.lectr1c.F5;

public class SquareRoot {
    public static void main(String[] args) {
        double res = root(36, 1, 10);
        System.out.println(res);
    }

    public static double root(double n, double a, double e){
        return Math.abs(Math.pow(a, 2) - n) < e ? a : root(n, (Math.pow(a, 2) + n) / (2 * a) , e);
    }
}
