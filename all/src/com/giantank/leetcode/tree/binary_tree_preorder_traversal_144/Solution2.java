package com.giantank.leetcode.tree.binary_tree_preorder_traversal_144;

import com.giantank.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution2 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        res.add(root.val);
        if (root.left != null) {
            List<Integer> leftRes = preorderTraversal(root.left);
            res.addAll(leftRes);
        }
        if (root.right != null) {
            List<Integer> rightRes = preorderTraversal(root.right);
            res.addAll(rightRes);
        }
        return res;
    }
}
