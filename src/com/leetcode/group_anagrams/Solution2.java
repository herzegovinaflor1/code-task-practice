package com.leetcode.group_anagrams;

import java.util.*;

public class Solution2 {

    public static void main(String[] args) {
//        System.out.println(
//                new Main5().groupAnagrams(
//                        new String[] {
//                                "cab","tin","pew","duh","may","ill","buy","bar","max","doc"
//                        }
//                )
//        );
        System.out.println(
                new Solution2().groupAnagrams(
                        new String[] {
                                "eat","tea","tan","ate","nat","bat"
//                                "eat","tea","tan","ate","nat","bat","ac","bd","aac","bbd","aacc","bbdd","acc","bdd"
                        }
                )
        );
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Integer, List<String>> result = new HashMap<>();

        for (String str : strs) {
            int hash = hash(str);

            result.computeIfPresent(hash, (k, v) -> {
                v.add(str);
                return v;
            });

            result.computeIfAbsent(hash, k -> {
                List<String> anagram =  new ArrayList<>();
                anagram.add(str);
                return anagram;
            });
        }

        return new ArrayList<>(result.values());
    }

    public int hash(String str) {
        int[] freq = new int[26];

        for (char ch : str.toCharArray()) {
            freq[ch - 'a']++;
            /**
             *
             * t - a, ea
             * eat
             * ate
             *
             * [1,0,0,1,0,1,0,0...]
             * [1,0,0,1,0,1,0,0...]
             * [1,0,0,1,0,1,0,0...]
             *
             */
        }

        return Arrays.hashCode(freq);
    }

}
