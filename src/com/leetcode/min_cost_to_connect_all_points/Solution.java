package com.leetcode.min_cost_to_connect_all_points;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
//        int[][] points = new int[][] {
//                {0,0},
//                {2,2},
//                {3,10},
//                {5,2},
//                {7,0},
//        };
//
//        System.out.println(new Main3().minCostConnectPoints(points));

//        int[][] points = new int[][] {
//                {3,12},
//                {-2,5},
//                {-4,1},
//        };
//
//        System.out.println(new Main3().minCostConnectPoints(points));
    }

    public int minCostConnectPoints(int[][] points) {
        Map<int[], int[]> visitedNodes = new HashMap<>();

        int totalRes = 0;
        for (int i = 0; i < points.length; i++) {
            int[] node = points[i];

            int minDistance = Integer.MAX_VALUE;
            for (int[] tempNode : points) {
                if (tempNode == node) {
                    continue;
                }
                if (visitedNodes.containsKey(tempNode)) {
                    int[] ints = visitedNodes.get(tempNode);
                    if (node == ints) {
                        minDistance = 0;
                        break;
                    }
                    if (visitedNodes.containsKey(ints)) {
                        continue;
                    }
                }
                int distance = Math.abs(node[0] - tempNode[0]) + Math.abs(node[1] - tempNode[1]);
                if (distance <= minDistance) {
                    visitedNodes.put(node, tempNode);
                }
                minDistance = Math.min(distance, minDistance);
            }
            totalRes += minDistance;

        }

        return totalRes;
    }

}
