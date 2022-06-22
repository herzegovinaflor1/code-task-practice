package com.leetcode.house_robber;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class Solution {

    public static void main(String[] args) {
        System.out.println(rob(new int[]{2, 7, 9, 3, 1000}));
        System.out.println(rob(new int[]{2, 9, 9, 8, 1, 10, 1}));
        System.out.println(rob(new int[]{1, 2, 3, 1, 30}));
        System.out.println(rob(new int[]{2, 1, 1, 2}));


        System.out.println(rob2(new int[]{2, 7, 9, 3, 1000}));
        System.out.println(rob2(new int[]{2, 9, 9, 8, 1, 10, 1}));
        System.out.println(rob2(new int[]{1, 2, 3, 1, 30}));
        System.out.println(rob2(new int[]{2, 1, 1, 2}));
    }

    public static int rob(int[] nums) {
        int rob1 = 0, rob2 = 0;

        for (int num : nums) {
            int temp = Math.max(num + rob1, rob2);
            rob1 = rob2;
            rob2 = temp;
        }

        return rob2;
    }

    public static int rob2(int[] nums) {
        HashMap<Integer, Integer> indexToSum = new HashMap<>();

        for (int i = nums.length - 1; i >= 0; i--) {
            int num = nums[i];
            if (i + 1 >= nums.length - 1) {
                indexToSum.put(i, num);
            } else {
                int vals = i + 1;
                Integer integer = indexToSum.entrySet().stream()
                        .filter(k -> k.getKey() > vals)
                        .map(Map.Entry::getValue)
                        .max(Comparator.naturalOrder())
                        .get();
                indexToSum.put(i, integer + num);
            }
        }

        return indexToSum.values().stream()
                .max(Comparator.naturalOrder())
                .get();
    }

}
