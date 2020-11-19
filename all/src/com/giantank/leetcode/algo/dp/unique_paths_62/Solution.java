package com.giantank.leetcode.algo.dp.unique_paths_62;

import java.util.List;

public class Solution {
    public int uniquePaths(int m, int n) {
        int mn = m + n - 2;
        int k = m - 1;
        long res = 1;
        for (int i = 1; i <= k; i++) {
            res = res * (mn - k + i) / i;
        }
        return (int)res;
    }
}
