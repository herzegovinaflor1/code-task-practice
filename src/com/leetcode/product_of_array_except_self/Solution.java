package com.leetcode.product_of_array_except_self;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        // System.out.println(Arrays.toString(productExceptSelf(new int[]{1, 2, 3})));
        System.out.println(Arrays.toString(productExceptSelf(new int[]{-1,1,0,-3,3})));
    }

    public static int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];

        int[] prefix = new int[nums.length];
        int[] postfix = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            prefix[i] = getPreviousElementFromArray(i - 1, prefix) * getPreviousElementFromArray(i, nums);
            postfix[nums.length - 1 - i] = getPreviousElementFromArray(nums.length - i, postfix) * getPreviousElementFromArray(nums.length - 1 - i, nums);
        }

        for (int i = 0; i < nums.length; i++) {
            res[i] = getPreviousElementFromArray(i - 1, prefix) * getPreviousElementFromArray(i + 1, postfix);
        }

        return res;
    }

    private static int getPreviousElementFromArray(int i, int[] arr) {
        if (i < 0 || i == arr.length) {
            return 1;
        }
        return arr[i];
    }

}
