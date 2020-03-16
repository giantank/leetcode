package com.giantank.leetcode.tree.binary_tree_level_order_traversal_102;

import com.giantank.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution2 {
    public List<List<Integer>> levels = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return levels;
        }
        order(root, 1);
        return levels;
    }

    public void order(TreeNode node, int level) {
        if (levels.size() < level) {
            levels.add(new ArrayList<Integer>());
        }
        levels.get(level - 1).add(node.val);
        if (node.left != null) {
            order(node.left, level + 1);
        }
        if (node.right != null) {
            order(node.right, level + 1);
        }
    }
}
