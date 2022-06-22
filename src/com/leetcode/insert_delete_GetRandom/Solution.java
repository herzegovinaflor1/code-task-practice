package com.leetcode.insert_delete_GetRandom;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class Solution {

    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();
        randomizedSet.insert(1);
        randomizedSet.remove(1);
        int random = randomizedSet.getRandom();
    }

    static class RandomizedSet {

        private Set<Integer> values = new HashSet<>();

        public RandomizedSet() {

        }

        public boolean insert(int val) {
            return values.add(val);
        }

        public boolean remove(int val) {
            return values.remove(val);
        }

        public int getRandom() {
            int i = ThreadLocalRandom.current().nextInt(0, values.size());
            Integer[] integers = values.toArray(new Integer[]{});
            return integers[i];
        }
    }

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */

}
