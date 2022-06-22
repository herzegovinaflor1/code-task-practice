package com.leetcode.max_area_of_island;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        int i = maxAreaOfIsland(new int[][]{
                {1, 1, 1, 1, 0},
                {1, 1, 0, 1, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 0, 1, 1}
        });
        System.out.println(i);
    }

    public static int maxAreaOfIsland(int[][] grid) {
        int xLength = grid.length;
        int yLength = grid[0].length;

        Set<VisitedNode> visitedCharacters = new HashSet<>();
        Set<VisitedNode> visitedCharactersForIsland = new HashSet<>();
        int maxSize = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1 && !visitedCharacters.contains(new VisitedNode(i, j))) {
                    dfs(visitedCharactersForIsland, grid, i, j, xLength, yLength);
                    maxSize = Math.max(maxSize, visitedCharactersForIsland.size());
                    visitedCharacters.addAll(visitedCharactersForIsland);
                    visitedCharactersForIsland.clear();
                }
            }
        }

        return maxSize;
    }

    private static void dfs(Set<VisitedNode> visitedCharacters, int[][] grid, int i, int j, int xLength, int yLength) {
        if (
                visitedCharacters.contains(new VisitedNode(i, j)) ||
                        i < 0 ||
                        j < 0 ||
                        i >= xLength ||
                        j >= yLength ||
                        grid[i][j] == 0
        ) {
            return;
        }
        visitedCharacters.add(new VisitedNode(i, j));

        dfs(visitedCharacters, grid, i, j-1, xLength, yLength);
        dfs(visitedCharacters, grid, i, j+1, xLength, yLength);
        dfs(visitedCharacters, grid, i-1, j, xLength, yLength);
        dfs(visitedCharacters, grid, i+1, j, xLength, yLength);
    }

    private static class VisitedNode {
        int i;
        int j;

        public VisitedNode(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            VisitedNode that = (VisitedNode) o;
            return i == that.i && j == that.j;
        }

        @Override
        public int hashCode() {
            return Objects.hash(i, j);
        }
    }

}
