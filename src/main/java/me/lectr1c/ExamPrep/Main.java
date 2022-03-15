package me.lectr1c.ExamPrep;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] v={1,2,0,-2,4,-3,-7,6,-2,-5,8,1,2,5};
        int[] w={-2,-3,5,-3,7,3,-8,5,-6,9,-2,7,0,-5,0,-3,-4,-5,1,5,-6,7,-8,9,-3,2,-5,7,3,7,8,-3,5,8,-1};
        System.out.println(largestSum(v));
        System.out.println(largestSum(w));
    }

    private static int largestSum(int[] v) {
        int[] memo = new int[v.length];
        Arrays.fill(memo,Integer.MAX_VALUE);
        return largestSum(v,0,memo);
    }

    private static int largestSum(int[] v, int index, int[] memo) {
        if(index>v.length-1) return 0;
        if(memo[index]<Integer.MAX_VALUE) return memo[index];
        return memo[index]=v[index]+Math.max(largestSum(v,index+3,memo), largestSum(v,index+5,memo));
    }



}
