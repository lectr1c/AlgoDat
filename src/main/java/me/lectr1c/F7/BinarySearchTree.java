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
    private E deletedData;

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

    private Node<E> delete(E target, Node<E> node) {

        if (node == null) {//target finns ej i trädet
            deletedData = null;
            return null;
        } else {
            if (target.compareTo(node.data) < 0) {//target finns i vänstra trädet
                node.left = delete(target, node.left); //om det finns
                return node;
            } else if (target.compareTo(node.data) > 0) {//target i högra trädet
                node.right = delete(target, node.right);
                return node;
            } else {//target finns i node!
                deletedData = node.data; //lagrar data att returnera

                //nu ska vi bygga om trädet
                if (node.left == null) //noden som ska bort saknar vänster träd
                    return node.right;
                else if (node.right == null)//noden som ska bort saknar högerträd
                    return node.left;
                else {//noden vi ska ta bort har två barn
                    Node<E> nodeToMove = node.right, parentNodeToMove = node;
                    if (nodeToMove.left == null) {//högra barnet har inget vänsterbarn
                        nodeToMove.left = node.left;
                        return nodeToMove;
                    }

                    //högra barnet har vänsterbarn
                    while (nodeToMove.left != null) {
                        parentNodeToMove = nodeToMove;
                        nodeToMove = nodeToMove.left;
                    }
                    parentNodeToMove.left = nodeToMove.right;
                    node.data = nodeToMove.data;
                    return node;
                }
            }
        }
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

    public E findItr(E target){
        var current = root;
        while(target.compareTo(current.data) != 0){
            int delta = target.compareTo(current.data);

            if (delta < 0) current = current.left;
            if (delta > 0) current = current.right;

            if (current == null) break;
        }
        return current == null ? null : current.data;
    }

    public E maxRec(){
        if (root == null) return null;
        return maxRec(root);
    }

    private E maxRec(Node<E> node) {
        return node.right == null ? node.data : maxRec(node.right);
    }

    public E maxItr() {
        var current = root;
        while (current != null && current.right != null){
            current = current.right;
        }
        return current == null ? null : current.data;
    }

    public int numberOfLeaves() {
        if (root == null) return 0;
        return numberOfLeaves(root);
    }

    private int numberOfLeaves(Node<E> node) {
        if (node.left == null && node.right == null) return 1;

        int count = 0;

        if (node.left != null)
            count += numberOfLeaves(node.left);
        if (node.right != null)
            count += numberOfLeaves(node.right);

        return count;
    }

    public int numberOfNodes(){
        return numberOfNodes(root);
    }

    private int numberOfNodes(Node<E> node) {
        return node == null ? 0 : 1 + numberOfNodes(node.left) + numberOfNodes(node.right);
    }

    public int height(){
        return height(root);
    }

    private int height(Node<E> node){
        return node == null ? 0 : 1 + Math.max(height(node.left), height(node.right));
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
