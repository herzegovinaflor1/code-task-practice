package com.leetcode.top_k_frequent_elements;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)));
        System.out.println(Arrays.toString(topKFrequent(new int[]{4, 1, -1, 2, -1, 2, 3}, 2)));
    }

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Long> collect = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return collect.entrySet().stream()
                .sorted((t1, t2) -> t2.getValue().compareTo(t1.getValue()))
                .limit(k)
                .map(Map.Entry::getKey)
                .mapToInt(Integer::intValue)
                .toArray();
    }

}
