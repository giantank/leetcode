package com.giantank.leetcode.heap.kth_largest_element_in_an_array_215;

import java.util.Arrays;

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}
