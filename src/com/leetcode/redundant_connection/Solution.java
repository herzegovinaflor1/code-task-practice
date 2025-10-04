package com.leetcode.redundant_connection;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    // https://leetcode.com/problems/redundant-connection/description/
    public static void main(String[] args) {
//        int[][] array = new int[][] {
//                {1,2},
//                {1,3},
//                {2,3},
//        };
//
//        System.out.println(
//                Arrays.toString(new Main2().findRedundantConnection(array))
//        );

        int[][] array = new int[][] {
                {1,2},
                {2,3},
                {3,4},
                {1,4},
                {1,5},
        };

        System.out.println(
                Arrays.toString(new Solution().findRedundantConnection(array))
        );
    }

    public int[] findRedundantConnection(int[][] edges) {
        Set<Integer> visitedSecondaryGraph = new HashSet<>();
        int [] lastRes = new int[2];
        for (int[] edge : edges) {
            int val = edge[1];
            if (!visitedSecondaryGraph.contains(val)) {
                visitedSecondaryGraph.add(edge[1]);
            } else {
                lastRes = edge;
            }
        }

        return lastRes;
    }

}
