package com.leetcode.diameter_of_binary_tree;

public class Solution {

    static int result = 0;

    public static void main(String[] args) {
        int i = diameterOfBinaryTree(new TreeNode());
    }

    public static int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return result;
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        result = Math.max(result, left + right);
        return 1 + Math.max(left, right);
    }

      public static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }
     

}
