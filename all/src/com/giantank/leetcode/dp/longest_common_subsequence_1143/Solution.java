package com.giantank.leetcode.dp.longest_common_subsequence_1143;

public class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        if (text1 == null || text1.length() < 1 || text2 == null || text2.length() < 1) {
            return 0;
        }
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        //初始化dp[0][0], dp[0][1],dp[1][0]
       /* if (text1.charAt(0) == text2.charAt(0)) {
            dp[0][0] = 1;
        } else {
            dp[0][0] = 0;
        }
        if (m < 2 || n < 2) {
            return dp[0][0];
        }
        if (text1.charAt(0) == text2.charAt(1)) {
            dp[0][1] = dp[0][0] + 1;
        } else {
            dp[0][1] = dp[0][0];
        }
        if (m > 1 && text2.charAt(0) == text1.charAt(1)) {
            dp[1][0] = dp[0][0] + 1;
        } else {
            dp[1][0] = dp[0][0];
        }*/

        dp[0][0] = 0;
        if (n > 0) {
            dp[0][1] = 0;
        }
        if (m > 0) {
            dp[1][0] = 0;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][ n];
    }
    public static void main(String[] args) {
        String text1 = "ezupkr";
        String text2 = "ubmrapg";
        System.out.println(new Solution().longestCommonSubsequence(text1,text2));
    }
}
