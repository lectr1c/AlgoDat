package me.lectr1c.F9;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 4, 1, 5, 6, 3, 9, 12, 4, 7};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void sort(int[] nums){
        for (int i = 1; i < nums.length; i++){
            int data = nums[i];
            int dataIndex = i;
            while (dataIndex > 0 && data < nums[dataIndex-1]){
                nums[dataIndex] = nums[dataIndex-1];
                dataIndex--;
            }
            nums[dataIndex] = data;
        }
    }
}
