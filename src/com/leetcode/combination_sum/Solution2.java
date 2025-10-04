package com.leetcode.combination_sum;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {

    // https://leetcode.com/problems/combination-sum/description/
    public static void main(String[] args) {
        System.out.println(
                new Solution2().combinationSum(
                        new int[] {
                                2,3,5
                        },
                        8
                )
        );
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();

        backtrack(
                0,
                candidates,
                target,
                new ArrayList<>(),
                result,
                0
        );

        return result;
    }

    private void backtrack(
            int index,
            int[] nums,
            int target,
            List<Integer> elements,
            List<List<Integer>> result,
            int sum
    ) {
        if (sum == target) {
            result.add(new ArrayList<>(elements));
            return;
        }
        if (index == nums.length || sum > target) {
            return;
        } else {
            elements.add(nums[index]);
            sum += nums[index];
            backtrack(index, nums, target, elements, result, sum);

            elements.remove(elements.size() - 1);
            sum -= nums[index];
            backtrack(index + 1, nums, target, elements, result, sum);
        }
    }

}
