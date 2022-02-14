package me.lectr1c.F1;

import me.lectr1c.F1.PhoneDirectory.DirectoryEntry;

import java.sql.Time;
import java.time.Instant;
import java.util.ArrayList;

public class Tests {

    public static void main(String[] args) {

        // P1 and P2 Test
        testP();

        // NB0 Test
        testNB0();

        // NB1 Test
        testNB1();


    }

    private static void testNB1() {

        // NB1 Test
        var entry1 = new DirectoryEntry("Razzaq", "1234");
        var entry2 = new DirectoryEntry("Razzaq", "1234");
        var entry3 = new DirectoryEntry("dadbam", "420");

        System.out.println("Should be true: " + entry1.equals(entry2));
        System.out.println("Should be false: " + entry1.equals(entry3));

    }

    private static void testNB0(){

        // NB0 Test
        NArrayList<Integer> numberList = new NArrayList<>();
        numberList.add(1);
        numberList.add(1);
        numberList.add(3);
        numberList.add(5);
        numberList.add(6);
        numberList.add(9);

        System.out.println(numberList.toString());

        numberList.remove(5);

        try {
            numberList.remove(20);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Index of 5: " + numberList.indexOf(5));

        numberList.add(0, 5);
        numberList.add(1, 4);

        numberList.set(3, 59);

        System.out.println(numberList.toString());

    }

    private static void testP(){
        // P1 and P2 Test
        var array = new ArrayList<String>();
        array.add("hi");
        array.add("ezpz");
        array.add("hi");
        array.add("hi mom");
        array.add("hi mom");
        System.out.println(array.toString());
        P1P2.replace(array, "hi mom", "hi dad");
        P1P2.delete(array, "hi");
        System.out.println(array.toString());
    }

}
