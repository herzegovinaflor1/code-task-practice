package com.leetcode.search_in_rotated_sorted_array;

public class Solution {

    public static void main(String[] args) {
        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0)); // 4;
        System.out.println(search(new int[]{1}, 1)); // 0;
        System.out.println(search(new int[]{1, 3}, 3)); // 1;
        System.out.println(search(new int[]{3, 1}, 1)); // 1;
    }

    public static int search(int[] nums, int target) {
        int position = -1;

        int lastNum = Integer.MIN_VALUE;
        int startIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            int number = nums[i];
            if (number < lastNum || i == nums.length - 1) {
                int start = startIndex, end = i;
                while (start <= end) {
                    int idx = start + (end - start) / 2;
                    if (nums[idx] == target) {
                        position = idx;
                        break;
                    }
                    if (nums[idx] < target)
                        start = idx + 1;
                    else
                        end = idx - 1;
                }
                startIndex = i;
            }
            lastNum = number;
        }

        if (position < 0) {
            int start = startIndex, end = nums.length - 1;
            while (start <= end) {
                int idx = start + (end - start) / 2;
                if (nums[idx] == target) {
                    position = idx;
                    break;
                }
                if (nums[idx] < target)
                    start = idx + 1;
                else
                    end = idx - 1;
            }
        }

        return position;
    }

}
