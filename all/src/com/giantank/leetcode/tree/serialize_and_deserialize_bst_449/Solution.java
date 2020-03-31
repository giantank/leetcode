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
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        String res = "";
        if (root == null) {
            return res;
        }
        List<Integer> list = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                list.add(node.val);
            } else {
                list.add(null);
            }
            if (node.left == null && node.right == null) {
                continue;
            }
            queue.offer(node.left);
            queue.offer(node.right);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            Integer e = list.get(i);
            if (e != null) {
                sb.append(e);
            } else {
                sb.append("null");
            }
            if (i != list.size() - 1) {
                sb.append(",");
            }
        }
        res = sb.toString();
        return res;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.trim().length() < 1) {
            return null;
        }
        String[] vals = data.split(",");
        int len = vals.length;
        if (len < 1) {
            return null;
        }
        TreeNode root = null;
        Map<Integer, TreeNode> indexMap = new HashMap<>();
        for (int i = 0; i < len; i++) {
            TreeNode node = indexMap.get(i);
            if (node == null) {
                node = createTreeNode(vals[i]);
                if (node == null) {
                    continue;
                }
                indexMap.put(i, node);
            }
            if (i == 0) {
                root = node;
            }
            int leftIndex = 2 * i + 1;
            if (leftIndex < len && !"null".equals(vals[leftIndex])) {
                TreeNode leftNode = createTreeNode(vals[leftIndex]);
                if (leftNode != null) {
                    indexMap.put(leftIndex, leftNode);
                    node.left = leftNode;
                }
            }
            int rightIndex = 2 * i + 2;
            if (rightIndex < len && !"null".equals(vals[rightIndex])) {
                TreeNode rightNode = createTreeNode(vals[rightIndex]);
                if (rightNode != null) {
                    indexMap.put(rightIndex, rightNode);
                    node.right = rightNode;
                }

            }
        }
        return root;
    }

    private TreeNode createTreeNode(String val) {
        if (val == null) {
            return null;
        }
        Integer intVal = 0;
        try {
            intVal = Integer.parseInt(val);
        } catch (NumberFormatException e) {
            return null;
        }
        TreeNode node = new TreeNode(intVal);
        return node;
    }

}
