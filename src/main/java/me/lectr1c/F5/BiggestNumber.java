package me.lectr1c.F5;

public class BiggestNumber {

    public static void main(String[] args) {
        int[] nums = {5, 3, 16, -2, 9, 12, 3, -1};
        int num = BiggestNumber.findMax(nums, nums.length);
        System.out.println(num);
    }

    public static int findMax(int[] numArray, int n) {
        if(n == 1) return numArray[0];
        return Math.max(numArray[n-1], findMax(numArray, n - 1));
    }
}
