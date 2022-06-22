package com.leetcode.Longest_Palindromic_Substring_dynamic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
//        System.out.println(longestPalindrome("babad"));
//        System.out.println(longestPalindrome("cbbd"));
//        System.out.println(longestPalindrome("ac"));
//        System.out.println(longestPalindrome("ccc"));
//        System.out.println(longestPalindrome("caba"));
//        System.out.println(longestPalindrome("aaaa"));
        System.out.println(longestPalindrome("abcbe"));
    }

    public static String longestPalindrome(String s) {
        if (s.length() == 1) {
            return s;
        }
        HashMap<Integer, Integer> nodes = new HashMap<>();

        List<String> res = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            longest(i, s, i, nodes, s.charAt(i) + "", res);
        }

        return res.isEmpty() ? s.charAt(0) + "" : res.get(res.size() - 1);
    }

    public static void longest(
            int constIdx,
            String text, int idx,
            HashMap<Integer, Integer> idexToPolindromeIndex, String word, List<String> res) {
        if (isPalindrome(word) && (res.isEmpty() || word.length() > res.get(res.size() - 1).length())) {
            res.add(word);
            //return;
        }
        if (idx > text.length()) {
            return;
        }
        int index = idx;
        if (idexToPolindromeIndex.containsKey(idx)) {
            index = idexToPolindromeIndex.get(idx) + 1;
            idexToPolindromeIndex.put(idexToPolindromeIndex.get(idx), index);
        } else {
            index++;
        }
        word = text.substring(constIdx, Math.min(index, text.length()));
        idexToPolindromeIndex.put(idx, index);
        longest(constIdx, text, index, idexToPolindromeIndex, word, res);
    }

    public static boolean isPalindrome(String word) {
        if (word.length() == 1) {
            return false;
        }
        int limit = word.length() / 2;
        for (int i = 0; i <= limit; i++) {
            if (word.charAt(i) != word.charAt(word.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

}
