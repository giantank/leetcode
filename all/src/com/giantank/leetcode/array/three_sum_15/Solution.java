package com.giantank.leetcode.array.three_sum_15;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int[] nums = new int[]{-4, -2, 1, -5, -4, -4, 4, -2, 0, 4, 0, -2, 3, 1, -5, 0};
        System.out.println(new Solution().threeSum(nums));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);
        int zeroIndex = getMidIndex(0, nums, 0, nums.length - 1);
        if (zeroIndex == -1) {
            return result;
        }
        for (int i = 0; i < zeroIndex; i++) {
            if (nums[i] == 0 && (zeroIndex - 1 - i >= 2)) {
                List<Integer> item = new ArrayList<Integer>();
                item.add(nums[i]);
                item.add(nums[i + 1]);
                item.add(nums[i + 2]);
                set.add(item);
                break;
            }
            for (int j = zeroIndex; j < nums.length; j++) {
                List<Integer> item = new ArrayList<Integer>();
                item.add(nums[i]);
                item.add(nums[j]);
                int surplus = 0 - nums[i] - nums[j];
                if (surplus > 0) {
                    for (int k = j + 1; k < nums.length; k++) {
                        if (nums[k] > surplus) {
                            break;
                        }
                        if (nums[k] == surplus) {
                            item.add(nums[k]);
                            set.add(item);
                            break;
                        }
                    }
                } else {
                    for (int k = i + 1; k < zeroIndex; k++) {
                        if (nums[k] > surplus) {
                            break;
                        }
                        if (nums[k] == surplus) {
                            item.add(nums[k]);
                            set.add(item);
                            break;
                        }
                    }
                }
            }
        }
        for (List<Integer> item : set) {
            result.add(item);
        }
        return result;
    }

    public int getMidIndex(int key, int[] array, int start, int end) {
        if (array == null || start < 0 || end > array.length - 1) {
            return -1;
        }
        for (int i = start; i <= end; i++) {
            if (array[i] > key) {
                return i;
            }
        }
        return end;
    }
}
