package com.leetcode.add_two_numbers;

public class Solution {

    public static void main(String[] args) {

        ListNode listNode11 = new ListNode(9);
        ListNode listNode10 = new ListNode(9, listNode11);
        ListNode listNode9 = new ListNode(9, listNode10);
        ListNode listNode8 = new ListNode(9, listNode9);
        ListNode listNode7 = new ListNode(9, listNode8);
        ListNode listNode6 = new ListNode(9, listNode7);
        ListNode listNode5 = new ListNode(9, listNode6);

        ListNode listNode4 = new ListNode(9);
        ListNode listNode3 = new ListNode(9, listNode4);
        ListNode listNode2 = new ListNode(9, listNode3);
        ListNode listNode1 = new ListNode(9, listNode2);

        ListNode node = addTwoNumbers(listNode5, listNode1);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode right = l1;
        ListNode left = l2;

        ListNode res = new ListNode();
        ListNode iterNode = res;

        int carryOver = 0;

        while (right != null || left != null) {
            int leftVal = left != null ? left.val : 0;
            int rightVal = right != null ? right.val : 0;

            int result = (leftVal + rightVal + carryOver);
            iterNode.val = result % 10;
            carryOver = result / 10;

            right = right != null ? right.next : null;
            left = left != null ? left.next : null;

            if (right != null || left != null) {
                iterNode.next = new ListNode();
                iterNode = iterNode.next;
            }
        }

        if (carryOver > 0) {
            iterNode.next = new ListNode(carryOver);
        }

        return res;
    }

    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

}



