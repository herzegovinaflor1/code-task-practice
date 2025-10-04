package com.leetcode.course_schedule;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
//        int [][] array = new int[][] {
//                {0, 1},
//                {0, 2},
//                {1, 3},
//                {1, 4},
//                {3, 4},
//        };
//
//        int numCourses = 5;
//
//        System.out.println(new Main().canFinish(numCourses, array));

//        int [][] array = new int[][] {
//                {1, 0},
//        };
//
//        int numCourses = 1;
//
//        System.out.println(new Main().canFinish(numCourses, array));

        int [][] array = new int[][] {
                {1, 0},
                {0, 1},
        };

        int numCourses = 2;

        System.out.println(new Solution().canFinish(numCourses, array));
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> nodeToNodes = new HashMap<>();

        for (int i = 0; i < prerequisites.length; i++) {
            int keyNode = prerequisites[i][0];
            for (int j = 1; j < prerequisites[0].length; j++) {
                if (!nodeToNodes.containsKey(keyNode)) {
                    Set<Integer> nodes = new HashSet<>();
                    nodes.add(prerequisites[i][j]);
                    nodeToNodes.put(keyNode, nodes);
                } else {
                    Set<Integer> integers = nodeToNodes.get(keyNode);
                    integers.add(prerequisites[i][j]);
                }
            }
        }

        int res = 1;
        Set<Map.Entry<Integer, Set<Integer>>> entries = nodeToNodes.entrySet();

        int maxRes = 1;
        for (Map.Entry<Integer, Set<Integer>> entry : entries) {
            Set<Integer> directions = entry.getValue();
            for (Integer direction: directions) {
                Set<Integer> integers = nodeToNodes.get(direction);
                if (integers != null) {
                    Queue<Integer> stack = new ArrayDeque<>(integers);
                    HashSet<Integer> visitedValues = new HashSet<>();
                    while (!stack.isEmpty()) {
                        res++;
                        Integer poll = stack.poll();
                        if (!visitedValues.contains(poll)) {
                            visitedValues.add(poll);
                        } else {
                            break;
                        }
                        if (nodeToNodes.get(poll) != null) {
                            stack.addAll(nodeToNodes.get(poll));
                        }
                    }
                    maxRes = Math.max(maxRes, res);
                }
            }
        }

        return numCourses == maxRes;
    }

}
