package me.lectr1c.LABA.LAB3;

public class RadixSort {

    public static void sort(int[] nums){
        int[] helperArr = new int[nums.length];
        int digitPlace = 0;
        while (true){
            digitPlace++;
            int[] digitsArr = new int[10];
            boolean lastDigit = true;
            for (int num : nums) {
                int shift = digitPlace == 1 ? num : num / ((int) Math.pow(10, digitPlace-1));
                int digit = shift % 10;
                if (shift > 0) lastDigit = false;
//                System.out.println("number: " + num + " shifted for " + digitPlace + " shift: " + shift + " digit: " + digit);
                digitsArr[digit]++;
            }

            if (lastDigit) break;

            for (int i = 1; i < digitsArr.length; i++){
                digitsArr[i] += digitsArr[i-1];
            }

            for (int i = nums.length - 1; i >= 0; i--){
                int shift = digitPlace == 1 ? nums[i] : nums[i] / ((int) Math.pow(10, digitPlace-1));
                int digit = shift % 10;
                digitsArr[digit]--;
                int index = digitsArr[digit];
                helperArr[index] = nums[i];
            }

            for (int i = 0; i < nums.length; i++){
                nums[i] = helperArr[i];
            }
        }
    }

}
