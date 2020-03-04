package com.giantank.leetcode.recurse.subsets_78;

import java.util.ArrayList;
import java.util.List;

public class Solution3 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> item = new ArrayList<Integer>();
        result.add(item);
        computeSubSet(nums, 0, result);
        return result;
    }

    public void computeSubSet(int[] nums, int index, List<List<Integer>> result) {
        // 递归出口
        if (index >= nums.length) {
            return;
        }
        List<List<Integer>> newSubs = new ArrayList<>();
        for (List<Integer> sub: result) {
            List<Integer> newSub = new ArrayList<>();
            newSub.add(nums[index]);
            newSub.addAll(sub);
            newSubs.add(newSub);
        }
        result.addAll(newSubs);
        computeSubSet(nums, index + 1, result);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        List<List<Integer>> results = new Solution3().subsets(nums);
        System.out.println(results);
    }
}
