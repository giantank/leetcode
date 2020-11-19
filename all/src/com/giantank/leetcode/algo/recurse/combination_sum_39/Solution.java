package com.giantank.leetcode.algo.recurse.combination_sum_39;

import java.util.*;

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length < 1) {
            return res;
        }
        Arrays.sort(candidates);
        if (candidates[0] - target > 0) {
            return res;
        }
        ArrayDeque<Integer> path = new ArrayDeque<>();
        dfs(candidates, target, 0, path, res);
        return res;
    }

    private void dfs(int[] candidates, int remain, int begin, ArrayDeque<Integer> path, List<List<Integer>> res) {
        if (remain == 0) {
            res.add(new ArrayList<>(path));
        }
        int len = candidates.length;
        for (int i = begin; i < len; i++) {
            if (remain - candidates[i] < 0) {
                continue;
            }
            path.addLast(candidates[i]);
            dfs(candidates, remain - candidates[i], i, path, res);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] candidates = new int[]{2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> result = new Solution().combinationSum(candidates, target);
        System.out.println("result:" + result);
    }
}
