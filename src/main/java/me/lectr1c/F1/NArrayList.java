package me.lectr1c.F1;

import java.util.Arrays;

public class NArrayList<E> {

    private E[] data;
    private int nrElements;
    private int maxSize;

    public NArrayList(){
        this(10);
    }

    public NArrayList(int size){
        this.nrElements = 0;
        this.maxSize = size;
        this.data = (E[]) new Object[size];
    }

    public boolean add(E element){
        if(nrElements == maxSize) reallocate();
        data[nrElements++] = element;
        return true;
    }

    public E get(int index){
        if(0 <= index && index < nrElements) return data[index];
        throw new ArrayIndexOutOfBoundsException(index);
    }

    public void add(int index, E element) {
        if(index < 0 || index > nrElements) throw new ArrayIndexOutOfBoundsException(index);
        if(nrElements == maxSize) reallocate();
        shiftUp(index);
        data[index] = element;
        nrElements++;
    }

    public boolean remove(int index) {
        if(index < 0 || index > nrElements) throw new ArrayIndexOutOfBoundsException(index);
        shiftDown(index);
        nrElements--;
        return true;
    }

    public int indexOf(E element){
        for(int i = 0; i < nrElements; i++)
            if(data[i].equals(element)) return i;
        return -1;
    }

    public void set(int index, E element){
        if(index < 0 || index > nrElements) throw new ArrayIndexOutOfBoundsException(index);
        data[index] = element;
    }
    private void shiftUp(int index){
        for(int i = nrElements; i > index; i--)
            data[i] = data[i-1];
    }

    private void shiftDown(int index) {
        for(int i = index; i < nrElements - 1; i++)
            data[i] = data[i+1];
    }

    private void reallocate() {
        maxSize *= 2;
        data = Arrays.copyOf(data, maxSize);
    }

    @Override
    public String toString() {
        StringBuilder arrayStr = new StringBuilder("data={");
        if (nrElements > 0) arrayStr.append(data[0]);
        for (int i = 1; i < nrElements; i++)
            arrayStr.append(", ").append(data[i].toString());
        arrayStr.append("}");
        return arrayStr.toString();
    }



}
