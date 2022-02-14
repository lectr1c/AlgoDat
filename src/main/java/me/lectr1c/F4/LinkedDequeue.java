package me.lectr1c.F4;

public class LinkedDequeue<E> {
    private class Node<E> {
        E data;
        Node<E> next;
        Node<E> previous;

        private Node(E data, Node<E> previous, Node<E> next){
            this.data = data;
            this.previous = previous;
            this.next = next;
        }
    }

    private int size;
    private Node<E> head;
    private Node<E> tail;

    public LinkedDequeue(){
        size = 0;
        head = null;
        tail = null;
    }

    public E pollFirst(){
        if (size == 0) throw new IllegalStateException("Empty Dequeue");

        E returnElement = head.data;
        head = head.next;
        head.previous = null;
        size--;
        return returnElement;
    }

    public E pollLast(){
        if (size == 0) throw new IllegalStateException("Empty Dequeue");

        E returnElement = tail.data;
        tail = tail.previous;
        tail.next = null;
        size--;
        return returnElement;
    }

    public boolean offerFirst(E element){
        Node<E> newNode = new Node<>(element, null, null);

        if (size == 0) {
            head = newNode;
            tail = head;
        } else {
            newNode.next = head;
            head.previous = newNode;
            head = newNode;
        }
        size++;
        return true;
    }

    public boolean offerLast(E element){
        Node<E> newNode = new Node<>(element, null, null);

        if (size == 0) {
            head = newNode;
            tail = head;
        } else {
            newNode.previous = tail;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
        return true;
    }

    public int size(){ return size; }

    @Override
    public String toString(){
        var stringBuild = new StringBuilder(head.data.toString());
        Node<E> startNode = head.next;
        for (int i = 1; i < size; i++){
            stringBuild.append(" <-> ").append(startNode.data.toString());
            startNode = startNode.next;
        }

        return stringBuild.toString();
    }
}
