package com.giantank.leetcode.array.intersection_of_two_arrays_349;

import java.util.*;

public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length < 1 || nums2 == null || nums2.length < 1) {
            return new int[0];
        }
        Set<Integer> setOfNum1 = new HashSet<>(nums1.length);
        for (int num: nums1) {
            setOfNum1.add(num);
        }
        Set<Integer> resSet = new HashSet<>();
        for (int num2: nums2) {
            if (setOfNum1.contains(num2)) {
                resSet.add(num2);
            }
        }
        int[] res = new int[resSet.size()];
        int count = 0;
        for (Integer el: resSet) {
            res[count++] = el;
        }
        return res;
    }

    public int[] intersection2(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length < 1 || nums2 == null || nums2.length < 1) {
            return new int[0];
        }
        List<Integer> res = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int index1 = 0;
        int index2 = 0;
        int pre = Integer.MAX_VALUE;
        while(index1 < nums1.length && index2 < nums2.length) {
            if (nums1[index1] == nums2[index2]) {
               if (nums1[index1] != pre) {
                   res.add(nums1[index1]);
                   pre = nums1[index1];
               }
               index1++;
            } else if (nums1[index1] < nums2[index2]) {
                index1++;
            } else {
               index2++;
            }
        }
        if (res.size() < 1) {
            return new int[0];
        }
        int[] result = res.stream().mapToInt(Integer::intValue).toArray();
        return result;
    }
    public static void main(String[] args) {
        int[] nums1 = new int[] {4,9,5};
        int[] nums2 = new int[] {9,4,9,8,4};
        Solution solution = new Solution();
        int[] res = solution.intersection(nums1, nums2);
        solution.print(res);
    }

    private void print(int[] res) {
        System.out.print("[");
        for(int num: res) {
            System.out.print(num + ",");
        }
        System.out.println("]");
    }
}
