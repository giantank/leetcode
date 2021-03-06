package com.giantank.leetcode.algo.dp.house_robber_198;

public class Solution2 {
    public int rob(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        if (nums.length < 2) {
            return nums[0];
        }
        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i + 1] = Math.max(dp[i-1] + nums[i], dp[i]) ;
            System.out.println("dp[" + (i + 1) + "]:" + dp[i + 1]);
        }
        return dp[nums.length];
    }

    public static void main(String[] args) {
        int[] nums = {2,7,9,3,1};
        int res = new Solution2().rob(nums);
        System.out.println(res);
    }
}
