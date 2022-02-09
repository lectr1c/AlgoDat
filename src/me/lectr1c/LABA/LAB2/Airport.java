package me.lectr1c.LABA.LAB2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Airport {

    public static void main(String[] args) {
        Airport ap = new Airport();
        ap.runSim();
        System.out.println("inc avg wait time: " + ap.getAverageIncWaitTime());
        System.out.println("out avg wait time: " + ap.getAverageOutWaitTime());
        System.out.println("inc max wait time: " + ap.getMaxIncWaitTime());
        System.out.println("out max wait time: " + ap.getMaxOutWaitTime());
    }

    private static class Airplane {
        public int timestamp;

        public Airplane(int timestamp) {
            this.timestamp = timestamp;
        }
    }

    private int tickrate;
    private int timestamp;

    private int activeTimeLeft;

    private int maxIncWaitTime;
    private int maxOutWaitTime;

    private int totalIncWaitTime;
    private int totalOutWaitTime;

    private int totalIncPlanes;
    private int totalOutPlanes;

    private final Queue<Airplane> incoming;
    private final Queue<Airplane> outgoing;
    private final Random random;

    public Airport(){
        tickrate = 5;
        activeTimeLeft = 0;
        timestamp = 0;
        incoming = new LinkedList<>();
        outgoing = new LinkedList<>();
        random = new Random();

        maxIncWaitTime = 0;
        maxOutWaitTime = 0;
        totalIncWaitTime = 0;
        totalOutWaitTime = 0;
        totalIncPlanes = 0;
        totalOutPlanes = 0;
    }

    public void runSim(){
        runSim(10);
    }

    public void runSim(float years){
        runSim(5, years);
    }

    public void runSim(int tickrateMinutes, float years){
        this.tickrate = tickrateMinutes;
        int toHour = 60/tickrateMinutes;
        int loopCount = (int) (toHour * 24 * 365 * years);

        for (int i = 0; i <= loopCount; i++)
            tick();
    }

    public void tick(){
        if (random.nextFloat() <= 0.05){
            incoming.offer(new Airplane(timestamp));
            totalIncPlanes++;
        }

        if (random.nextFloat() <= 0.05){
            outgoing.offer(new Airplane(timestamp));
            totalOutPlanes++;
        }

        if (activeTimeLeft > 0) activeTimeLeft -= tickrate;

        if (activeTimeLeft <= 0)
            if (!handleIncoming())
                handleOutgoing();

        totalIncWaitTime += tickrate * incoming.size();
        totalOutWaitTime += tickrate * outgoing.size();
        timestamp += tickrate;
    }

    private boolean handleIncoming() {
        if (incoming.peek() != null){
            var plane = incoming.poll();
            var waitTime = timestamp - plane.timestamp;
            if (waitTime > maxIncWaitTime)
                maxIncWaitTime = waitTime;
            activeTimeLeft = 20;
            return true;
        }
        return false;
    }

    private void handleOutgoing() {
        if (outgoing.peek() != null){
            var plane = outgoing.poll();
            var waitTime = timestamp - plane.timestamp;
            if (waitTime > maxOutWaitTime){
                maxOutWaitTime = waitTime;
            }
            activeTimeLeft = 20;
        }
    }

    public float getAverageIncWaitTime(){
        return  (float) totalIncWaitTime / (float) totalIncPlanes;
    }

    public float getAverageOutWaitTime(){
        return (float) totalOutWaitTime / (float) totalOutPlanes;
    }

    public int getMaxIncWaitTime() {
        return maxIncWaitTime;
    }

    public int getMaxOutWaitTime() {
        return maxOutWaitTime;
    }
}
