package com.giantank.base.priorityqueue;

import java.util.PriorityQueue;

public class PriorityQueueStringExample {
    public static void main(String[] args) {
        PriorityQueue<String> names = new PriorityQueue<>();
        names.add("Lisa");
        names.add("Robert");
        names.add("John");
        names.add("Chris");
        names.add("Angelina");
        names.add("Joe");
        while(!names.isEmpty()) {
            System.out.println(names.remove());
        }
    }
}
