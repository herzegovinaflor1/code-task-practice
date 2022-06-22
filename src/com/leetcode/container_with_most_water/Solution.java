package com.leetcode.container_with_most_water;

public class Solution {

    public static void main(String[] args) {
        int result = maxArea(new int[] {1,8,6,2,5,4,8,3,7});
        System.out.println(result); // 49
    }

    public static int maxArea(int[] height) {
        int square = 0;

        int first = 0;
        int last = height.length - 1;

        while (first < last) {
            int elemFromFirst = height[first];
            int elemFromLast = height[last];

            int distance = last - first;
            int newSquare = Math.min(elemFromFirst, elemFromLast) * distance;
            if (newSquare > square) {
                square = newSquare;
            }
            if (elemFromFirst > elemFromLast) {
                last--;
            } else {
                first++;
            }
        }

        return square;
    }

}
