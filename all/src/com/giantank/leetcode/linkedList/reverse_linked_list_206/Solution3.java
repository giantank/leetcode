package com.giantank.leetcode.linkedList.reverse_linked_list_206;

import com.giantank.leetcode.linkedList.LinkedListUtil;
import com.giantank.leetcode.linkedList.ListNode;

public class Solution3 {
    public ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,4,5};
        ListNode head = LinkedListUtil.buildLinkedList(array);
        ListNode result = new Solution3().reverseList(head);
        LinkedListUtil.printLinkedList(result);
    }
}
