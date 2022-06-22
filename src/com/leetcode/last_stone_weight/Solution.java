package com.leetcode.last_stone_weight;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class Solution {

    public static void main(String[] args) {
        int i = lastStoneWeight(new int[]{2, 2});
        System.out.println(i);
    }

    public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(stones.length, Collections.reverseOrder());
        for(int stone: stones) priorityQueue.add(stone);

        while (priorityQueue.iterator().hasNext()) {
            Integer poll = priorityQueue.remove();
            if (!priorityQueue.iterator().hasNext()) {
                priorityQueue.add(poll);
                break;
            }
            Integer poll1 = priorityQueue.remove();

            int result = poll.intValue() - poll1.intValue();
            if (result > 0) {
                priorityQueue.add(poll.intValue() - poll1.intValue());
            }
        }

        return priorityQueue.isEmpty() ? 0 : priorityQueue.poll();
    }

}
