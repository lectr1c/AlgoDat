package me.lectr1c.F8;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SingleLinkedList<E> implements Iterable<E>{

    private static class Node<E> {
        private E data;
        private Node<E> next;

        public Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node<E> head;

    public SingleLinkedList(){
        head = null;
    }

    public void addFirst(E item) {
        head = new Node<E>(item, head);
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
        }
    }
}
