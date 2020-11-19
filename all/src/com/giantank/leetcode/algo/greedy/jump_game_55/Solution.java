package com.giantank.leetcode.algo.greedy.jump_game_55;

import java.util.LinkedList;

public class Solution {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length < 2) {
            return true;
        }
        LinkedList<Integer> q = new LinkedList<>();
        int len = nums.length;
        for (int i = len - 2; i >= 0; i--) {
            if (nums[i] >= len - 1 -i) {
                if (i == 0) {
                    return true;
                }
                q.offer(i);
            }
        }
        while (!q.isEmpty()) {
            int index = q.poll();
            for (int j = index - 1; j >= 0; j--) {
                if (nums[j] >= index - j && j == 0) {
                    return true;
                }
                if (nums[j] >= index - j && !q.contains(j)) {
                    q.offer(j);
                }
            }
        }
        return false;

    }
}
