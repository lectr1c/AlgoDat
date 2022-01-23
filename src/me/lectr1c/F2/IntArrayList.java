package me.lectr1c.F2;

public class IntArrayList {

    public int data[];
    int nrOfElements;
    int maxSize;

    public IntArrayList(int initSize){
        nrOfElements = 0;
        maxSize = initSize;
        data = new int[maxSize];
    }

    public int get(int index){
        checkIndex(index);
        return data[index];
    }

    public boolean add(int element) {
        return add(nrOfElements, element);
    }

    public boolean add(int index, int element){
        checkIndex(index);
        if (nrOfElements == maxSize) reallocate();
        if (index != nrOfElements) shiftUp(index);
        data[index] = element;
        nrOfElements++;
        return true;
    }

    public boolean set(int index, int element){
        checkIndex(index);
        data[index] = element;
        return true;
    }

    public int indexOf(int element){
        for (int i = 0; i < maxSize; i++)
            if (data[i] == element) return i;
        return -1;
    }
    public boolean remove(int index){
        checkIndex(index);
        shiftDown(index);
        nrOfElements--;
        return true;
    }

    public int size(){
        return nrOfElements;
    }

    @Override
    public String toString(){
        var string = new StringBuilder();
        string.append("[");
        for (int i = 0; i < nrOfElements - 1; i++){
            string.append(data[i]).append(", ");
        }
        string.append(data[nrOfElements - 1]);
        string.append("]");
        return string.toString();
    }

    private void checkIndex(int index){
        if(0 <= index && index <= nrOfElements) return;
        throw new ArrayIndexOutOfBoundsException(index);
    }

    private void reallocate() {
        maxSize *= 2;
        int[] newDataArray = new int[maxSize];

        for (int i = 0; i < nrOfElements; i++){
            newDataArray[i] = data[i];
        }

        data = newDataArray;
    }

    private void shiftUp(int index){
        for(int i = nrOfElements; i > index; i--)
            data[i] = data[i-1];
    }

    private void shiftDown(int index) {
        for(int i = index; i < nrOfElements - 1; i++)
            data[i] = data[i+1];
    }
}


