package me.lectr1c.F3;

import me.lectr1c.F1.P1P2;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class ALStack<E> implements StackInt<E>{

    ArrayList<E> stack;
    int nrOfElements;

    public ALStack(){
        nrOfElements = 0;
        stack = new ArrayList<>();
    }

    @Override
    public E push(E obj) {
        stack.add(obj);
        nrOfElements++;
        return obj;
    }

    @Override
    public E peek() {
        if (empty()) throw new EmptyStackException();
        return stack.get(nrOfElements - 1);
    }

    @Override
    public E pop() {
        if (empty()) throw new EmptyStackException();
        else {
            E element = stack.get(nrOfElements - 1);
            stack.remove(nrOfElements - 1);
            nrOfElements--;
            return element;
        }
    }

    @Override
    public boolean empty() {
        return stack.isEmpty();
    }
}
