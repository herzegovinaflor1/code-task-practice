package com.leetcode.letter_combinations_of_a_phone_number;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Solution {

    // https://leetcode.com/problems/letter-combinations-of-a-phone-number/
    public static void main(String[] args) {
        System.out.println(
                new Solution().letterCombinations(
                        "23"
                )
        );
    }

    private static final HashMap<Character, char[]> DIGITS =
            new HashMap<Character, char[]>() {{
                put('2', new char[] {'a', 'b', 'c'});
                put('3', new char[]{'d', 'e', 'f'});
                put('4', new char[]{'g', 'h', 'i'});
                put('5', new char[]{'j', 'k', 'l'});
                put('6', new char[]{'m', 'n', 'o'});
                put('7', new char[]{'p', 'q', 'r', 's'});
                put('8', new char[]{'t', 'u', 'v'});
                put('9', new char[]{'w', 'x', 'y', 'z'});
            }};

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return Collections.emptyList();
        }

        List<String> result = new ArrayList<>();

        char[] digitChars = digits.toCharArray();
        backTrack(
                digitChars,
                0,
                0,
                new StringBuilder(),
                result
        );

        return result;
    }

    private void backTrack(
            char[] digits,
            int indexForDigit,

            int indexForSymbol,
            StringBuilder combination,
            List<String> results
    ) {
        if (combination.length() == digits.length) {
            results.add(combination.toString());
            return;
        }
        char[] symbols = DIGITS.get(digits[indexForDigit]);
        combination.append(symbols[indexForSymbol]);

        backTrack(
                digits,
                indexForDigit + 1,
                0,
                combination,
                results
        );

        combination.deleteCharAt(combination.length() - 1);

        if (symbols.length > indexForSymbol + 1) {
            backTrack(
                    digits,
                    indexForDigit,
                    indexForSymbol + 1,
                    combination,
                    results
            );
        }
    }

}
