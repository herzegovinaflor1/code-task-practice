package com.leetcode.merge_two_sorted_lists;

public class Main {

    public static void main(String[] args) {
        ListNode elem_3 = new ListNode(4, null);
        ListNode elem_2 = new ListNode(2, elem_3);
        ListNode elem_1 = new ListNode(1, elem_2);

        ListNode elem_3_2 = new ListNode(4, null);
        ListNode elem_2_2 = new ListNode(3, elem_3_2);
        ListNode elem_1_2 = new ListNode(1, elem_2_2);

        ListNode mergedTwoLists = mergeTwoLists(elem_1_2, elem_1);
    }

    static class T {
        int t;

        public T(int t) {
            this.t = t;
        }
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode node = new ListNode();
        ListNode prev = node;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                prev.next = list1;
                list1 = list1.next;
            } else {
                prev.next = list2;
                list2 = list2.next;
            }
            prev = prev.next;
        }

        prev.next = list1 == null ? list2 : list1;

        return node.next;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public ListNode() {

        }
    }

}
