package me.lectr1c.F4;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.NoSuchElementException;
public class ArrayQueueNB8<E> extends AbstractQueue<E>{ // implements Queue<E> görs av AbstractQueue<E>

    private int front, rear, size, maxSize;
    private E[] data;

    @SuppressWarnings("unchecked")
    public ArrayQueueNB8(int initialMaxSize) {
        size = 0;
        front = 0;
        maxSize = initialMaxSize;
        rear = maxSize - 1;
        data = (E[]) new Object[maxSize];
    }

    @Override
    public boolean offer(E element) {
        if (size == maxSize) {
            reallocate(maxSize * 2);
        }
        rear = (rear + 1) % maxSize;
        data[rear] = element;
        size++;
        return true;
    }

    public E peek() {
        if (size == 0) {
            return null;
        }
        return data[front];
    }

    public E poll() {
        if (size == 0) {
            return null;
        } else {
            size--;
            E element = data[front];
            front = (front + 1) % maxSize;

            if(size <= maxSize / 4) reallocate(maxSize / 2);

            return element;
        }
    }

    @SuppressWarnings("unchecked")
    private void reallocate(int newMaxSize) {
        E[] newData = (E[]) new Object[newMaxSize];
        int j = front;
        for (int i = 0; i < size; i++) {
            newData[i] = data[j];
            j = (j + 1) % maxSize;
        }
        front = 0;
        rear = size - 1;
        maxSize = newMaxSize;
        data = newData;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iter();
    }

    @Override
    public int size() {
        return size;
    }

    private class Iter implements Iterator<E> {

        private int index;
        private int count = 0;

        public Iter() {
            index = front;
        }

        @Override
        public boolean hasNext() {
            return count < size;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            E returnValue = data[index];
            index = (index + 1) % maxSize;
            count++;
            return returnValue;
        }

        @Override
        public void remove() {
//ska endast kunna ta bort det första
            throw new UnsupportedOperationException();
        }
    }
}
