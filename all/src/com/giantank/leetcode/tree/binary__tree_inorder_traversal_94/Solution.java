package com.giantank.leetcode.tree.binary__tree_inorder_traversal_94;

import com.giantank.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，返回它的中序 遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,3,2]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        if (root.left != null) {
            List<Integer> lefRes = inorderTraversal(root.left);
            res.addAll(lefRes);
        }
        res.add(root.val);
        if (root.right != null) {
            List<Integer> rightRes = inorderTraversal(root.right);
            res.addAll(rightRes);
        }
        return res;
    }
}
