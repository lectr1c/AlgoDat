package me.lectr1c.F9;

import java.util.Arrays;

public class ShellSort {

    public static void main(String[] args) {
        int[] nums = new int[]{3, 4, 1, 5, 6, 3, 9, 12, 4, 7};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void sort(int[] nums){
        int gap = nums.length/2;
        while (gap > 0) {
            for(int i = gap; i < nums.length; i++){
                int num = nums[i];
                int numIndex = i;
                while (numIndex > gap-1 && num < nums[numIndex-gap]){
                    nums[numIndex] = nums[numIndex-gap];
                    numIndex -= gap;
                }
                nums[numIndex] = num;
            }
            if (gap == 2) gap = 1;
            else gap /= 2.2f;
        }
    }
}
