package me.lectr1c.F4;

import me.lectr1c.F3.PostFixEvaluator;

public class Tests {

    public static void main(String[] args) {
        var infix = new P7();
        try {
            System.out.println(infix.eval("1 + 3 * 2"));
        } catch (PostFixEvaluator.SyntaxErrorException e){
            e.getMessage();
        }



        ArrayQueueNB8_1<Integer> queue = new ArrayQueueNB8_1<>(5);
        queue.offer(1);
        System.out.println(queue.toString());
        queue.offer(2);
        System.out.println(queue.toString());
        queue.offer(3);
        System.out.println(queue.toString());
        queue.offer(4);
        System.out.println(queue.toString());
        queue.offer(5);
        System.out.println(queue.toString());
        queue.offer(6);
        System.out.println(queue.toString());

        queue.poll();
        queue.poll();
        queue.poll();
        System.out.println(queue.toString());


    }
}
