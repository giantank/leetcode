package com.giantank.base.priorityqueue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueCustomComparatorExample {
    public static void main(String[] args) {
        //Comparator<String> strLengthComparator = (str1, str2) -> str1.length() - str2.length();
        Comparator<String> strLengthComparator = Comparator.comparingInt(String::length);
        PriorityQueue<String> names = new PriorityQueue<>(strLengthComparator);
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
