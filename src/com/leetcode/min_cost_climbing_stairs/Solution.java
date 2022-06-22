package com.leetcode.min_cost_climbing_stairs;

public class Solution {

    public static void main(String[] args) {
        System.out.println(minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
        System.out.println(minCostClimbingStairs(new int[]{10, 15, 20}));
        System.out.println(minCostClimbingStairs(new int[]{0, 2, 2, 1}));
    }

    public static int minCostClimbingStairs(int[] cost) {
        for (int i = cost.length - 2; i >= 0; i--) {
            int safeExtract = i + 2 > cost.length - 1 ? 0 : cost[i + 2];
            int resOfStep1 = cost[i] + cost[i + 1];
            int resOfStep2 = cost[i] + safeExtract;
            int min = Math.min(resOfStep1, resOfStep2);
            cost[i] = min;
        }

        return Math.min(cost[0], cost[1]);
    }

}
