package com.leetcode.find_minimum_in_rotated_sorted_array;

public class Solution {

    public static void main(String[] args) {
        System.out.println(findMin(new int[] {3,4,5,1,2}));
        System.out.println(findMin(new int[] {1}));
    }

    public static int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int i = 0;
        int j = nums.length - 1;

        int min = Integer.MAX_VALUE;

        while (i < j) {
            int left = nums[i];
            int right = nums[j];

            if (nums[j] > min) {
                break;
            } else {
                if (left < right) {
                    return left;
                }
                min = nums[j];
            }
            j--;
        }

        return min;
    }

}
