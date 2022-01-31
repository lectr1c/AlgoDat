package me.lectr1c.F5;

public class BallExchanger {

    public static void main(String[] args) {
        System.out.println(exchange(3, 1, 2, 0));
    }

    public static int exchange(int red, int white, int blue, int exchangeCount){
        if (red == white && white == blue) return 0;
        if (exchangeCount > 15) return 0;

        int blueExchange = blue > 0 ? exchange(red + 3, white + 1, blue - 1, ++exchangeCount) : 16;
        int whiteExchange = white > 0 ? exchange(red + 4, white - 1, blue + 2, ++exchangeCount) : 16;
        int redExchange = red > 0 ? exchange(red - 1, white + 5, blue + 1, ++exchangeCount) : 16;

        return Math.min(blueExchange, Math.min(whiteExchange, redExchange)) + 1;
    }
}
