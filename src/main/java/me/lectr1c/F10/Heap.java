package me.lectr1c.F10;

import java.util.Arrays;

public class Heap<E extends Comparable<E>> {

    private E[] data;
    private int size;

    public Heap(int initialSize){
        data = (E[]) new Comparable[initialSize];
    }

    public boolean insert(E element){
        if (size == data.length) resize();

        data[size] = element;
        heapifyUp(size);
        size++;
        return true;
    }

    public E extract(){
        size--;
        E element = data[0];
        swap(data, 0, size);
        data[size] = null;
        heapifyDown(0);
        return element;
    }

    private void heapifyDown(int parentIndex) {
        int leftChild = 2 * parentIndex + 1;
        int rightChild = 2 * parentIndex + 2;
        int smallestIndex = Integer.MAX_VALUE;

        if (data[leftChild] == null && data[rightChild] == null) return;

        if (data[leftChild] != null){
           smallestIndex = leftChild;
           if(data[rightChild] != null && data[rightChild].compareTo(data[leftChild]) < 0){
               smallestIndex = rightChild;
           }
        }

        if (data[parentIndex].compareTo(data[smallestIndex]) > 0){
            swap(data, parentIndex, smallestIndex);
            heapifyDown(smallestIndex);
        }
    }

    private void heapifyUp(int childIndex) {
        int parentIndex = (childIndex - 1) / 2;
        if (parentIndex < 0 || data[parentIndex] == null) return;
        if(data[childIndex].compareTo(data[parentIndex]) < 0) {
            swap(data, childIndex, parentIndex);
            heapifyUp(parentIndex);
        }
    }

    private void swap(E[] data, int childIndex, int parentIndex) {
        E temp = data[childIndex];
        data[childIndex] = data[parentIndex];
        data[parentIndex] = temp;
    }

    private void resize() {
        int newSize = data.length*2;
        data = Arrays.copyOf(data, newSize);
    }

    @Override
    public String toString(){
        int maxDepth = (int) (Math.log(size) / Math.log(2));  // log base 2 of n

        StringBuilder hs = new StringBuilder();  // heap string builder
        for (int d = maxDepth; d >= 0; d--) {  // number of layers, we build this backwards
            int layerLength = (int) Math.pow(2, d);  // numbers per layer

            StringBuilder line = new StringBuilder();  // line string builder
            for (int i = layerLength; i < (int) Math.pow(2, d + 1); i++) {
                // before spaces only on not-last layer
                if (d != maxDepth) {
                    line.append(" ".repeat((int) Math.pow(2, maxDepth - d)));
                }
                // extra spaces for long lines
                int loops = maxDepth - d;
                if (loops >= 2) {
                    loops -= 2;
                    while (loops >= 0) {
                        line.append(" ".repeat((int) Math.pow(2, loops)));
                        loops--;
                    }
                }

                // add in the number
                if (i <= size) {
                    line.append(String.format("%-2s", data[i - 1]));  // add leading zeros
                } else {
                    line.append("--");
                }

                line.append(" ".repeat((int) Math.pow(2, maxDepth - d)));  // after spaces
                // extra spaces for long lines
                loops = maxDepth - d;
                if (loops >= 2) {
                    loops -= 2;
                    while (loops >= 0) {
                        line.append(" ".repeat((int) Math.pow(2, loops)));
                        loops--;
                    }
                }
            }
            hs.insert(0, line.toString() + "\n");  // prepend line
        }
        return hs.toString();
    }


}
