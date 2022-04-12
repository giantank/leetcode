package com.giantank.base.arraylist;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * The following example shows how to iterate over an ArrayList using
 *
 * Java 8 forEach and lambda expression.
 * iterator().
 * iterator() and Java 8 forEachRemaining() method.
 * listIterator().
 * Simple for-each loop.
 * for loop with index.
 */
public class IterateOverArrayListExample {
    public static void main(String[] args) {
        List<String> tvs = new ArrayList<>();
        tvs.add("Breaking Bad");
        tvs.add("Game Of Thrones");
        tvs.add("Friends");
        tvs.add("Prison break");
        System.out.println("=== iterator using java8 forEach and lambda");
        tvs.forEach(tv -> System.out.println(tv));
        System.out.println("\n=== Iterate using an iterator() ===");
        Iterator<String> tvIterator = tvs.iterator();
        while (tvIterator.hasNext()) {
            String tvShow = tvIterator.next();
            System.out.println(tvShow);
        }
        System.out.println("\n=== Iterate using an iterator() and java8 forEachRemaining() method");
        tvIterator = tvs.iterator();
        tvIterator.forEachRemaining(tv -> {
            System.out.println(tv);
        });
        System.out.println("\n=== Iterate using a listIterator() to traverse in both directions ===");
        // here, we start from the end of the list and traverse backwards
        ListIterator<String> listIterator = tvs.listIterator(tvs.size());
        while (listIterator.hasPrevious()) {
            int index = listIterator.previousIndex();
            String tvShow = listIterator.previous();
            System.out.println("index: " + index + ", tvShow:"+tvShow);
        }
        System.out.println("\n==== Iterate using simple for-each loop===");
        for (String tvShow : tvs) {
            System.out.println(tvShow);
        }
        System.out.println("\n==== Iterate using for loop with index===");
        for (int i = 0; i < tvs.size(); i++) {
            System.out.println(tvs.get(i));
        }

    }
}
