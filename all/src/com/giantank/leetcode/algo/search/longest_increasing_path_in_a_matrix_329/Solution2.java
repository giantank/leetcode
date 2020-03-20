package com.giantank.leetcode.algo.search.longest_increasing_path_in_a_matrix_329;

public class Solution2 {
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
        int[][] cache = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans = Math.max(ans, dfs(matrix, i, j, cache));
            }
        }
        return ans;
    }

    public int dfs(int[][] matrix, int i, int j, int[][] cache) {
        if (cache[i][j] != 0) {
            return cache[i][j];
        }
        for (int[] dir: dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x >= 0 && x < m && y>= 0 && y < n && matrix[x][y] > matrix[i][j]) {
                cache[i][j] = Math.max(cache[i][j], dfs(matrix, x, y, cache));
            }
        }
        return ++cache[i][j];
    }
}
