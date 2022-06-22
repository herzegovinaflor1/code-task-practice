package com.leetcode.pacific_atlantic_water_flow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        pacificAtlantic(new int[][]{
                {1,2},
                {2,1}
        });
    }

    public static List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;

        Set<Tuple> atlantic = new HashSet<>();
        Set<Tuple> pacific = new HashSet<>();

        for (int i = 0; i < rows; i++) {
            dfs(0, i, pacific, heights, heights[0][i], cols, rows);
        }

        return null;
    }

    private static void dfs(int i, int col, Set<Tuple> set, int[][] heights, int prevValue, int cols,  int rows) {

    }

    private static class Tuple {
        int i;

        public Tuple(int i, int j) {
            this.i = i;
            this.j = j;
        }

        int j;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Tuple tuple = (Tuple) o;
            return i == tuple.i && j == tuple.j;
        }

        @Override
        public int hashCode() {
            return Objects.hash(i, j);
        }
    }

}
