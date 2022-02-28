package me.lectr1c.F10;

import java.util.Arrays;

public class HeapSort {

    public static void main(String[] args) {
        var hs = new HeapSort();
        int[] nums = new int[]{3, 4, 1, 5, 6, 3, 9, 12, 4, 7};
        hs.sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void sort(int[] arr) {
        int heapSize = 1;

        while (heapSize < arr.length) {
            offer(arr, heapSize++);
        }

        while (heapSize > 1) {
            arr[--heapSize] = poll(arr, heapSize);
        }
    }

    private void offer(int[] arr, int heapSize) {
        heapifyDown(arr, arr.length, arr.length - heapSize - 1);
    }

    private int poll(int[] arr, int heapSize) {
        swap(0, heapSize, arr);
        heapifyDown(arr, heapSize, 0);
        return arr[heapSize];
    }

    private void heapifyDown(int[] arr, int maxIndex, int parentIndex) {
        int largest = parentIndex;
        int leftChild = 2 * parentIndex + 1;
        int rightChild = 2 * parentIndex + 2;
        
        if (leftChild < maxIndex && arr[leftChild] > arr[largest]) {
            largest = leftChild;
        }
        if (rightChild < maxIndex && arr[rightChild] > arr[largest]) {
            largest = rightChild;
        }

        if (largest == parentIndex) return;

        swap(parentIndex, largest, arr);
        heapifyDown(arr, maxIndex, largest);

    }

    private static void swap(int first, int second, int[] arr) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

}
