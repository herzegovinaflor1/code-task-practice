package com.leetcode.combination_sum_II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        combinationSum2(new int[] {10,1,2,7,6,1,5}, 8);
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
//        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        subsetsWithDup(new ArrayList<>(), ans, candidates, 0, target);
        return ans;
    }

    private static void subsetsWithDup(
            List<Integer> curr, List<List<Integer>> ans, int[] nums, int index, int target) {
        if (target == 0) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        if (target < 0) {
            curr.remove(curr.size() - 1);
            return;
        }

        curr.add(nums[index]);
        subsetsWithDup(curr, ans, nums, index + 1, target - nums[index]);

        while (index < nums.length && nums[index] - target >= 0) {
            index++;
        }
        subsetsWithDup(curr, ans, nums, index, target - nums[index]);
    }

}
