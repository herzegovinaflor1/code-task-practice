package com.leetcode.longest_palindromic_substring;

public class BetterSolution {

    public static void main(String[] args) {
        longestPalindrome("caaac");
    }

    public static String longestPalindrome(String s) {
        if (s == null || "".equals(s)) {
            return s;
        }

        int len = s.length();

        String ans = "";
        int max = 0;

        boolean[][] dp = new boolean[len][len];

        for (int j = 0; j < len; j++) {
            for (int i = 0; i <= j; i++) {
                char start = s.charAt(i);
                char finish = s.charAt(j);
                boolean judge = start == finish;
                dp[i][j] = j - i > 2 ? dp[i + 1][j - 1] && judge : judge;
                if (dp[i][j] && j - i + 1 > max) {
                    max = j - i + 1;
                    ans = s.substring(i, j + 1);
                    System.out.println();
                }
            }
        }
        return ans;
    }

}
