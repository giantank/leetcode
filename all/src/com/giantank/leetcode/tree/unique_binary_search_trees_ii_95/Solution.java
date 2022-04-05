package com.giantank.leetcode.tree.unique_binary_search_trees_ii_95;

import com.giantank.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<TreeNode> generateTrees(int n) {
       return generateTrees(1, n);
    }

    private List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> ans = new ArrayList<>();
        if (start == end) {
            ans.add(new TreeNode(start));
            return ans;
        }
        if (start > end) {
            ans.add(null);
            return ans;
        }
        for (int i = start; i <= end; i++) {
           List<TreeNode> leftTrees = generateTrees(start, i - 1);
           List<TreeNode> rightTrees = generateTrees(i + 1, end);
           for (TreeNode leftTree: leftTrees) {
               for (TreeNode rightTree: rightTrees) {
                   TreeNode root = new TreeNode(i);
                   root.left = leftTree;
                   root.right = rightTree;
                   ans.add(root);
               }
           }
        }
        return ans;
    }

    public static void main(String[] args) {
        List<TreeNode> res = new Solution().generateTrees(19);
        System.out.println(res.size());
        //System.out.println(res);
    }
}
