package com.leetcode.contains_duplicate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        System.out.println(containsDuplicate(new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2}));
    }

    public static boolean containsDuplicate(int[] nums) {
        List<Integer> collect = Arrays.stream(nums)
                .distinct()
                .boxed()
                .collect(Collectors.toList());
        return nums.length != collect.size();
    }

}
