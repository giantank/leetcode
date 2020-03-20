package com.giantank.leetcode.algo.search.word_search_79;

public class Solution {
    private static final int[][] dirs = {{0,-1},{0,1},{-1,0},{1,0}};
    private int m;
    private int n;
    private boolean[][] marked;
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length < 1) {
            return false;
        }
        m = board.length;
        n = board[0].length;
        if (n < 1) {
            return false;
        }
        marked = new boolean[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (dfs(board,word,i,j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] matrix, String word ,int i, int j ,int start) {
        if (start == word.length() - 1) {
            return matrix[i][j] == word.charAt(start);
        }
        if (matrix[i][j] == word.charAt(start)) {
            marked[i][j] = true;
            for(int[] dir: dirs) {
                int x = i + dir[0];
                int y = j + dir[1];
                if (x >= 0 && x < m && y >= 0 && y < n && !marked[x][y]) {
                    if(dfs(matrix,word,x,y,start + 1)) {
                        return true;
                    }
                }
            }
            marked[i][j] = false;
        }
        return false;
    }

}
