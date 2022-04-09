package com.giantank.base.queue;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class IterateOverQueueExample {
    public static void main(String[] args) {
        Queue<String> waitQueue = new LinkedList<>();
        waitQueue.add("John");
        waitQueue.add("Brad");
        waitQueue.add("Angelina");
        waitQueue.add("Julia");
        System.out.println("=== Iterating over a Queue using Java 8 ForEach() ===");
        waitQueue.forEach(name -> {
            System.out.println(name);
        });

        System.out.println("\n==== Iterating over a Queue using iterator() ===");
        Iterator<String> waitQueueIterator = waitQueue.iterator();
        while (waitQueueIterator.hasNext()) {
            String person = waitQueueIterator.next();
            System.out.println(person);
        }

        System.out.println("\n=== Iterating over a Queue using simple for-each loop===");
        for (String name: waitQueue) {
            System.out.println(name);
        }
    }
}
