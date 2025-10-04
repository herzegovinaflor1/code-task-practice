package com.leetcode.subset2;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {

    public static void main(String[] args) {
        System.out.println(
                new Solution2().subsets(
                        new int[] {2,3,6,7}
                )
        );
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        backtrack(
            0,
            nums,
            new ArrayList<>(),
            result
        );

        return result;
    }

    public void backtrack(
        int index,
        int[] nums,
        List<Integer> elements,
        List<List<Integer>> result
    ) {
        if (index == nums.length) {
            result.add(new ArrayList<>(elements));
            System.out.println("Results: " + elements + "; index: " + index);
            System.out.println();
        } else {
            backtrack(index + 1, nums, elements, result);
            elements.add(nums[index]);
            System.out.println("Added element: " + elements + "; index: " + index);

            backtrack(index + 1, nums, elements, result);
            elements.remove(elements.size() - 1);
            System.out.println("Remove element: " + elements + "; index: " + index);
        }
    }

}
