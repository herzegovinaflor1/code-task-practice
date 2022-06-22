package com.leetcode.valid_parentheses;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        System.out.println(isValid("()")); // true
        System.out.println(isValid("()[]{}")); // true
        System.out.println(isValid("(]")); // false
        System.out.println(isValid("([)]")); // false
        System.out.println(isValid("]")); // false
    }

    public static boolean isValid(String s) {
        if (s.isEmpty()) {
            return true;
        }
        Deque<Character> stack = new ArrayDeque<>();
        String addOpp = "[{(";
        Map<Character, Character> openToClose = new HashMap<>(){{
           put('{', '}');
           put('(', ')');
           put('[', ']');
        }};

        for (char op : s.toCharArray()) {
            if (addOpp.indexOf(op) >= 0) {
                stack.add(op);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char poll = stack.pollLast();
                Character character = openToClose.get(poll);
                if (character != op) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

}
