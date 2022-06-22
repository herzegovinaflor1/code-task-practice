package com.leetcode.search_a_2d_matrix;

public class Solution {

    public static void main(String[] args) {
        System.out.println(searchMatrix(
                new int[][]{
                        {1, 3, 5, 7},
                        {10, 11, 16, 20},
                        {23, 30, 34, 60}
                }, 3)); // true

        System.out.println(searchMatrix(
                new int[][]{
                        {1, 3, 5, 7},
                        {10, 11, 16, 20},
                        {23, 30, 34, 60}
                }, 13)); // false

        System.out.println(searchMatrix(
                new int[][]{{1}}, 0)); // false
        System.out.println(searchMatrix(
                new int[][]{{1}}, 1)); // true

        System.out.println(searchMatrix(
                new int[][]{{1, 3}}, 3)); // true

        System.out.println(searchMatrix(
                new int[][]{{1, 3, 5}}, 5)); // true
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        for (int[] rec : matrix) {
            if (rec[rec.length - 1] >= target) {
                int start = 0, end = rec.length - 1;
                while (start <= end) {
                    int idx = start + (end - start) / 2;
                    if (rec[idx] == target)
                        return true;
                    if (rec[idx] < target)
                        start = idx + 1;
                    else
                        end = idx - 1;
                }
            }
        }

        return false;
    }

}
