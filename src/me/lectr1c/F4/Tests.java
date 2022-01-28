package me.lectr1c.F4;

import me.lectr1c.F3.PostFixEvaluator;

public class Tests {

    public static void main(String[] args) {
        var infix = new InfixToPostFix();
        try {
            System.out.println(infix.eval("2 + 2"));
        } catch (PostFixEvaluator.SyntaxErrorException e){
            e.printStackTrace();
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

        /*
        Reallocate är fel då den använder sig av den originala size och har problem med att kopiera in elementarna
        ArrayQueueNB81{front=0, rear=2, size=2, maxSize=5, data=[1, 2, null, null, null]}
        ArrayQueueNB81{front=0, rear=3, size=3, maxSize=5, data=[1, 2, 3, null, null]}
        ArrayQueueNB81{front=0, rear=4, size=4, maxSize=5, data=[1, 2, 3, 4, null]}
        ArrayQueueNB81{front=0, rear=5, size=5, maxSize=5, data=[1, 2, 3, 4, 5]}
        ArrayQueueNB81{front=0, rear=6, size=6, maxSize=10, data=[1, 2, 3, 4, 5, 6, null, null, null, null]}
        ArrayQueueNB81{front=3, rear=6, size=3, maxSize=10, data=[1, 2, 3, 4, 5, 6, null, null, null, null]}
         */


        var dequeue = new LinkedDequeue<Integer>();

        dequeue.offerFirst(1);
        dequeue.offerFirst(2);
        System.out.println(dequeue.toString() + " Size: " + dequeue.size());
        dequeue.offerFirst(3);
        dequeue.offerLast(4);
        System.out.println(dequeue.toString() + " Size: " + dequeue.size());

        dequeue.pollFirst();
        System.out.println(dequeue.toString() + " Size: " + dequeue.size());

        dequeue.pollLast();
        System.out.println(dequeue.toString() + " Size: " + dequeue.size());

    }
}
