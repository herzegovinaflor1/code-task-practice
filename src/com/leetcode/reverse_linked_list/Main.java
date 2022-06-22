package com.leetcode.reverse_linked_list;

public class Main {

    public static void main(String[] args) {
        ListNode elem_5 = new ListNode(5, null);
        ListNode elem_4 = new ListNode(4, elem_5);
        ListNode elem_3 = new ListNode(3, elem_4);
        ListNode elem_2 = new ListNode(2, elem_3);
        ListNode elem_1 = new ListNode(1, elem_2);

        ListNode reversed = reverseList(elem_1);
    }

    public static ListNode reverseList(ListNode head) {
        // Input: head = [1,2,3,4,5]
        // Input: head = 1 -> 2 -> 3 -> 4 -> 5 -> null
        // Input: head = null <- 1 <- 2 <- 3 <- 4 <- 5

        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
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
