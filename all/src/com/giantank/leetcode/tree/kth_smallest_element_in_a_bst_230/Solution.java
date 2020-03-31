package com.giantank.leetcode.tree.kth_smallest_element_in_a_bst_230;

import com.giantank.leetcode.tree.TreeNode;

import java.util.Stack;

public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        if (root == null) {
            return -1;
        }
        int count = 0;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode tmp = root;
        while (tmp != null) {
            stack.push(tmp);
            tmp = tmp.left;
        }
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            count++;
            if (count == k) {
                return node.val;
            }
            if (node.right != null) {
                TreeNode rTmp = node.right;
                while (rTmp != null) {
                    stack.push(rTmp);
                    rTmp = rTmp.left;
                }
            }
        }
        return -1;
    }
}
