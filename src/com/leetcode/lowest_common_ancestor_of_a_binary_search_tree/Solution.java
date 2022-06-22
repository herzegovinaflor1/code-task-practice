package com.leetcode.lowest_common_ancestor_of_a_binary_search_tree;

public class Solution {

    public static void main(String[] args) {
        // lowestCommonAncestor();
    }

    // 6, 2, 4
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (q.val > root.val && p.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        if (q.val < root.val && p.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        return root;
    }


      public static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }

}
