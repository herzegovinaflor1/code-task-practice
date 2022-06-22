package com.leetcode.min_stack;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Explanation
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin()); // return -3
        minStack.pop();
        minStack.top();    // return 0
        System.out.println(minStack.getMin()); // return -2
    }

    /**
     * Your MinStack object will be instantiated and called as such:
     * MinStack obj = new MinStack();
     * obj.push(val);
     * obj.pop();
     * int param_3 = obj.top();
     * int param_4 = obj.getMin();
     */
    static class MinStack {

        private int min;
        private final List<Integer> elements;

        public MinStack() {
            min = Integer.MAX_VALUE;
            elements = new ArrayList<>();
        }

        public void push(int val) {
            if (val < min) {
                min = val;
            }
            elements.add(val);
        }

        public void pop() {
            int lastElement = elements.size() - 1;
            Integer remove = elements.remove(lastElement);
            if (remove == min) {
                recalculateMin();
            }
        }

        public int top() {
            int lastElement = elements.size() - 1;
            return elements.get(lastElement);
        }

        public int getMin() {
            return min;
        }

        private void recalculateMin() {
            int min = Integer.MAX_VALUE;
            for(Integer elem: elements) {
                if (elem < min) {
                    min = elem;
                }
            }
            this.min = min;
        }

    }

}
