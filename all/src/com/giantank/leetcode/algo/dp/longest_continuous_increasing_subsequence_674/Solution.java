package com.giantank.leetcode.algo.dp.longest_continuous_increasing_subsequence_674;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        int max = 1;
        List<Integer> seq = new ArrayList<>();
        seq.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                if (seq.size() > max) {
                    max = seq.size();
                }
                seq.clear();
            }
            seq.add(nums[i]);
        }
        return Math.max(seq.size(), max);
    }
    public static void main(String[] args) {
        int[] nums = new int[]{1,3,5,7};
        int res = new Solution().findLengthOfLCIS(nums);
        System.out.println(res);
    }
}
