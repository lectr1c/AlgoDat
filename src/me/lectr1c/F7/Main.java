package me.lectr1c.F7;

public class Main {
    public static void main(String[] args) {
        var bst = new BinarySearchTree<String>();
        bst.add("H");
        bst.add("B");
        bst.add("N");
        bst.add("A");
        bst.add("E");
        bst.add("C");
        bst.add("F");
        bst.add("D");

        System.out.println(bst.printTrees());
        System.out.println("leaves: " + bst.numberOfLeaves() + " nodes: " + bst.numberOfNodes());
        System.out.println("Find B: " + bst.findItr("B"));
        System.out.println("Max Recursive: " + bst.maxRec());
        System.out.println("Max Iterative: " + bst.maxItr());
    }
}
