package com.leetcode.combination_sum;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{2, 3, 6, 7}, 7));
        System.out.println(combinationSum2(new int[]{2, 3, 6, 7}, 7));
    }

    private static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        backtrack2(candidates, target, ans, cur, 0);
        return ans;
    }

    private static void backtrack2(int[] candidates, int target, List<List<Integer>> ans, List<Integer> cur, int index) {
        if (target < 0) {
            return;
        } else if (target == 0) {
            ans.add(cur);
        } else {
            cur.add(candidates[index]);
            backtrack(candidates, target - candidates[index], ans, cur, index);
            cur.remove(cur.size() - 1);
            backtrack(candidates, target, ans, cur, index + 1);
        }
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        backtrack(candidates, target, ans, cur, 0);
        return ans;
    }

    public static void backtrack(
            int[] candidates,
            int target,
            List<List<Integer>> ans,
            List<Integer> cur,
            int index
    ) {
        if (target == 0) {
            ans.add(new ArrayList<>(cur));
        } else if (target < 0 || index >= candidates.length) {
            return;
        } else {
            cur.add(candidates[index]);
            backtrack(candidates, target - candidates[index], ans, cur, index);

            cur.remove(cur.get(cur.size() - 1));
            backtrack(candidates, target, ans, cur, index + 1);
        }
    }

}
