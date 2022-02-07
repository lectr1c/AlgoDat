package me.lectr1c.F7;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree<E extends Comparable<E>> {

    private static class Node<E>{
        private E data;
        private Node<E> left,right;
        private Node(E d){
            data=d;
            left=right=null;
        }

        @Override
        public String toString(){
            return data.toString();
        }
    }

    private Node<E> root;

    public BinarySearchTree(){
        root=null;
    }

    private boolean add(E data,Node<E> node){
        if (data.compareTo(node.data)==0) return false;
        else if (data.compareTo(node.data)<0)
            if (node.left==null){
                node.left = new Node<E>(data);
                return true;
            } else return add(data,node.left);
        else if (node.right==null){
            node.right = new Node<E>(data);
            return true;
        } else return add(data,node.right);
    }

    public boolean add(E data){
        if(root==null){
            root = new Node<E>(data);
            return true;
        }else
            return add(data,root);
    }

    private E find(E target, Node<E> node){
        if( node==null)
            return null;
        if(target.compareTo(node.data)==0)
            return node.data;
        if(target.compareTo(node.data)<0)
            return find(target,node.left);
        return find(target,node.right);
    }

    public E find(E target){
        return find(target, root);
    }

    private void inOrder(Node<E> node, StringBuilder sb){
        if (node!=null){
            inOrder(node.left, sb);
            sb.append(": "+node.toString());
            inOrder(node.right, sb);
        }
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        inOrder(root,sb);
        return sb.toString();
    }

    private static class State<E> {

        private E node;
        private int level;

        private State(E node, int level){
            this.node = node;
            this.level = level;
        }

    }

    public String printTrees(){
        int currLevel = 0;
        StringBuilder treeString = new StringBuilder();
        Queue<State<Node<E>>> callQueue = new LinkedList<>();

        State<Node<E>> current = new State<>(root, 0);
        while (current != null) {

            if (current.node != null) {
                callQueue.offer(new State<>(current.node.left, current.level + 1));
                callQueue.offer(new State<>(current.node.right, current.level + 1));
            }

            if (current.level > currLevel) {
                currLevel++;
                treeString.append("\n");
            }

            String toPrint = current.node == null ? "null" : current.node.data.toString();
            treeString.append(toPrint).append(" ");
            current = callQueue.poll();
        }

        currLevel = 0;
        return treeString.toString();
    }
}
