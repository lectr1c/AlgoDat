package me.lectr1c.F6;

import java.util.LinkedList;
import java.util.Queue;

public class BFBallExchange {

    private static class State {
        int red, white, blue, exchangeCount;
        public State(int red, int white, int blue, int exchangeCount){
            this.red = red;
            this.white = white;
            this.blue = blue;
            this.exchangeCount = exchangeCount;
        }

        @Override
        public String toString(){
            return "State{" +
                    "r: " + red +
                    ", w:" + white +
                    ", b:" + blue +
                    ", count" + exchangeCount +
                    '}';
        }
    }

    public static void main(String[] args) {
        System.out.println(exchange(0, 1, 2, 0));
    }

    public static int exchange(int red, int white, int blue, int exchangeCount){
        Queue<State> callQueue = new LinkedList<>();
        State curr = new State(red, white, blue, exchangeCount);

        while(!isBalanced(curr) && curr.exchangeCount < 15){
            if (curr.blue > 0) callQueue.offer(new State(curr.red + 3, curr.white + 1, curr.blue - 1, curr.exchangeCount + 1));
            if (curr.white > 0) callQueue.offer(new State(curr.red + 4, curr.white - 1, curr.blue + 2, curr.exchangeCount + 1));
            if (curr.red > 0) callQueue.offer(new State(curr.red - 1, curr.white + 5, curr.blue + 1, curr.exchangeCount + 1));
            curr = callQueue.poll();
        }

        return curr.exchangeCount;
    }

    private static boolean isBalanced(State state){
        return state.red == state.white && state.white == state.blue;
    }

}
