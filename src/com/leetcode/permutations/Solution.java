package com.leetcode.permutations;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        List<List<Integer>> permute = permute(new int[]{1, 2, 3});
        System.out.println(permute);
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        permute(curr, ans, nums);
        return ans;
    }

    public static void permute(List<Integer> current, List<List<Integer>> ans, int[] nums) {
        if (current.size() == nums.length) {
            ans.add(new ArrayList<>(current));
        } else {
            for (int num : nums) {
                if (current.contains(num))
                    continue; // element already exists, skip
                current.add(num);
                permute(current, ans, nums);
                current.remove(current.size() - 1);
            }
        }
    }

}
