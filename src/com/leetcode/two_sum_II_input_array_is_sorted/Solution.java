package com.leetcode.two_sum_II_input_array_is_sorted;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        int[] ints = twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println(Arrays.toString(ints)); // [1,2]

        int[] ints2 = twoSum(new int[]{-1, 0}, -1);
        System.out.println(Arrays.toString(ints2)); // [1,2]

        int[] ints3 = twoSum(new int[]{-3, 3, 4, 90}, 0);
        System.out.println(Arrays.toString(ints3)); // [1,2]
    }
     public static int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;

        int num1, num2;

        while (i < j) {
            num1 = numbers[i];
            num2 = numbers[j];

            if (num1 + num2 == target) {
                break;
            }

            if (num1 + num2 > target) {
                j--;
                continue;
            }
            i++;
        }

        return new int[]{i + 1, j + 1};
    }

    public static int[] twoSum2(int[] numbers, int target) {
        Map<Number, Integer> numberToIndex = new HashMap<>();

        int[] idx = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            int number = numbers[i];
            int searchableNumber = target - number;
            if (numberToIndex.containsKey(searchableNumber)) {
                idx[0] = numberToIndex.get(searchableNumber) + 1;
                idx[1] = i + 1;
                break;
            } else {
                numberToIndex.put(number, i);
            }
        }

        return idx;
    }

}
