package com.leetcode.longest_substring_without_repeating_characters;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring2("abcabcbb")); // 3
        System.out.println(lengthOfLongestSubstring("bbbbb")); // 1
        System.out.println(lengthOfLongestSubstring(" ")); // 1
        System.out.println(lengthOfLongestSubstring("au")); // 2
        System.out.println(lengthOfLongestSubstring("dvdf")); // 3
        System.out.println(lengthOfLongestSubstring("pwwkew")); // 3
        System.out.println(lengthOfLongestSubstring("")); // 0
        System.out.println(lengthOfLongestSubstring("abcb")); // 3
        System.out.println(lengthOfLongestSubstring("ohvhjdml")); // 6
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) {
            return s.length();
        }
        int count = 0;
        Map<Character, Character> symbolToSymbol = new HashMap<>();
        int i = 0;
        int j = 1;
        char c = s.charAt(i);
        symbolToSymbol.put(c, c);
        while (j < s.length()) {
            char symbolEnd = s.charAt(j);

            if (symbolToSymbol.containsKey(symbolEnd)) {
                i++;
                j = i + 1;
                symbolToSymbol.clear();
                symbolToSymbol.put(s.charAt(i), s.charAt(i));
            } else {
                symbolToSymbol.put(symbolEnd, symbolEnd);
                j++;
            }
            count = Math.max(count, symbolToSymbol.size());
        }

        return count;
    }

    // TODO analyse
    public static int lengthOfLongestSubstring2(String s) {
        Map<Character, Integer> hashMap = new HashMap<>();

        int size = 0;
        int maxSize = 0;
        for (int i = 0; i < s.length(); i++) {
            if (hashMap.containsKey(s.charAt(i))) {
                if (size < i - hashMap.get(s.charAt(i))) {
                    size++;
                } else {
                    size = i - hashMap.get(s.charAt(i));
                }
                hashMap.put(s.charAt(i), i);
            } else {
                hashMap.put(s.charAt(i), i);
                size++;
            }
            if (size > maxSize) {
                maxSize = size;
            }
        }

        return maxSize;
    }

}
