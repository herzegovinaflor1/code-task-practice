package com.leetcode.copy_list_with_random_pointer;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        Node elem_5 = new Node(1, null);
        Node elem_4 = new Node(10, elem_5);
        Node elem_3 = new Node(11, elem_4);
        Node elem_2 = new Node(13, elem_3);
        Node elem_1 = new Node(7, elem_2);

        elem_1.random = null;
        elem_2.random = elem_1;
        elem_3.random = elem_5;
        elem_4.random = elem_3;
        elem_5.random = elem_1;

        Node node = copyRandomList(elem_1);
    }

    public static Node copyRandomList(Node head) {
        Map<Node, Node> originalToCopy = new HashMap<>();
        Node node = head;

        Node copy = null;
        Node headCopy = null;

        while (node != null) {
            Node copyOfOriginal = originalToCopy.getOrDefault(node, new Node(node.val));
            originalToCopy.putIfAbsent(node, copyOfOriginal);

            Node copyOfRandom = originalToCopy.getOrDefault(node.random, null);
            if (node.random != null) {
                if (copyOfRandom == null) {
                    copyOfRandom = new Node(node.random.val);
                    originalToCopy.putIfAbsent(node.random, copyOfRandom);
                    copyOfRandom.random = originalToCopy.get(node.random);
                }
            }

            copyOfOriginal.random = copyOfRandom;

            if (copy != null) {
                copy.next = copyOfOriginal;
                copy = copy.next;
            } else {
                copy = copyOfOriginal;
                headCopy = copy;
            }

            node = node.next;
        }

        return headCopy;
    }

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }

    }

}



