package com.leetcode.partition_list;

public class Solution {

    // https://leetcode.com/problems/partition-list/submissions/1759805265/
    public static void main(String[] args) {

        ListNode l6 = new ListNode(0);
        ListNode l5 = new ListNode(5, l6);
        ListNode l4 = new ListNode(2, l5);
        ListNode l3 = new ListNode(3, l4);
        ListNode l2 = new ListNode(4, l3);
        ListNode l1 = new ListNode(1, l2);

        new Solution().partition(l1, 3);
    }

    public ListNode partition(ListNode head, int x) {
        if (head == null) return null;

        ListNode node = head;

        ListNode currentNodeLessThanXHead = null;
        ListNode nodesLessThanXHead = null;

        ListNode currentNodeMoreThanXHead = null;
        ListNode nodesMoreThanXHead = null;

        while (node != null) {
            if (node.val < x) {
                if (nodesLessThanXHead == null) {
                    nodesLessThanXHead = new ListNode(node.val, null);
                    currentNodeLessThanXHead = nodesLessThanXHead;
                } else {
                    currentNodeLessThanXHead.next = new ListNode(node.val, null);
                    currentNodeLessThanXHead = currentNodeLessThanXHead.next;
                }
            } else {
                if (nodesMoreThanXHead == null) {
                    nodesMoreThanXHead = new ListNode(node.val, null);
                    currentNodeMoreThanXHead = nodesMoreThanXHead;
                } else {
                    currentNodeMoreThanXHead.next = new ListNode(node.val, null);
                    currentNodeMoreThanXHead = currentNodeMoreThanXHead.next;
                }
            }

            node = node.next;
        }

        if (currentNodeLessThanXHead != null) {
            currentNodeLessThanXHead.next = nodesMoreThanXHead;
            return nodesLessThanXHead;
        }

        return nodesMoreThanXHead;
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
