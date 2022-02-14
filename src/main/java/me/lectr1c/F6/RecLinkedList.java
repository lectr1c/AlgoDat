package me.lectr1c.F6;


public class RecLinkedList<E> {

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

    public RecLinkedList(){
        head = null;
        size = 0;
    }

    public void add(int index, E item) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        if (index == 0) {
            addFirst(item);
        } else {
            Node<E> node = getNode(index - 1);
            addAfter(node, item);
        }
    }

    public int getSize(){
        return recSize(head);
    }

    private int recSize(Node<E> node){
        if (node == null) return 0;
        return 1 + recSize(node.next);
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
        return getNode(head, index);
    }

    private Node<E> getNode(Node<E> node, int index){
        if (0 == index) return node;
        return getNode(node.next, index - 1);
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
}
