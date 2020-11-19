package com.giantank.leetcode.algo.dp.perfect_squares_279;

import java.util.Arrays;

public class Solution2 {
    public int numSquares(int n) {
        if (n < 1) {
            return 0;
        }
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        int len = (int) (Math.floor(Math.sqrt(n)));
        int[] squals = new int[len];
        for (int i = 1; i <= len; i++) {
            squals[i - 1] = i * i;
        }
        for (int j = 1; j <= n; j++) {
            for (int s : squals) {
                if (j < s) {
                    break;
                }
                dp[j] = Math.min(dp[j], dp[j - s] + 1);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 555;
        int res = new Solution2().numSquares(n);
        System.out.println(res);
    }
}
