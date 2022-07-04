package com.leetcode.valid_anagram;

public class Solution {

    public static void main(String[] args) {
        // "anagram" "nagaram": true
        System.out.println(isAnagram("anagram", "nagaram"));
        // "aacc" "ccac": false
        System.out.println(isAnagram("aacc", "ccac"));
    }

    // TODO: or can be used order by alphabet
    public static boolean isAnagram(String s, String t) {
        int sLength = s.length();
        int tLength = t.length();

        String replace = t;
        if (sLength == tLength) {
            for(char symb : s.toCharArray()) {
                replace = replace.replaceFirst(symb + "", "");
            }
            return replace.length() == 0;
        }
        return false;
    }

}
