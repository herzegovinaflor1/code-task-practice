package com.leetcode.longest_repeating_character_replacement;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        System.out.println(characterReplacement("ABAB", 2)); // 4
        System.out.println(characterReplacement("AABABBA", 1)); // 4
        System.out.println(characterReplacement("ABCDE", 1)); // 2
        System.out.println(characterReplacement("BAAAB", 2)); // 5
        System.out.println(characterReplacement("ABAA", 0)); // 2
    }

    public static int characterReplacement(String s, int k) {
        int res = 0;
        int[] sybToCount = new int[26];

        int j = 0;
        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            sybToCount[c - 'A']++;

            int window = i - j + 1;
            int maxCountSum = Arrays.stream(sybToCount)
                    .max()
                    .getAsInt();
            int diff = window - maxCountSum;
            if (diff <= k) {
                res = Math.max(window, res);
                i++;
            } else {
                char c2 = s.charAt(j);
                j++;
                sybToCount[c2 - 'A']--;
                sybToCount[c - 'A']--;
            }
        }

        return res;
    }


}
