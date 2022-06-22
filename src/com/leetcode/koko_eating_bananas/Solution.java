package com.leetcode.koko_eating_bananas;

public class Solution {

    public static void main(String[] args) {
        System.out.println(minEatingSpeed(new int[]{3, 6, 7, 11}, 8)); // 4
        // sum(1, 2, 2, 3) = 8
        System.out.println(minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 5)); // 30
        // sum(1, 1, 1, 1, 1) = 5
        System.out.println(minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 6)); // 23
        // sum(2, 1, 1, 1, 1) = 6
    }

    public static int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = Integer.MIN_VALUE;
        for (int i : piles) {
            right = Math.max(i, right);
        }

        while (left < right) {
            int mid = (right + left) / 2;
            int answ = 0;

            for (int i : piles) {
                answ += (i + mid - 1) / mid;
            }

            if (answ > h) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return right;
    }

}
