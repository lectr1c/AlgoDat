package me.lectr1c.F6;

public class Tests {
    public static void main(String[] args) {
        mazeMain();
//        var list = new RecLinkedList<Integer>();
//        System.out.println(list.getSize());
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        System.out.println(list.getSize());
    }

    private static void mazeMain(){
        Labyrinth l = new Labyrinth();
        l.print();
        if(l.solve()) System.out.println("Lyckades");
        System.out.println();
        l.print();
    }
}
