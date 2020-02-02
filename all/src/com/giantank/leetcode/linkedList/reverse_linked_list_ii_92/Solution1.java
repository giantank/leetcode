package com.giantank.leetcode.linkedList.reverse_linked_list_ii_92;

import com.giantank.leetcode.linkedList.LinkedListUtil;
import com.giantank.leetcode.linkedList.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class Solution1 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode result  = head;
        ListNode preHead = null;
        int reverseLen = n - m + 1;
        ListNode newHead = null;
        ListNode modifyListTail = null;
        while (head != null && m > 1) {
            preHead = head;
            head = head.next;
            m--;
        }
        modifyListTail = head;
        //逆置
        while (head != null && reverseLen > 0) {
            ListNode next =  head.next;
            head.next = newHead;
            newHead = head;
            head = next;
            reverseLen--;
        }
        modifyListTail.next = head;
        if (preHead != null) {
            preHead.next = newHead;
        } else {
            result = newHead;
        }
        return result;
    }
    public static void main(String[] args) {
        int m = 1;
        int n = 6;
        int[] array = new int[]{1,2,3,4,5,8,4,9,5};
        ListNode head = LinkedListUtil.buildLinkedList(array);
        ListNode result = new Solution1().reverseBetween(head, m, n);
        LinkedListUtil.printLinkedList(result);
    }
}
