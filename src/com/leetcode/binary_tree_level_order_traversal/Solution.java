package com.leetcode.binary_tree_level_order_traversal;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

public class Solution {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);

        root.right = new TreeNode(3);
        root.right.right = new TreeNode(5);

        levelOrder(root);
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        /**
         *      1
         *    /  \
         *   2    3
         *  /      \
         * 4        5
         */
        if (root == null) {
            return Collections.emptyList();
        }
        List<List<Integer>> traversal = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        traversal.add(Collections.singletonList(root.val));
        while (!queue.isEmpty()) {
            ArrayDeque<TreeNode> treeNodes = new ArrayDeque<>(queue);
            queue.clear();
            ArrayList<Integer> nodes = new ArrayList<>();
            for (TreeNode tn: treeNodes) {
                TreeNode poll = treeNodes.poll(); // <- I do pull here and size reduces
                if (poll.left != null) {
                    queue.add(poll.left);
                    nodes.add(poll.left.val);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                    nodes.add(poll.right.val);
                }
            }

            if (!nodes.isEmpty()) {
                traversal.add(nodes);
            }
        }

        return traversal;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}
