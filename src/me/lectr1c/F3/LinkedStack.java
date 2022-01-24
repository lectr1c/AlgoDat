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
}
