package me.lectr1c.F2;

public class Node {

    public String data;

    public Node next;

    public Node(String data){
        this.data = data;
    }

    public Node(String data, Node next){
        this(data);
        this.next = next;
    }
}
