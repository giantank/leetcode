package com.giantank.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        LinkedList<TreeNode> nodes = new LinkedList<>();
        nodes.offer(this);
        while (!nodes.isEmpty()) {
            TreeNode node = nodes.poll();
            if (node != null) {
                sb.append(node.val + ",");
                nodes.offer(node.left);
                nodes.offer(node.right);
            } else {
                sb.append("null,");
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");
        return sb.toString();
    }

    /*@Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }*/
}
