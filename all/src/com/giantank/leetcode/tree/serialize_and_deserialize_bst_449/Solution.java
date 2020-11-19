package com.giantank.leetcode.tree.serialize_and_deserialize_bst_449;

import com.giantank.leetcode.tree.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.*;

/**
 * 序列化是将数据结构或对象转换为一系列位的过程，以便它可以存储在文件或内存缓冲区中，或通过网络连接链路传输，以便稍后在同一个或另一个计算机环境中重建。
 * <p>
 * 设计一个算法来序列化和反序列化二叉搜索树。 对序列化/反序列化算法的工作方式没有限制。 您只需确保二叉搜索树可以序列化为字符串，并且可以将该字符串反序列化为最初的二叉搜索树。
 * <p>
 * 编码的字符串应尽可能紧凑。
 * <p>
 * 注意：不要使用类成员/全局/静态变量来存储状态。 你的序列化和反序列化算法应该是无状态的。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/serialize-and-deserialize-bst
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public String serialize(TreeNode root) {
        StringBuilder sb = postOrder(root, new StringBuilder());
        if (sb.length() < 1) {
            return null;
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.trim().length() < 1) {
            return null;
        }
        String[] dataStrs = data.split(",");
        ArrayDeque<Integer> dataArray = new ArrayDeque<Integer> ();
        for (String str: dataStrs) {
            dataArray.add(Integer.parseInt(str));
        }
        int lower = Integer.MIN_VALUE;
        int upper = Integer.MAX_VALUE;
        TreeNode root = helper(lower, upper, dataArray);
        return root;
    }

    private StringBuilder  postOrder(TreeNode root, StringBuilder sb) {
        if (root == null) return sb;
        postOrder(root.left, sb);
        postOrder(root.right, sb);
        sb.append(root.val);
        sb.append(',');
        return sb;

    }

    private  TreeNode helper(Integer lower, Integer upper, ArrayDeque<Integer> dataArray) {
        if (dataArray.isEmpty()) {
            return null;
        }
        Integer val = dataArray.getLast();
        if ( val > upper || val < lower) {
            return null;
        }
        val = dataArray.removeLast();
        TreeNode root = new TreeNode(val);
        root.right = helper(val, upper, dataArray);
        root.left = helper(lower, val, dataArray);
        return root;
    }

}
