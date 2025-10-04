package com.leetcode.merge_intervals;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(
                        new Solution().merge(
                                new int[][]{
                                        {1, 3},
                                        {2, 6},
                                        {8, 10},
                                        {15, 18},
                                }
                        )
                )
        );
    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(
                intervals,
                Comparator.comparingInt((int[] a) -> a[0])
                        .thenComparing((int[] a) -> a[1])
        );

        ArrayDeque<int[]> overlaps = new ArrayDeque<>();
        for (int[] interval : intervals) {
            if (overlaps.isEmpty()) {
                overlaps.add(interval);
                continue;
            }

            int[] previousInterval = overlaps.getLast();

            if (interval[0] >= previousInterval[0] && interval[0] <= previousInterval[1]) {
                previousInterval[1] = Math.max(interval[1], previousInterval[1]);
            } else if ((interval[1] >= previousInterval[0] && interval[1] <= previousInterval[1])) {
                previousInterval[0] =  Math.max(interval[0], previousInterval[0]);
            } else {
                overlaps.add(interval);
            }
        }

        return overlaps.toArray(new int[overlaps.size()][]);
    }

}
