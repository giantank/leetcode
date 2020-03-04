package com.giantank.leetcode.recurse.subsets_78;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    public List<List<Integer>> subsets(int[] nums) {
        return computeSubSet(nums, 0);

    }

    public List<List<Integer>> computeSubSet(int[] nums, int index) {
        List<List<Integer>> set = new ArrayList<>();
        if (index == nums.length ) {
            set.add(new ArrayList<Integer>());
            return set;
        }
        List<List<Integer>> subSet = computeSubSet(nums, index + 1);
        for (List<Integer> sub: subSet) {
            List<Integer> newSub = new ArrayList<>();
            newSub.add(nums[index]);
            newSub.addAll(sub);
            set.add(newSub);
        }
        set.addAll(subSet);
        return set;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        List<List<Integer>> results = new Solution2().subsets(nums);
        System.out.println(results);
    }
}
