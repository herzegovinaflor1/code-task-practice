package com.leetcode.trapping_rain_water;

public class Solution {

    public static void main(String[] args) {
        int trap = trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
        System.out.println(trap); // 6
    }

    public static int trap(int[] heights) {
        int[] maxLeft = new int[heights.length];
        int maxLeftElement = 0;
        for (int i = 0; i < heights.length; i++) {
            if (i == 0) {
                maxLeft[i] = 0;
                maxLeftElement = heights[i];
            } else {
                int elem = heights[i];
                if (elem > maxLeftElement) {
                    maxLeft[i] = maxLeftElement;
                    maxLeftElement = elem;
                } else {
                    maxLeft[i] = maxLeftElement;
                }
            }
        }

        int[] maxRight = new int[heights.length];
        int maxRightElement = 0;
        for (int i = heights.length - 1; i >=  0; i--) {
            if (i == heights.length - 1) {
                maxRight[i] = 0;
                maxRightElement = heights[i];
            } else {
                int elem = heights[i];
                if (elem > maxRightElement) {
                    maxRight[i] = maxRightElement;
                    maxRightElement = elem;
                } else {
                    maxRight[i] = maxRightElement;
                }
            }
        }

        int count = 0;
        for (int i = 0; i < heights.length; i++) {
            int res = Math.min(maxLeft[i], maxRight[i]) - heights[i];
            if (res >= 0) {
                count += res;
            }
        }

        return count;
    }

}
