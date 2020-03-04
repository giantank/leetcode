package com.giantank.leetcode.recurse.subsets_ii_90;

import java.util.*;

public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<Integer>());
        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> newSubs = new ArrayList<>();
            for (List<Integer> sub: result) {
                List<Integer> newSub = new ArrayList<Integer>();
                newSub.addAll(sub);
                newSub.add(nums[i]);
                if (!set.contains(newSub)) {
                    newSubs.add(newSub);
                    set.add(newSub);
                }
            }
            result.addAll(newSubs);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,2};
        List<List<Integer>> results = new Solution().subsetsWithDup(nums);
        System.out.println(results);
    }
}
