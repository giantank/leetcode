package com.giantank.leetcode.linkedList.reverse_linked_list_206;

import com.giantank.leetcode.linkedList.LinkedListUtil;
import com.giantank.leetcode.linkedList.ListNode;

public class Solution2 {
    public ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode current = head;
            head = head.next;
            current.next = newHead;
            newHead = current;
        }
        return newHead;
    }
    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,4,5};
        ListNode head = LinkedListUtil.buildLinkedList(array);
        ListNode result = new Solution2().reverseList(head);
        LinkedListUtil.printLinkedList(result);
    }
}
