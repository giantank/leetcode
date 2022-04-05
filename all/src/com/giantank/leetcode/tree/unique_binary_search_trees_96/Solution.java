package com.giantank.leetcode.tree.unique_binary_search_trees_96;



public class Solution {
    public int numTrees(int n) {
        return numTrees(1,n);
    }

    private int numTrees(int start, int end) {
        int nums = 0;
        if (start == end) {
           return 1;
        }
        if (start > end) {
           return 1;
        }
        for (int i = start; i <= end; i++) {
            int leftN = numTrees(start, i - 1);
            int rightN = numTrees(i + 1, end);
            nums = nums + leftN * rightN;
        }
        return nums;
    }

    public static void main(String[] args) {
        int res = new Solution().numTrees(19);
        System.out.println(res);
    }
}
