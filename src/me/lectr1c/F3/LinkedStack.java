package me.lectr1c.F3;

import java.util.EmptyStackException;

public class LinkedStack<E> implements StackInt<E>{

    private static class Node<E> {
        private E data;
        private Node<E> next;
        private Node(E dataItem, Node<E> nodeRef) {
            data = dataItem;
            next = nodeRef;
        }
    }

    private Node<E> top;

    public LinkedStack ()
    {
        top = null;
    }

    public E flush(){
        E lastElement = top.data;
        while(top != null){
            if (top.next == null) lastElement = top.data;
            top.data = null;
            Node<E> temp = top.next;
            top.next = null;
            top = temp;

        }
        return lastElement;
    }

    public int size(){
        int size = 0;
        Node<E> element = top;
        while (element != null){
            element = element.next;
            size++;
        }
        return size;
    }

    public E peek(int n){
        Node<E> element = top;
        for (int i = 0; i < n; i++){
            if (element == null) throw new EmptyStackException();
            element = element.next;
        }
        return element.data;
    }

    @Override
    public E push(E obj) {
        top = new Node<E>(obj, top);
        return obj;
    }

    @Override
    public E pop() {
        if (empty()) {
            throw new EmptyStackException();
        } else {
            E result = top.data;
            top = top.next;
            return result;
        }
    }

    @Override
    public E peek() {
        if (empty()) {
            throw new EmptyStackException();
        } else {
            return top.data;
        }
    }

    @Override
    public boolean empty() {
        return top == null;
    }

    @Override
    public String toString() {
        if (empty()) throw new EmptyStackException();
        StringBuilder stringBuilder = new StringBuilder(top.data.toString());

        Node<E> temp = top.next;
        while (temp != null){
            stringBuilder.append(" --> ").append(temp.data);
            temp = temp.next;
        }
        return stringBuilder.toString();
    }
}
