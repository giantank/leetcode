package com.giantank.leetcode;

public class Solution1 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] result = new int[m + n];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                result[k] = nums1[i];
                i++;
            } else {
                result[k] = nums2[j];
                j++;
            }
            k++;
        }
        while (i < m) {
            result[k++] = nums1[i];
            i++;
        }
        while (j < n) {
            result[k++] = nums2[j];
            j++;
        }
        if ((m + n) % 2 == 0 ) {
            return (result[(m + n) / 2 -1] + result[(m + n) / 2]) / 2.0;
        } else {
            return result[(m + n -1) / 2];
        }
    }
    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3};
        int[] nums2 = new int[]{4,5,6};
        System.out.println(new Solution1().findMedianSortedArrays(nums1,nums2));
    }
}
