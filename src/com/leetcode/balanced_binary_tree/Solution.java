package com.leetcode.balanced_binary_tree;

public class Solution {

    static boolean isBalanced = true;

    public static void main(String[] args) {

    }

    public boolean isBalanced(TreeNode root) {
        maxDepth(root);
        return isBalanced;
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        isBalanced = isBalanced && Math.abs(left - right) <= 1;
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
