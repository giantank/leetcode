package com.giantank.leetcode.stack.implement_queue_using_stacks_232;

import java.util.Stack;

public class MyQueue {
    private Stack<Integer> stack;
    public MyQueue() {
        stack = new Stack<>();
    }
    public void offer(int x) {
        Stack<Integer> temp = new Stack<>();
        while (!stack.isEmpty()) {
            temp.push(stack.peek());
            stack.pop();
        }
        temp.push(x);
        while (!temp.isEmpty()) {
            stack.push(temp.peek());
            temp.pop();
        }
    }

    public int  poll() {
        return stack.pop();
    }

    public int peek() {
        return stack.peek();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public int size() {
        return stack.size();
    }
}
