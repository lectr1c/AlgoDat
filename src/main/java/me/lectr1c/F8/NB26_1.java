package me.lectr1c.F8;

import java.util.HashMap;

public class NB26_1 {
    public static void main(String[] args) {
        String[] words = new String[]{"Hi", "Hi", "yo", "Hi", "yo", "yo", "yo"};
        System.out.println(countMostCommon(words));
    }

    public static int countMostCommon(String[] words){
        HashMap<String, Integer> wordCounter = new HashMap<>(words.length);
        int mostCommon = 0;
        for (String word: words) {
            wordCounter.put(word, wordCounter.containsKey(word) ? wordCounter.get(word) + 1 : 1);
            int count = wordCounter.get(word);
            if (count > mostCommon) mostCommon = count;
        }
        return mostCommon;
    }
}
