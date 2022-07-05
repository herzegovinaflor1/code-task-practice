package com.leetcode.longest_consecutive_sequence;

import java.util.PriorityQueue;

public class Solution {

    // TODO: does not work
    public static void main(String[] args) {
        // System.out.println(longestConsecutive(new int[]{100, 4, 200, 1, 3, 2})); // 4
        // System.out.println(longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1})); // 9
        // System.out.println(longestConsecutive(new int[]{9, 1, 4, 7, 3, -1, 0, 5, 8, -1, 6})); //
        System.out.println(longestConsecutive(new int[]{4, 0, -4, -2, 2, 5, 2, 0, -8, -8, -8, -8, -1, 7, 4, 5, 5, -4, 6, 6, -3})); // 5
    }

    public static int longestConsecutive(int[] nums) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for (int i : nums) {
            priorityQueue.add(i);
        }

        int maxCount = 0, count = 0;
        int val = Integer.MIN_VALUE;
        while (priorityQueue.size() > 0) {
            int prior = priorityQueue.poll();
            if (val == Integer.MIN_VALUE) {
                val = prior;
                count++;
            } else {
                int res = prior - val;
                val = prior;
                if (res == 0) {
                    continue;
                }
                if (res == 1) {
                    count++;
                } else {
                    if (count > maxCount) {
                        maxCount = count;
                    }
                    count = 1;
                    val = Integer.MIN_VALUE;
                }
            }
        }

        if (count > maxCount) {
            maxCount = count;
        }
        return maxCount;
    }

}
