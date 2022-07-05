package com.leetcode.group_anagrams;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        List<List<String>> lists = groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        System.out.println(lists);
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> keyToAnagram = new HashMap<>();
        for (String str : strs) {
            String orderedWord = getOrderedWord(str);
            if (keyToAnagram.containsKey(orderedWord)) {
                List<String> strings = keyToAnagram.get(orderedWord);
                strings.add(str);
            } else {
                List<String> anagramGroup = new ArrayList<>();
                anagramGroup.add(str);
                keyToAnagram.put(orderedWord, anagramGroup);
            }
        }
        return new ArrayList<>(keyToAnagram.values());
    }

    // TODO: instead of sort, can be used count of each symbol in str as a key for has map
    public static String getOrderedWord(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return String.valueOf(chars);
    }


}
