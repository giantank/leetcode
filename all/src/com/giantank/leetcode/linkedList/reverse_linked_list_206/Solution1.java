package com.giantank.leetcode.linkedList.reverse_linked_list_206;

import com.giantank.leetcode.linkedList.LinkedListUtil;
import com.giantank.leetcode.linkedList.ListNode;
import sun.awt.image.ImageWatched;

public class Solution1 {
    public ListNode reverseList(ListNode head) {
        ListNode newHead = new ListNode(-1);
        newHead.next = null;
        while (head != null) {
            ListNode current = head;
            head = head.next;
            current.next = newHead.next;
            newHead.next = current;
        }
        return newHead.next;
    }
    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,4,5,8,4,9,5};
        ListNode head = LinkedListUtil.buildLinkedList(array);
        ListNode result = new Solution1().reverseList(head);
        LinkedListUtil.printLinkedList(result);
    }
}
