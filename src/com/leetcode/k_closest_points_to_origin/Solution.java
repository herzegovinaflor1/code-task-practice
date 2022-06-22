package com.leetcode.k_closest_points_to_origin;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {

    public static void main(String[] args) {
        int[][] ints = kClosest(new int[][]{{0, 1}, {1, 0}}, 2);
        System.out.println();
    }

    public static int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(
                Comparator.comparingInt(a -> (a[0] * a[0] + a[1] * a[1]))
        );
        priorityQueue.addAll(Arrays.asList(points));

        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            result[i] = priorityQueue.remove();
        }
        return result;
    }

}
