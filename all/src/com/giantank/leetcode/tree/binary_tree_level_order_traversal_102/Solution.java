package com.giantank.leetcode.tree.binary_tree_level_order_traversal_102;

import com.giantank.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        LinkedList<List<TreeNode>> queue = new LinkedList<>();
        List<TreeNode> firstLevelNodes = new ArrayList<>();
        firstLevelNodes.add(root);
        queue.offer(firstLevelNodes);
        while (!queue.isEmpty()) {
            List<TreeNode> levelNodes = queue.poll();
            // 将当前层所有节点组成一个组放入队列
            List<TreeNode> currentLevelNodes = new ArrayList<>();
            List<Integer> level = new ArrayList<>();
            for (TreeNode node: levelNodes) {
                level.add(node.val);
                if (node.left != null) {
                    currentLevelNodes.add(node.left);
                }
                if (node.right != null) {
                    currentLevelNodes.add(node.right);
                }
            }
            res.add(level);
            if (!currentLevelNodes.isEmpty()) {
                queue.offer(currentLevelNodes);
            }
        }
        return res;
    }
}
