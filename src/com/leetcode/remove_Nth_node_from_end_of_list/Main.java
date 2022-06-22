package com.leetcode.remove_Nth_node_from_end_of_list;

public class Main {

    public static void main(String[] args) {
//        ListNode elem_8 = new ListNode(8, null);
//        ListNode elem_7 = new ListNode(7, elem_8);
//        ListNode elem_6 = new ListNode(6, elem_7);
//        ListNode elem_5 = new ListNode(5, elem_6);
//        ListNode elem_4 = new ListNode(4, elem_5);
//        ListNode elem_3 = new ListNode(3, elem_4);
//        ListNode elem_2 = new ListNode(2, elem_3);
//        ListNode elem_1 = new ListNode(1, elem_2);
//
//        removeNthFromEnd(elem_1, 3);

//        ListNode elem_8 = new ListNode(8, null);
//        ListNode elem_7 = new ListNode(7, elem_8);
//        ListNode elem_6 = new ListNode(6, elem_7);
//        ListNode elem_5 = new ListNode(5, elem_6);
//        ListNode elem_4 = new ListNode(4, elem_5);
//        ListNode elem_3 = new ListNode(3, elem_4);
        ListNode elem_2 = new ListNode(2, null);
        ListNode elem_1 = new ListNode(1, elem_2);

        removeNthFromEnd(elem_1, 2);
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head != null && head.next == null) {
            return null;
        }

        ListNode fast = head;
        int i = 0;
        while (fast.next != null && i < n - 1) {
            fast = fast.next;
            i++;
        }

        // 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8
        // 1 -> 2

        ListNode current = fast;
        ListNode prev = head;
        ListNode prevPrev = null;
        while (current.next != null) {
            current = current.next;
            prevPrev = prev;
            prev = prev.next;
        }

        if (prevPrev == null) {
            return prev.next;
        }

        prevPrev.next = prev.next;

        return head;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    
}
