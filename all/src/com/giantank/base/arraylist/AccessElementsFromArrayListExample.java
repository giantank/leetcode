package com.giantank.base.arraylist;

import java.util.ArrayList;
import java.util.List;

public class AccessElementsFromArrayListExample {
    public static void main(String[] args) {
        List<String> topCompanies = new ArrayList<>();
        System.out.println("is the topCompanies list empty?:" + topCompanies.isEmpty());
        topCompanies.add("Google");
        topCompanies.add(("Apple"));
        topCompanies.add("Microsoft");
        topCompanies.add("Amazon");
        topCompanies.add("Facebook");
        System.out.println("Here are the top " + topCompanies.size() + " companies in the world");
        System.out.println(topCompanies);

        //Retrieve the element at a given index
        System.out.println("Best company:"+ topCompanies.get(0));
        System.out.println("Second Best Company:" + topCompanies.get(2));
        System.out.println("Last Company in the lis:" + topCompanies.get(topCompanies.size() - 1));
        // modify the element at a given index
        topCompanies.set(4, "Walmart");
        System.out.println("Modified top companies list:" + topCompanies);
    }
}
