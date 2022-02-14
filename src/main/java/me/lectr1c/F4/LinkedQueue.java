package me.lectr1c.F4;

public class LinkedQueue<E> {
    private static class Node<E> {
        private E data;
        private Node<E> next;

        private Node(E data, Node<E> node){
            this.data = data;
            this.next = node;
        }
    }

    private Node<E> head;
    private Node<E> tail;
    private int size;

    public LinkedQueue(){
        head = null;
        tail = null;
        size = 0;
    }

    public boolean enqueue(E element){
        Node<E> newNode = new Node<>(element, null);
        if (size == 0){
            head = newNode;
            tail = head;
        } else {
            tail.next = newNode;
            tail = tail.next;
        }
        size++;
        return true;
    }

    public E dequeue(){
        if (head == null) throw new IllegalStateException("Queue is Empty");
        E returnElement = head.data;
        head = head.next;
        size--;
        if (size == 0) tail = null;
        return returnElement;
    }

    public int size(){
        return size;
    }

    @Override
    public String toString(){
        var stringBuild = new StringBuilder(head.data.toString());
        Node<E> startNode = head.next;
        for (int i = 1; i < size; i++){
            stringBuild.append(" --> ").append(startNode.data);
            startNode = startNode.next;
        }

        return stringBuild.toString();
    }
}
