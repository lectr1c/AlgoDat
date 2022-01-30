package me.lectr1c.LABA.LAB1;

import java.util.Iterator;

public class Tests {

    public static void main(String[] args) {
//        testQ2();
        testQ3();
    }

    private static void testQ2() {
        var l = new SingleLinkedListQ3<String>();
        for (int i = 0; i < 4; i++) l.add("e" + i);
        l.remove(3);
        l.add(0,"först");
        l.add("sist");
        System.out.println(l);
    }

    private static void testQ3() {
        var l = new SingleLinkedListQ3<String>();
        for (int i = 0; i < 4; i++) l.add("e" + i);
        Iterator<String> iter = l.iterator();
        iter.remove();
        System.out.println(l);
    }

}
