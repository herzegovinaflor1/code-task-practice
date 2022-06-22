package com.leetcode.Kth_largest_element_in_a_stream;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
//        KthLargest kthLargest = new KthLargest(3, new int[] {4, 5, 8, 2});
//        System.out.println(kthLargest.add(3));   // return 4
//        System.out.println(kthLargest.add(5));   // return 5
//        System.out.println(kthLargest.add(10));  // return 5
//        System.out.println(kthLargest.add(9));   // return 8
//        System.out.println(kthLargest.add(4));   // return 8

//        KthLargest kthLargest2 = new KthLargest(1, new int[]{});
//        System.out.println(kthLargest2.add(-3));
//        System.out.println(kthLargest2.add(-2));
//        System.out.println(kthLargest2.add(-4));
//        System.out.println(kthLargest2.add(0));
//        System.out.println(kthLargest2.add(4));
//
//        KthLargest kthLargest3 = new KthLargest(1, new int[] {-2});
//        System.out.println(kthLargest3.add(-3));   // return 4
//        System.out.println(kthLargest3.add(0));   // return 5
//        System.out.println(kthLargest3.add(2));  // return 5
//        System.out.println(kthLargest3.add(-1));   // return 8
//        System.out.println(kthLargest3.add(4));   // return 8

        KthLargest kthLargest3 = new KthLargest(3, new int[] {5, -1});
        System.out.println(kthLargest3.add(2));   // return 4
        System.out.println(kthLargest3.add(1));   // return 5
        System.out.println(kthLargest3.add(-1));  // return 5
        System.out.println(kthLargest3.add(3));   // return 8
        System.out.println(kthLargest3.add(4));   // return 8
    }

    static class KthLargest {

        private final int[] maxValues;
        private int index;

        public KthLargest(int k, int[] nums) {
            Arrays.sort(nums);
            maxValues = new int[k];
            index = k <= nums.length ? nums.length : k - 1;
            Arrays.fill(maxValues, Integer.MIN_VALUE);
            int min = Math.min(k, nums.length);
            for (int i = 0; i < min; i++) {
                maxValues[i] = nums[nums.length - i - 1];
            }
            Arrays.sort(maxValues);
        }

        public int add(int val) {
            if (index < maxValues.length -1) {
                maxValues[index] = val;
                Arrays.sort(maxValues);
                int res = maxValues[index];
                index++;
                return res;
            } else {
                int firstThreshold = maxValues[0];
                if (val > firstThreshold) {
                    maxValues[0] = val;
                    Arrays.sort(maxValues);
                    return maxValues[0];
                }
                return firstThreshold;
            }
        }
    }

}
