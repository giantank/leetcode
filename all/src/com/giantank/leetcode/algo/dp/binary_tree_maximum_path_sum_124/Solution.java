package com.giantank.leetcode.algo.dp.binary_tree_maximum_path_sum_124;

import com.giantank.leetcode.tree.TreeNode;

public class Solution {
    private int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        helper(root);
        return maxSum;
    }
    private int helper(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftMax = Math.max(helper(node.left), 0);
        int rightMax = Math.max(helper(node.right), 0);
        maxSum = Math.max(maxSum, node.val + leftMax + rightMax);
        return node.val + Math.max(leftMax, rightMax);
    }
}
