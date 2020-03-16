package com.giantank.leetcode.tree.validate_binary_search_tree_98;

import com.giantank.leetcode.tree.TreeNode;

public class Solution {
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left != null ) {
            if (root.left.val >= root.val) {
                return false;
            } else {
                return
            }
        }
    }
}
