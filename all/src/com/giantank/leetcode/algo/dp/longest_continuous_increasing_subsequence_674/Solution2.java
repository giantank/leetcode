package com.giantank.leetcode.algo.dp.longest_continuous_increasing_subsequence_674;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        int max = 1;
        int anchor = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                anchor = i;
            }
            max = Math.max(max, i - anchor + 1);
        }
        return max;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{1,3,5,7};
        int res = new Solution2().findLengthOfLCIS(nums);
        System.out.println(res);
    }
}
