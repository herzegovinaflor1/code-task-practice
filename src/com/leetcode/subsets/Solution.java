package com.leetcode.subsets;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        List<List<Integer>> subsets = subsets(new int[]{1, 2, 3});
        System.out.println(subsets);

        List<List<Integer>> subsets2 = subsets2(new int[]{1, 2, 3});
        System.out.println(subsets2);
    }


    public static List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper(ans, 0, nums, list);
        return ans;
    }

    public static void helper(
            List<List<Integer>> ans,
            int start,
            int[] nums,
            List<Integer> list
    ) {
        if (start >= nums.length) {
            ans.add(new ArrayList<>(list));
        } else {
            // add the element and start the  recursive call
            list.add(nums[start]);
            helper(ans, start + 1, nums, list);
            // remove the element and do the backtracking call.
            list.remove(list.size() - 1);
            helper(ans, start + 1, nums, list);
        }
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();

        generateSubsets(0, nums, new ArrayList<>(), subsets);

        return subsets;
    }

    private static void generateSubsets(int index, int[] nums, ArrayList<Integer> current, List<List<Integer>> subsets) {
        subsets.add(new ArrayList<>(current));
        for (int i = index; i < nums.length; i++) {
            current.add(nums[i]);
            generateSubsets(i + 1, nums, current, subsets);
            current.remove(current.size() - 1);
        }
    }

}
