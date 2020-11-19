package com.giantank.leetcode.algo.search.open_the_lock_752;

import java.util.*;

public class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> visited = new HashSet<>();
        Collections.addAll(visited, deadends);
        Queue<String> queue = new LinkedList<>();
        if (visited.contains("0000")) {
            return -1;
        }
        queue.offer("0000");
        int level = -1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            for (int i = 0; i < size; i++) {
                String node = queue.poll();
                if (node.equals(target)) {
                    return level;
                }
                for (int j = 0; j < 4; j++) {
                    for (int d = -1; d <= 1; d = d + 2) {
                        int x = ((node.charAt(j) - '0') + d + 10) % 10;
                        String tmp = node.substring(0,j) + "" + x + node.substring(j + 1);
                        if (visited.add(tmp)) {
                            queue.add(tmp);
                        }
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String[] deadends = {"0201","0101","0102","1212","2002"};
        String target = "0202";
        int res = new Solution().openLock(deadends, target);
        System.out.println(res);
    }
}

