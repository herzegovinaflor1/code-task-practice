package com.leetcode.Kth_Larget_Element_in_an_Array;

import java.util.Collections;
import java.util.PriorityQueue;

public class Solution {

    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[] {3,2,1,5,6,4}, 2));
    }

    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> digits = new PriorityQueue<>();
        for (int i : nums) {
            digits.add(i);
            if (digits.size() > k) {
                digits.poll();
            }
        }

        return digits.peek();
    }

}
