package com.leetcode.remove_duplicates_from_sorted_list;

public class Solution {

    // https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/
    public static void main(String[] args) {

//        ListNode listNode7 = new ListNode(5);
//        ListNode listNode6 = new ListNode(4, listNode7);
//        ListNode listNode5 = new ListNode(4, listNode6);
//        ListNode listNode4 = new ListNode(3, listNode5);
//        ListNode listNode3 = new ListNode(3, listNode4);
//        ListNode listNode2 = new ListNode(2, listNode3);
//        ListNode listNode1 = new ListNode(1, listNode2);
//        new Main14().deleteDuplicates(
//                listNode1
//        );


        ListNode listNode5 = new ListNode(3);
        ListNode listNode4 = new ListNode(2, listNode5);
        ListNode listNode3 = new ListNode(1, listNode4);
        ListNode listNode2 = new ListNode(1, listNode3);
        ListNode listNode1 = new ListNode(1, listNode2);
        new Solution().deleteDuplicates(
                listNode1
        );
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode temp = head;
        ListNode last = null;
        ListNode duplicateStart = null;

        while (temp != null) {
            if (duplicateStart != null && duplicateStart.val == temp.val) {
                temp = temp.next;
                continue;
            }
            if (temp.next != null && temp.val == temp.next.val) {
                duplicateStart = temp;
                temp = temp.next;
            } else {
                if (duplicateStart != null && last != null) {
                    last.next = temp;
                }
                if (duplicateStart != null && last == null) {
                    head = temp;
                }
                last = temp;
                temp = temp.next;
                duplicateStart = null;
            }
        }

        return temp;
    }

    static public class ListNode {
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
