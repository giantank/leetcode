package com.giantank.leetcode.algo.dp.house_robber_198;

public class Solution3 {
    public int rob(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        if (nums.length < 2) {
            return nums[0];
        }
        int preMax = 0;
        int curMax = 0;
        for (int num: nums) {
            int temp = curMax;
            curMax = Math.max(preMax + num, curMax);
            preMax = temp;
        }
       return curMax;
    }

    public static void main(String[] args) {
        int[] nums = {2,7,9,3,1};
        int res = new Solution3().rob(nums);
        System.out.println(res);
    }
}
