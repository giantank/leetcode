package com.giantank.leetcode.recurse.combination_sum_39;

import java.util.*;

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Set<Integer> set =  new HashSet<>();
        for (Integer candidate: candidates) {
            set.add(candidate);
        }
        List<List<Integer>> subs = new ArrayList<>();
        List<Integer> item = new ArrayList<>();
        subs.add(item);
        for (int i = 0; i < candidates.length; i++) {
            List<List<Integer>> newSubs = new ArrayList<>();
            for (List<Integer> sub: subs) {
                List<Integer> newSub = new ArrayList<Integer>();
                newSub.addAll(sub);
                newSub.add(candidates[i]);
                int sum = computeSum(newSub);
                if (sum > target) {
                    continue;
                }
                newSubs.add(newSub);
            }
            subs.addAll(newSubs);
        }
        List<List<Integer>> result = new ArrayList<>();
        Set<List<Integer>> resultSet = new HashSet<>();
        for (List<Integer> sub: subs) {
            int sum = computeSum(sub);
            if( sum == target) {
                if (!resultSet.contains(sub)) {
                    result.add(sub);
                    resultSet.add(sub);
                }
            } else if (sum < target) {
                int part = target - sum;
                if (set.contains(part)) {
                    List<Integer> tmp = new ArrayList<>();
                    tmp.addAll(sub);
                    tmp.add(part);
                    if (!resultSet.contains(tmp)) {
                        result.add(tmp);
                        resultSet.add(tmp);
                    }
                }
            }
        }
        return result;
    }
    private int computeSum(List<Integer> array) {
        int sum = 0;
        for (Integer item: array) {
            sum = sum + item;
        }
        return sum;
    }
    public static void main(String[] args) {
        int[] candidates = new int[]{2,3,6,7};
        int target = 7;
        List<List<Integer>> result = new Solution().combinationSum(candidates, target);
        System.out.println("result:"+result);
    }
}
