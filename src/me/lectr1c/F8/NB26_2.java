package me.lectr1c.F8;

import java.util.Arrays;
import java.util.HashSet;

public class NB26_2 {
    public static void main(String[] args) {
        String[] words = new String[]{"Hi", "Hi", "yo", "hi", "yo", "yo", "yo", "unik"};
        System.out.println(uniqueCount(words));
    }

    public static int uniqueCount(String[] words) {
        return new HashSet<String>(Arrays.asList(words)).size();
    }
}
