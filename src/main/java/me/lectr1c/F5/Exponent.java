package me.lectr1c.F5;

public class Exponent {
    public static void main(String[] args) {
        int itrRes = itrPowerOf(5, 4);
        int recRes = recPowerOf(5, 4);
        System.out.println(itrRes + "  " + recRes);
    }

    public static int recPowerOf(int x, int n){
        if (n < 0) throw new UnsupportedOperationException("Only positive exponents are supported.");
        if (n == 0) return 1;

        return x * recPowerOf(x, n - 1);
    }

    public static int itrPowerOf(int x, int n){
        int result = 1;
        for (int i = 1; i <= n; i++)
            result *= x;
        return result;
    }
}
