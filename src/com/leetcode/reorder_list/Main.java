package com.leetcode.reorder_list;

public class Main {

    public static void main(String[] args) {
        ListNode elem_8 = new ListNode(8, null);
        ListNode elem_7 = new ListNode(7, elem_8);
        ListNode elem_6 = new ListNode(6, elem_7);
        ListNode elem_5 = new ListNode(5, elem_6);
        ListNode elem_4 = new ListNode(4, elem_5);
        ListNode elem_3 = new ListNode(3, elem_4);
        ListNode elem_2 = new ListNode(2, elem_3);
        ListNode elem_1 = new ListNode(1, elem_2);

        // reorderList(elem_1);

        ListNode elem_1_1 = new ListNode(1, null);
        reorderList(elem_1_1);
    }

    public static void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        //       Find middle node (slow)
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        //    Reverse   the second sublist
        ListNode current = slow.next;
        ListNode prev = null;

        while (current.next != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        current.next = prev;

        //  re-assign links
        // 1 -> 2 -> 3
        // 6 -> 5 -> 4
        // 1 -> 6
        ListNode first = head;
        ListNode second = current;

        while (second != null) {
            ListNode nextFromFirst = first.next;
            ListNode nextFromSecond = second.next;

            first.next = second;
            second.next = nextFromFirst;

            first = nextFromFirst;
            second = nextFromSecond;
        }
        first.next = null;
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
