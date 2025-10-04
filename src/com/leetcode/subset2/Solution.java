package com.leetcode.subset2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution {

    // https://leetcode.com/problems/subsets-ii/
    public static void main(String[] args) {
        List<List<Integer>> subset2 = subsetsWithDup(new int[]{4,4,4,1,4});
        System.out.println(subset2);
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        subsetsWithDup(new ArrayList<>(), ans, nums, 0);
        return ans;
    }

    private static void subsetsWithDup(List<Integer> curr, List<List<Integer>> ans, int[] nums, int index) {
        if (index == nums.length) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        // All subsets that include nums[i]
        curr.add(nums[index]);
        subsetsWithDup(curr, ans, nums, index + 1);
        curr.remove(curr.size() - 1);

        // All subsets that do not include nums[i]
        while (index + 1 < nums.length && nums[index] == nums[index + 1]) {
            index = index + 1;
        }

        subsetsWithDup(curr, ans, nums, index + 1);
    }

}
