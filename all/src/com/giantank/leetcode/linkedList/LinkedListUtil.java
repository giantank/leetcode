package com.giantank.leetcode.linkedList;

public final class LinkedListUtil {
    private LinkedListUtil(){};
    public static ListNode buildLinkedList(int[] array) {
        ListNode head = null;
        ListNode pre = null;
        for (int i = 0; i < array.length; i++) {
            if (i == 0) {
                head = new ListNode(array[i]);
                pre = head;
                continue;
            }
            ListNode node = new ListNode(array[i]);
            node.next = null;
            pre.next = node;
            pre = node;
        }
        return head;
    }

    public static void printLinkedList(ListNode head) {
        ListNode node = head;
        StringBuffer sb = new StringBuffer("[");
        while (node != null) {
            sb.append(node.val+" ");
            node = node.next;
        }
        sb.append("]");
        System.out.println(sb.toString());
    }
}
