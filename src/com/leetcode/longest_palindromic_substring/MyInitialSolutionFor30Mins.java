package com.leetcode.longest_palindromic_substring;

/**
 * My initial solution
 */
public class MyInitialSolutionFor30Mins {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("a"));
        System.out.println(longestPalindrome("ac"));
        System.out.println(longestPalindrome("1111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111"));
    }

    public static String longestPalindrome(String s) {
        String longestPalindrome = "";
        if (s.length() == 1) {
            return s;
        }
        if (!areAllCharactersTheSame(s)) {
            for (int i = 0; i < s.length(); i++) {
                for (int j = s.length() - 1; j > i; j--) {
                    char firstSymbol = s.charAt(i);
                    char lastSymbol = s.charAt(j);
                    if (firstSymbol == lastSymbol) {
                        String substring = s.substring(i, j + 1);
                        if (isPalindrome(substring) && substring.length() > longestPalindrome.length()) {
                            longestPalindrome = substring;
                            break;
                        }
                    }
                }
            }
            if (longestPalindrome.length() == 0) {
                return s.substring(0, 1);
            }
            return longestPalindrome;
        }
        return s;
    }

    public static boolean isPalindrome(String string) {
        int dividedString = string.length() / 2;
        for (int i = 0; i < dividedString; i++) {
            char firstSymbol = string.charAt(i);
            char lastSymbol = string.charAt(string.length() - 1 - i);
            if (firstSymbol != lastSymbol) {
                return false;
            }
        }
        return true;
    }

    public static boolean areAllCharactersTheSame(String string) {
        char firstChar = string.charAt(0);
        for (int i = 1; i < string.length(); i++) {
            if (string.charAt(i) != firstChar) {
                return false;
            }
        }
        return true;
    }

}
