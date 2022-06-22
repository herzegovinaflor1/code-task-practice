package com.company.earth.tasks1;

public class NumberOfBinaryMatrixPaths {

    public static void main(String[] args) {
        System.out.println(numberOfPaths(new int[][]{
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1}
        }));
    }

    public static int numberOfPaths(int[][] matrix) {
        int x = matrix.length - 1;
        int y = matrix[x - 1].length - 1;
        return countNumberOfWays(matrix, x, y);
    }

    public static int countNumberOfWays(int[][] matrix, int x, int y) {
        if (x < 0 || y < 0) {
            return 0;
        }

        if (matrix[x][y] == 0) {
            return 0;
        }

        if (x == 0 && y == 0) {
            return 1;
        }

        return countNumberOfWays(matrix, x - 1, y) + countNumberOfWays(matrix, x, y - 1);
    }

}
