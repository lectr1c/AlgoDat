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
        size++;
        heapifyUp(size);
        return true;
    }

    public E extract(){
        size--;
        E element = data[size];
        swap(data, 0, size);
        data[size] = null;
        heapifyDown(0)
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
        data[parentIndex] = data[childIndex];
    }

    private void resize() {
        int newSize = data.length*2;
        data = Arrays.copyOf(data, newSize);
    }


}
