package com.giantank.base.priorityqueue;

import java.util.PriorityQueue;

public class PriorityQueueExample {
    public static void main(String[] args) {
        PriorityQueue<Integer> numbers = new PriorityQueue<>();
        numbers.add(750);
        numbers.add(500);
        numbers.add(900);
        numbers.add(1000);
        numbers.add(40);
        while(!numbers.isEmpty()) {
            //System.out.println(numbers.remove());
            System.out.println(numbers.poll());
        }
    }
}
