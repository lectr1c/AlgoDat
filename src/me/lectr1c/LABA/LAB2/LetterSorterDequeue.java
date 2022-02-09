package me.lectr1c.LABA.LAB2;

import java.util.Deque;
import java.util.LinkedList;

public class LetterSorterDequeue {

    public static void main(String[] args) {
        var pkgSorter = new LetterSorterDequeue();
        System.out.println(pkgSorter.sort("becad"));
    }

    public LetterSorterDequeue(){ }

    public String sort(String startStr){
        Deque<Character> packages = new LinkedList<>();
        for (char c: startStr.toCharArray())
            packages.offer(c);
        return sort(packages, 0);
    }

    private String sort(Deque<Character> packages, int limit) {
        if (isSorted(packages)) return "";
        if (limit > 15) return "XXXXXXXXXEXCEEDEDDEPTHXXXXXXXX";

        swapLastTwo(packages);
        String swap = "b" + sort(packages, limit + 1);
        swapLastTwo(packages);
        moveToEnd(packages);
        String move = "s" + sort(packages, limit + 1);
        reverseMove(packages);


        return move.length() < swap.length() ? move : swap;
    }

    private void swapLastTwo(Deque<Character> packages) {
        if (packages.peekFirst() != null){
            char temp = packages.pollFirst();
            if (packages.peekFirst() != null){
                char temp2 = packages.pollFirst();
                packages.offerFirst(temp);
                packages.offerFirst(temp2);
            }
        }
    }

    private void moveToEnd(Deque<Character> packages) {
        if (packages.peekLast() != null){
            var pkg = packages.pollLast();
            packages.offerFirst(pkg);
        }
    }

    private void reverseMove(Deque<Character> packages) {
        if (packages.peekFirst() != null){
            var pkg = packages.pollFirst();
            packages.offerLast(pkg);
        }
    }

    private boolean isSorted(Deque<Character> packages) {
        var itr = packages.iterator();
        StringBuilder sb = new StringBuilder();
        while (itr.hasNext()){
            sb.append(itr.next());
        }
        return sb.toString().equalsIgnoreCase("abcde");
    }


}
