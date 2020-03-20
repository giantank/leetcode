package com.giantank.leetcode.tree.validate_binary_search_tree_98;

import com.giantank.leetcode.tree.TreeNode;

public class Solution {
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left != null && root.right != null) {
            if (root.left.val < root.val && root.right.val > root.val) {
                return isValidBST(root.left) && isValidBST(root.right);
            } else {
                return false;
            }
        } else if (root.left == null && root.right != null) {
            if (root.val < root.right.val) {
                return isValidBST(root.right);
            }
        } else if (root.left != null && root.right == null){
            if (root.left.val < root.val) {
                return isValidBST(root.left);
            }
        } else {
            return true;
        }
        return false;
    }
}
