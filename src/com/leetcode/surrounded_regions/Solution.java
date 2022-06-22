package com.leetcode.surrounded_regions;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class Solution {

    public static void main(String[] args) {
        solve(new char[][]{
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        });

        solve(new char[][]{
                {'X', 'O', 'X'},
                {'X', 'O', 'X'},
                {'X', 'O', 'X'}
        });

        solve(new char[][]{
                {'O', 'X', 'O'},
                {'X', 'O', 'X'},
                {'O', 'X', 'O'}
        });
    }

    public static void solve(char[][] board) {
        int col = board.length;
        int row = board[0].length;

        Set<Tuple> visited = new HashSet<>();
        Set<Tuple> captureToX = new HashSet<>();
        Set<Tuple> x = new HashSet<>();
        AtomicInteger forceReturn = new AtomicInteger();
        forceReturn.set(0);
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                dfs(i, j, board, x, captureToX, visited);
                if (x.size() >= 4) {
                    for (Tuple tuple : captureToX) {
                        if ((tuple.i == 0 && board[tuple.i][tuple.j] == 'O')
                                || (tuple.i == col - 1 && board[tuple.i][tuple.j] == 'O')
                                || (tuple.j == 0 && board[tuple.i][tuple.j] == 'O')
                                || (tuple.j == row - 1 && board[tuple.i][tuple.j] == 'O')
                        ) {
                            forceReturn.set(1);
                        }
                    }
                    if (forceReturn.get() == 0) {
                        for (Tuple tuple : captureToX) {
                            board[tuple.i][tuple.j] = 'X';
                        }
                    }
                }
                captureToX.clear();
                x.clear();
                forceReturn.set(0);
                visited.clear();
            }
        }
    }

    public static void dfs(int i, int j, char[][] board, Set<Tuple> x, Set<Tuple> captureToX, Set<Tuple> visited) {
        int col = board.length;
        int row = board[0].length;
        Tuple tuple = new Tuple(i, j);
        if (
                i < 0 || i >= col
                        || j < 0 || j >= row
                        || visited.contains(tuple)
        ) {
            return;
        }
        visited.add(tuple);
        if (board[i][j] == 'X') {
            x.add(tuple);
            return;
        } else {
            captureToX.add(tuple);
        }
        dfs(i + 1, j, board, x, captureToX, visited);
        dfs(i - 1, j, board, x, captureToX, visited);
        dfs(i, j + 1, board, x, captureToX, visited);
        dfs(i, j - 1, board, x, captureToX, visited);
    }

    private static class Tuple {
        int i;
        int j;

        public Tuple(int i, int j) {
            this.i = i;
            this.j = j;
        }

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
