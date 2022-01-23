package me.lectr1c.F2;

public class Tests {

    public static void main(String[] args) {

        // NB2
        IntArrayList integers = new IntArrayList(4);
        integers.add(1);
        integers.add(2);

        System.out.println(integers.get(1));
        integers.set(1, 4);

        integers.add(1,5);
        integers.add(10);
        integers.add(14);
        System.out.println(integers.toString());

        // NB3

        Node[] nodes = new Node[4];
        nodes[3] = new Node("stäppen");
        nodes[2] = new Node("på", nodes[3]);
        nodes[1] = new Node("löper", nodes[2]);
        nodes[0] = new Node("Gilgamesh", nodes[1]);

        nodes[1].next = nodes[3];
        
        StringBuilder linkedString = new StringBuilder();
        Node node = nodes[0];

        while (node.next != null){
            linkedString.append(node.data).append(" --> ");
            node = node.next;
        }

        linkedString.append(node.data);

        System.out.println(linkedString.toString());

    }

}
