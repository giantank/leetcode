package com.giantank.leetcode.greedy.wiggle_subsequence_376;

public class Solution {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        int maxLen = 1;
        final int begin = 0;
        final int up = 1;
        final int down = 2;
        int state = begin;
        for (int i = 1; i < nums.length; i++) {
            switch (state) {
                case begin:
                    if (nums[i - 1] < nums[i]) {
                        maxLen++;
                        state = up;
                    } else if (nums[i - 1] > nums[i]) {
                        maxLen++;
                        state = down;
                    }
                    break;
                case up:
                    if (nums[i - 1] > nums[i]) {
                        maxLen++;
                        state = down;
                    }
                    break;
                case down:
                    if (nums[i - 1] < nums[i]) {
                        maxLen++;
                        state = up;
                    }
                    break;
                default:
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,17,5,10,13,15,10,5,16,8};
        int result = new Solution().wiggleMaxLength(nums);
        System.out.println("result:"+result);
    }
}
