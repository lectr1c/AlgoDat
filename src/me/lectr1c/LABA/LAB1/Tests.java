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
        System.out.println(list.debugString());
        list.add(3);
        System.out.println(list.debugString());
        list.add(4);
        System.out.println(list.debugString());
        list.add(5);
        System.out.println(list.debugString());
        list.add(1, 2);
        System.out.println(list.debugString());

        Iterator<Integer> itr = list.iterator();

        while(itr.hasNext()){
            var number = itr.next();
            System.out.println(number);

            if (number == 1 || number == 3 || number == 5) {
                itr.remove();
                System.out.println("Removed: " + number);
                System.out.println(list.debugString());
            }
        }

        System.out.println(list.debugString());

    }

    private static void testQ2() {
        var list = new SingleLinkedListQ2<Integer>();
        list.add(1);
        System.out.println(list.debugString());
        list.add(3);
        System.out.println(list.debugString());
        list.add(4);
        System.out.println(list.debugString());
        list.add(5);
        System.out.println(list.debugString());
        list.add(1, 2);
        System.out.println(list.debugString());

        System.out.println("Removed: " + list.remove(3));
        System.out.println(list.debugString());
        System.out.println("Removed: " + list.remove(3));
        System.out.println(list.debugString());
        System.out.println("Removed: " + list.remove(0));
        System.out.println(list.debugString());

        list.add(4);
        System.out.println(list.debugString());
        list.add(5);
        System.out.println(list.debugString());
    }

}
