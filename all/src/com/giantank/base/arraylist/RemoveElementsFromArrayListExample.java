package com.giantank.base.arraylist;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/*
This example shows:
How to remove the element at a given index in an ArrayList | remove(int index)
How to remove an element from an ArrayList | remove(Object o)
How to remove all the elements from an ArrayList that exist in a given collection | removeAll()
How to remove all the elements matching a given predicate | removeIf()
How to clear an ArrayList | clear()
 */
public class RemoveElementsFromArrayListExample {
    public static void main(String[] args) {
        List<String> programLanguages = new ArrayList<>();
        programLanguages.add("C++");
        programLanguages.add("Java");
        programLanguages.add("C");
        programLanguages.add("Kotlin");
        programLanguages.add("Python");
        programLanguages.add("Javascript");
        programLanguages.add("Perl");
        programLanguages.add("Ruby");
        System.out.println("Initial list: " + programLanguages);
        // Remove the element at index 5
        programLanguages.remove(5);
        System.out.println("after remove(5), programLanguages:" + programLanguages);
        // Remove all the elements that exist in a given collection
        List<String> scriptLanguages = new ArrayList<>();
        scriptLanguages.add("Python");
        scriptLanguages.add("Ruby");
        scriptLanguages.add("Perl");
        programLanguages.removeAll(scriptLanguages);
        System.out.println("After removeAll(scriptLanguages), programLanguages:" + programLanguages);
        // remove all the elements that satisfy the given predicate
        /*programLanguages.removeIf(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.startsWith("C");
            }
        });*/
        programLanguages.removeIf(language -> language.startsWith("C"));
        System.out.println("After Removing all elements that start with \"C\":" + programLanguages);
        // Remove all elements from the ArrayList
        programLanguages.clear();
        System.out.println("After clear():" + programLanguages);
    }
}
