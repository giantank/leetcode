package com.giantank.leetcode.array.max_area_of_island_695;

public class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int a = area(grid, i, j);
                res = Math.max(res, a);
            }
        }
        return res;
    }

    public int area(int[][] arrays, int r, int c) {
        if (arrays == null || r < 0 || r >= arrays.length || c < 0 || c >= arrays[r].length) {
            return 0;
        }
        if (arrays[r][c] != 1) {
            return 0;
        }
        arrays[r][c] = 2;
        return 1 + area(arrays, r + 1, c) + area(arrays, r - 1, c) + area(arrays, r, c + 1) + area(arrays, r, c - 1);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println("length:" + nums.length);

        int[][] grids = {{1,1,0,0,0},{1,1,0,0,0},{0,0,0,1,1},{0,0,0,1,1}};
        System.out.println(new Solution().maxAreaOfIsland(grids));
    }
}
