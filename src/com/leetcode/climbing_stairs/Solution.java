package com.leetcode.climbing_stairs;

public class Solution {

    public static void main(String[] args) {
        // int i = climbStairs(44); // 1134903170
        int i = climbStairs(44);
        System.out.println(i);
    }

    public static int climbStairs(int n) {
        int res = 1;
        int a = 1;
        int b = 0;

        for (int i = n; i >= 0; i--) {
            int sum = a + b;
            a = b;
            b = sum;
            res = b;
        }

        return res;
        //return climbStairs(0, n);
    }

    public static int climbStairs(int val, int n) {
        if (val == n) {
            return 1;
        }
        if (val > n) {
            return 0;
        }
        return climbStairs(val + 1, n) + climbStairs(val + 2, n);
    }

}
