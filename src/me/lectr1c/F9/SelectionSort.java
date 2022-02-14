package me.lectr1c.F9;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 4, 1, 5, 6, 3, 9, 12, 4, 7};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void sort(int[] nums){
        for (int i = 0; i < nums.length - 1; i++){
            int minIndex = i;
            for (int j = i + 1; j < nums.length; j++){
                if (nums[j] < nums[minIndex])
                    minIndex = j;
            }
            int temp = nums[i];
            nums[i] = nums[minIndex];
            nums[minIndex] = temp;
        }
    }
}


