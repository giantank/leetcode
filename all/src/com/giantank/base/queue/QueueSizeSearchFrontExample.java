package com.giantank.base.queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueSizeSearchFrontExample {

    public static void main(String[] args) {
        Queue<String> waitQueue = new LinkedList<>();

        waitQueue.add("Jennifer");
        waitQueue.add("Angelina");
        waitQueue.add("Johnny");
        waitQueue.add("Sachin");

        System.out.println("WaitQueue:" + waitQueue);

        System.out.println("is waitQueue empty?:" + waitQueue.isEmpty());

        System.out.println("Size of waitQueue:" + waitQueue.size());

        // Check if the Queue contains an element
        String name = "Johnny";
        if (waitQueue.contains(name)) {
            System.out.println("WaitQueue contains:" + name);
        } else {
            System.out.println("WaitQueue Queue doesn't contain" + name);
        }

        // Get the element at the front of the Queue without removing it using element()
        // The element() method throws NoSuchElementException if the Queue is empty
        String firstPersonInTheWaitingQueue = waitQueue.element();
        System.out.println("First Person in the Waiting Queue (element():" + firstPersonInTheWaitingQueue);

        // Get the element at the front of the Queue without removing it using peek()
        // The peek() method is similar to element() except that it returns null if the Queue is empty
        firstPersonInTheWaitingQueue = waitQueue.peek();
        System.out.println("First Person in the Waiting Queue:" + firstPersonInTheWaitingQueue);
    }
}
