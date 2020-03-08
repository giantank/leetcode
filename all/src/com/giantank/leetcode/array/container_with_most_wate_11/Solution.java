package com.giantank.leetcode.array.container_with_most_wate_11;

public class Solution {
    public int maxArea(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int longth = j - i;
                int wideth = Math.min(height[i], height[j]);
                int content = longth * wideth;
                if ( content > max) {
                    max = content;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(new Solution().maxArea(nums));
    }
}
