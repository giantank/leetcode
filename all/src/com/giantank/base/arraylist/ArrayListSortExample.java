package com.giantank.base.arraylist;

import java.util.*;

public class ArrayListSortExample {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Lisa");
        names.add("Jennifer");
        names.add("Mark");
        names.add("David");
        System.out.println("Names: " + names);
        //  Sort an ArrayList using its sort() method. You must pass a Comparator to the ArrayList.sort() method.
        names.sort((name1, name2) -> name1.compareTo(name2));
        System.out.println("Sorted Names:" + names);
        // Following is an even more concise solution
        names.sort(Comparator.naturalOrder());
        System.out.println("Sorted Names: " + names);

        String[] strNames = new String[]{"Lisa","Jennifer", "Mark", "David"};
        Arrays.sort(strNames, Collections.reverseOrder());
        System.out.println("Socrted strNames:" + String.join(",",strNames));
    }
}
