package com.leetcode.sum3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    // TODO: unfinished, lost my way
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();

        Arrays.sort(nums);

/*        for (int k = 0; k < nums.length - 2; k++) {
            if (k == 0 || nums[k] != nums[k - 1]) {
                int target = -nums[k];
                int i = k + 1;
                int j = nums.length - 1;

                while (i < j) {
                    int num1 = nums[i], num2 = nums[j];
                    if (num1 + num2 == target) {
                        while (i < j && nums[i] == nums[i + 1]) {
                            i++;
                        }

                        while (i < j && nums[j] == nums[j - 1]) {
                            j--;
                        }

                        results.add(Arrays.asList(nums[k], num1, num2));
                    } else if (nums[i] + nums[j] > target) {

                    } else {

                    }
                }
            }
        }

        return results;*/
        return null;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = threeSum(nums);
        System.out.println(lists);

        int[] nums2 = new int[]{
                5, -11, -7, -2, 4, 9, 4, 4, -5, 12, 12, -14, -5, 3, -3, -2, -6, 3, 3, -9, 4, -13, 6, 2, 11, 12, 10, -14,
                -15, 11, 0, 5, 8, 0, 10, -11, -6, -1, 0, 4, -4, -3, 5, -2, -15, 9, 11, -13, -2, -8, -7, 9, -6, 7, -11,
                12, 4, 14, 6, -4, 3, -9, -14, -12, -2, 3, -8, 7, -13, 7, -12, -9, 11, 0, 4, 12, -6, -7, 14, -1, 0, 14,
                -6, 1, 6, -2, -9, -4, -11, 12, -1, -1, 10, -7, -6, -7, 11, 1, -15, 6, -15, -12, 12, 12, 3, 1, 9, 12, 9,
                0, -11, -14, -1
        };
        List<List<Integer>> lists2 = threeSum(nums2);
        System.out.println(lists2);

        int[] nums3 = new int[]{0, 0, 0, 0};
        List<List<Integer>> lists3 = threeSum(nums3);
        System.out.println(lists3);
    }

}
