package me.lectr1c.F5;

public class BinInt {
    public static void main(String[] args) {
        System.out.println(toInteger("100"));
        System.out.println(toBinary(20));

    }

    public static int toInteger(String binary){
        return toInteger(binary, 0);
    }

    public static String toBinary(int integer){
        int topPower = 0;
        while (Math.pow(2, topPower + 1) < integer) topPower++;
        return toBinary(integer, topPower);
    }

    private static String toBinary(int integer, int power) {
        if (power == -1) return "";

        int powRes = (int) Math.pow(2, power);

        if (integer - powRes < 0) return "0" + toBinary(integer, power - 1);

        return "1" + toBinary(integer - powRes, power - 1);
    }

    private static int toInteger(String binary, int index){
        if (index >= binary.length()) return 0;

        int position = binary.length() - 1 - index;

        int resToAdd = binary.charAt(position) == '0' ? 0 : (int) Math.pow(2, index);
        return toInteger(binary, index + 1) + resToAdd;
    }

}
