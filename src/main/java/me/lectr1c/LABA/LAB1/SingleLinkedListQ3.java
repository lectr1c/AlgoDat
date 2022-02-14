package me.lectr1c.LABA.LAB1;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SingleLinkedListQ3<E> implements Iterable<E>{

    private static class Node<E> {
        private E data;
        private Node<E> next;

        public Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node<E> head;
    private int size;

    public SingleLinkedListQ3(){
        head = null;
        size = 0;
    }

    public void add(int index, E item) {
        if (index < 0) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        if (index == 0) {
            addFirst(item);
        } else {
            Node<E> node = getNode(index - 1);
            addAfter(node, item);
        }
    }

    public void addFirst(E item) {
        head = new Node<E>(item, head);
        size++;
    }

    public boolean add(E item) {
        add(size, item);
        return true;
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        Node<E> node = getNode(index);
        return node.data;
    }

    private Node<E> getNode(int index) {
        Node<E> node = head;
        for (int i = 0; i < index && node != null; i++) {
            node = node.next;
        }
        return node;
    }

    public E remove(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException(Integer.toString(index));
        Node<E> prevNode = null;
        Node<E> currNode = null;
        Node<E> nextNode = null;

        if (index == 0) {
            currNode = head;
            head = head.next;
        }
        else {
            prevNode = getNode(index - 1);
            currNode = prevNode.next;
            if (index != size - 1) nextNode = prevNode.next.next;

            prevNode.next = nextNode;
        }
        size--;

        return currNode.data;
    }

    public int getSize(){
        return size;
    }

    private void addAfter(Node<E> node, E item) {
        node.next = new Node<E>(item, node.next);
        size++;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<E> p = head;
        if (p != null) {
            while (p.next != null) {
                sb.append(p.data.toString());
                sb.append(" ==> ");
                p = p.next;
            }
            sb.append(p.data.toString());
        }
        sb.append("]");
        return sb.toString();
    }

    public Iterator<E> iterator() {
        return new Itr(head);
    }

    private class Itr implements Iterator<E> {
        Node<E> current;
        Node<E> firstPrev;
        Node<E> secondPrev;

        public Itr(Node<E> start) {
            current = start;
            firstPrev = null;
            secondPrev = null;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            if (current == null) {
                throw new NoSuchElementException();
            }
            E returnValue = current.data;
            secondPrev = firstPrev;
            firstPrev = current;
            current = current.next;
            return returnValue;
        }

        @Override
        public void remove() {
            if (firstPrev == null || firstPrev == secondPrev)
                throw new IllegalStateException("Cannot call remove() before next()");

            if (secondPrev != null) secondPrev.next = current;
            else head = current;

            firstPrev = secondPrev;
            size--;
        }
    }
}
