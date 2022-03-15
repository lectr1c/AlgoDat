package me.lectr1c.LABA.LAB3;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class TestRadix {

    public static void main(String[] args) {
        Random rand = new Random();
        int[] nums = new int[1000000];
        for (int i = 0; i < nums.length; i++){
            nums[i] = rand.nextInt(0, Integer.MAX_VALUE);
        }
        var startTime = System.nanoTime();
        RadixSort.sort(nums);
        var endTime = System.nanoTime();
        var elapsedTime = TimeUnit.NANOSECONDS.toMicros(endTime-startTime);
        System.out.println(" Time: " + elapsedTime + "μs");

    }
}
