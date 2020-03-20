package com.giantank.leetcode.algo.search.longest_increasing_path_in_a_matrix_329;

import com.sun.xml.internal.fastinfoset.tools.XML_SAX_StAX_FI;

public class Solution {
    private static final int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
    private int m;
    private int n;
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length < 1) {
            return 0;
        }
        int ans = 0;
        m = matrix.length;
        n = matrix[0].length;
        if (n < 1) {
            return 0;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans = Math.max(ans, dfs(matrix, i, j));
            }
        }
        return ans;
    }

    public int dfs(int[][] matrix, int i, int j) {
        int res = 0;
        for (int[] dir: dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x >= 0 && x < m && y>= 0 && y < n && matrix[x][y] > matrix[i][j]) {
                res = Math.max(res, dfs(matrix, x, y));
            }
        }
        return res + 1;
    }
}
