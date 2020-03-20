package com.giantank.leetcode.algo.recurse.subsets_78;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subs = new ArrayList<>();
        subs.add(new ArrayList<Integer>());
        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> newSubs = new ArrayList<>();
            for (List<Integer> sub: subs) {
                List<Integer> newSub = new ArrayList<>();
                newSub.addAll(sub);
                newSub.add(nums[i]);
                newSubs.add(newSub);
            }
            subs.addAll(newSubs);
        }
        return subs;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        List<List<Integer>> results = new Solution().subsets(nums);
        System.out.println(results);
    }
}
