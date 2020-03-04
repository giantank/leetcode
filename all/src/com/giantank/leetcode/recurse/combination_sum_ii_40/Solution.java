package com.giantank.leetcode.recurse.combination_sum_ii_40;

import java.util.*;

public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        Set<List<Integer>> set = new HashSet<>();
        List<List<Integer>> subs = new ArrayList<>();
        List<Integer> item = new ArrayList<>();
        subs.add(item);
        for (int i = 0; i < candidates.length; i++) {
            List<List<Integer>> newSubs = new ArrayList<>();
            for (List<Integer> sub: subs) {
                List<Integer> newSub = new ArrayList<>();
                newSub.addAll(sub);
                newSub.add(candidates[i]);
                int sum = computeSum(newSub);
                if (sum > target) {
                    continue;
                }
                if (set.contains(newSub)) {
                    continue;
                }
                newSubs.add(newSub);
                set.add(newSub);
            }
            subs.addAll(newSubs);
        }
        List<List<Integer>> result = new ArrayList<>();
        for (List<Integer> sub: subs) {
            if (computeSum(sub) == target) {
                result.add(sub);
            }
        }
        return result;
    }

    private int computeSum(List<Integer> array) {
        int sum = 0;
        for (int j = 0; j < array.size(); j++) {
            sum = sum + array.get(j);
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] candidates = new int[]{2,5,2,1,2};
        int target = 5;
        List<List<Integer>> result = new Solution().combinationSum2(candidates, target);
        System.out.println("result:" + result);
    }
}
