package com.giantank.leetcode.tree.binary__tree_inorder_traversal_94;

import com.giantank.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
public class Solution1 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;
        while (temp != null ) {
            stack.push(temp);
            temp = temp.left;
        }
        while ( !stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.add(node.val);
            TreeNode temp2 = node.right;
            while (temp2 != null) {
                stack.push(temp2);
                temp2 = temp2.left;
            }
        }
        return res;
    }
}
