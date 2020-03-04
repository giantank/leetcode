package com.giantank.leetcode.stack.implement_stack_using_queue_225;

import java.util.LinkedList;
import java.util.Queue;

public class Mystack {
    private Queue<Integer> queue;

    public Mystack() {
        queue = new LinkedList<Integer>();
    }

    public void push(int x) {
        Queue<Integer> temp = new LinkedList<>();
        temp.offer(x);
        while (!queue.isEmpty()) {
            int e = queue.poll();
            temp.offer(e);
        }
        while (!temp.isEmpty()) {
            int e = temp.poll();
            queue.offer(e);
        }
    }
    public boolean  isEmpty() {
        return queue.isEmpty();
    }
}
