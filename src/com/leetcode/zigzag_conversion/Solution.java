package com.leetcode.zigzag_conversion;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    // https://leetcode.com/problems/zigzag-conversion/description/
    public static void main(String[] args) {
        System.out.println(
                new Solution().convert("PAYPALISHIRING", 4)
        );

        // PAYPALISHIRING
    }

    public String convert(String s, int numRows) {
        StringBuilder sb = new StringBuilder();

        List<List<Character>> result = new ArrayList<>();
        for (int i = 0; i < numRows; ++i) {
            result.add(new ArrayList<>());
        }

        int counter = 0;
        char[] chars = s.toCharArray();
        int i = 0;
        boolean goBottom = true;

        while (counter < chars.length) {
            result.get(i).add(chars[counter]);

            if (goBottom) {
                i++;
            }
            if (!goBottom) {
                i--;
            }

            if (i == numRows) {
                goBottom = false;
                i = i - 2;
            }
            if (i == 0) {
                goBottom = true;
            }

            counter++;
        }

        result.forEach( row -> row.forEach(sb::append));

        return sb.toString();
    }

    public String convert2(String s, int numRows) {
        if (s.length() <= numRows || numRows == 1) {
            return s;
        }
        char[] finalWord = new char[s.length()];

        char[] words = s.toCharArray();
        int mainIndexesCount = words.length / numRows;
        int[] mainIndexes = new int[mainIndexesCount];

        int indexInterval = numRows + numRows / 2;
        mainIndexes[0] = 0;
        finalWord[0] = words[0];
        int indexStart = 0;
        for (int i = 1; i < mainIndexesCount; ++i) {
            mainIndexes[i] = mainIndexes[i - 1] + indexInterval;
            finalWord[i] = words[mainIndexes[i]];
            indexStart++;
        }

        int finalWordIdx = indexStart;
        boolean finished = false;
        for (int i = 1; i < mainIndexes.length; i++) {
            for (int j = 0; j < mainIndexes.length; j++) {
                int windowStart = mainIndexes[j] + i;
                if (windowStart == s.length()) {
                    finished = true;
                    break;
                }
                finalWord[++finalWordIdx] = words[windowStart];

                if (j + 1 < mainIndexes.length && j + 1 < words.length) {
                    int windowEnd = mainIndexes[j + 1] - i;
                    if (windowStart != windowEnd) {
                        finalWord[++finalWordIdx] = words[windowEnd];
                    }
                }
            }
            if (finished) {
                break;
            }
        }

        int distance = mainIndexes.length > 1 ? mainIndexes[1] - mainIndexes[0] + 1 : 1;
        boolean isOdd = distance % 2 == 1;
        if (isOdd) {
            for (int i = 0; i < mainIndexes.length - 1; ++i) {
                finalWord[finalWord.length - mainIndexes.length + 1  + i] = words[mainIndexes[i] + (distance / 2)];
            }

        }

        return new String(finalWord);
    }

}
