package me.lectr1c.F9;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] nums = new int[]{3, 4, 1, 5, 6, 3, 9, 12, 4, 7};
        mergeSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void mergeSort(int[] a){
        if (a.length == 1) return;
        int[] b = Arrays.copyOfRange(a, 0, (a.length/2));
        int[] c = Arrays.copyOfRange(a, a.length/2, a.length);
        mergeSort(b);
        mergeSort(c);
        merge(b, c, a);
    }

    public static void merge(int[] a, int[] b, int[] c){
        int indexA = 0, indexB = 0, indexC = 0;
        while (indexA < a.length && indexB < b.length){
            if (a[indexA] <= b[indexB]){
                c[indexC++] = a[indexA];
                indexA++;
            } else {
                c[indexC++] = b[indexB];
                indexB++;
            }
        }

        while (indexA < a.length) {
            c[indexC++] = a[indexA];
            indexA++;
        }

        while (indexB < b.length){
            c[indexC++] = b[indexB];
            indexB++;
        }
    }
}
