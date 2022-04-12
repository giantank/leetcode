package com.giantank.base.arraylist;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * The iterator() and listIterator() methods are useful when you need to modify the ArrayList while traversing.
 *
 * Consider the following example, where we remove elements from the ArrayList using iterator.remove() method while traversing through it -
 */
public class ArrayListIteratorRemoveExample {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        nums.add(13);
        nums.add(18);
        nums.add(25);
        nums.add(40);

        Iterator<Integer> numsIterator = nums.iterator();
        while (numsIterator.hasNext()) {
            Integer num = numsIterator.next();
            if (num % 2 != 0) {
                numsIterator.remove();
            }
        }
        System.out.println("after remove(), nums:" + nums);

    }
}
