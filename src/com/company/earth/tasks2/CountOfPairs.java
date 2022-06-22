package com.company.earth.tasks2;

public class CountOfPairs {

    public static void main(String[] args) {
        int[] number = new int[] {1, 5, 3, 4, 2};
        int target = 3;

        System.out.println(getPairs(number, target));
    }

    public static int getPairs(int[] number, int target) {
        int count = 0;
        for (int i = 0; i < number.length; i++) {
            for(int j = i + 1; j < number.length; j++) {
                int res = Math.abs(number[i] - number[j]);
                if (res == target) {
                    count ++;
                }
            }
        }
        return count;
    }

}
