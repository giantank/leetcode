package com.giantank.leetcode.algo.search.course_schedule_207;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution2 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] flags = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] cp: prerequisites) {
            adj.get(cp[1]).add(cp[0]);
        }
        for (int j = 0; j < numCourses; j++) {
            if (!dfs(adj,flags,j)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(List<List<Integer>> adj, int[] flags, int i) {
        if (flags[i] == 1) {
            return false;
        }
        if (flags[i] == -1) {
            return true;
        }
        flags[i] = 1;
        for (int cur: adj.get(i)) {
            if (!dfs(adj, flags, cur)) {
                return false;
            }
        }
        flags[i] = -1;
        return true;
    }
    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = {{1, 0}};
        boolean res = new Solution2().canFinish(numCourses, prerequisites);
        System.out.println(res);
    }

}
