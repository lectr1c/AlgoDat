package me.lectr1c.LABA.LAB1;

import java.util.Iterator;

public class Tests {

    public static void main(String[] args) {
        testQ2();
        testQ3();
    }

    private static void testQ3() {
        var list = new SingleLinkedListQ3<Integer>();
        list.add(1);
        System.out.println(list);
        list.add(3);
        System.out.println(list);
        list.add(4);
        System.out.println(list);
        list.add(5);
        System.out.println(list);
        list.add(1, 2);
        System.out.println(list);

        Iterator<Integer> itr = list.iterator();

        itr.next();
        itr.next();
        itr.remove();
        itr.next();
        itr.remove();
        itr.next();
        itr.remove();
        itr.remove();

        System.out.println(list);

    }

    private static void testQ2() {
        var list = new SingleLinkedListQ2<Integer>();
        list.add(1);
        System.out.println(list);
        list.add(3);
        System.out.println(list);
        list.add(4);
        System.out.println(list);
        list.add(5);
        System.out.println(list);
        list.add(1, 2);
        System.out.println(list);

        System.out.println("Removed: " + list.remove(3));
        System.out.println(list);
        System.out.println("Removed: " + list.remove(3));
        System.out.println(list);
        System.out.println("Removed: " + list.remove(0));
        System.out.println(list);

        list.add(4);
        System.out.println(list);
        list.add(5);
        System.out.println(list);
    }

}
