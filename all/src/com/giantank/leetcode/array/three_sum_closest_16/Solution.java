package com.giantank.leetcode.array.three_sum_closest_16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 1) {
            return Integer.MIN_VALUE;
        }
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        int[] item = new int[3];
        int sum = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            int remain = target - nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] == remain) {
                    return target;
                }
                int abs = Math.abs(remain - nums[left] - nums[right]);
                if (abs < min) {
                    min = abs;
                    sum = nums[i] + nums[left] + nums[right];
                    item[0] = nums[i];
                    item[1] = nums[left];
                    item[2] = nums[right];
                }
                if (nums[left] + nums[right] < remain) {
                    left++;
                } else {
                    right--;
                }
            }

        }
        System.out.print("[");
        for (int e : item)
            System.out.print(e + ",");
        System.out.print("]\n");
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 2, 1, -3};
        System.out.println(new Solution().threeSumClosest(nums, 1));
    }
}
