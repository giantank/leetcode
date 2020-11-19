package com.giantank.leetcode.test;


import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class LRUCache {
    private Stack<Integer> stack = new Stack<>();
    private Map<Integer, Integer> map = new HashMap<>();
    private int capacity = 0;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public void put(int key, int value) {
        if (map.size() < capacity) {
            map.put(key, value);
            stack.push(key);
            return;
        }
        int lastKey = stack.pop();
        map.remove(lastKey);
        map.put(key, value);
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            return map.get(key);
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1,1);
        cache.put(2,2);
        System.out.println(cache.get(1));
        cache.put(3,3);
        System.out.println(cache.get(2));
        cache.put(4,4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));

    }
}
