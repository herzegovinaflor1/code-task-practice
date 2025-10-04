package com.leetcode.generate_parentheses;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    // https://leetcode.com/problems/generate-parentheses/description/
    public static void main(String[] args) {
        System.out.println(
                new Solution().generateParenthesis(3)
        );
    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generate(
                0,
                0,
                n,
                new StringBuilder(),
                result
        );

        return result;
    }

    private void generate(
        int openBraceCount,
        int closeBraceCount,
        int limit,

        StringBuilder structure,
        List<String> result
    ) {
        if (openBraceCount < closeBraceCount) {
            return;
        }
        if (openBraceCount == limit && openBraceCount == closeBraceCount) {
            result.add(structure.toString());
            return;
        }

        if (openBraceCount < limit) {
            structure.append("(");
            generate(
                    openBraceCount + 1,
                    closeBraceCount,
                    limit,
                    structure,
                    result
            );
            structure.deleteCharAt(structure.length() - 1);
        }

        if (closeBraceCount < limit) {
            structure.append(")");
            generate(
                    openBraceCount,
                    closeBraceCount + 1,
                    limit,
                    structure,
                    result
            );
            structure.deleteCharAt(structure.length() - 1);
        }

    }

}
