package com.leetcode.best_time_to_buy_and_sell_stock;

public class Solution {

    // TODO: incompleted
    public static void main(String[] args) {
        int i = maxProfit(new int[]{7, 1, 5, 3, 6, 4});
        System.out.println(i); // 5

        int i2 = maxProfit(new int[]{2, 4, 1});
        System.out.println(i2); // 2

        int i3 = maxProfit(new int[]{2, 1, 2, 1, 0, 1, 2});
        System.out.println(i3); // 2

        int i4 = maxProfit(new int[]{1, 2, 4, 2, 5, 7, 2, 4, 9, 0, 9});
        System.out.println(i4); // 9
    }

    public static int maxProfit(int[] prices) {
        int i = 0;
        int j = 1;

        int maxProfit = Integer.MIN_VALUE;

        while (j < prices.length) {
            int priceBuy = prices[i];
            int priceSell = prices[j];

            int res = priceSell - priceBuy;

            if (res < 0 || res == 0) {
                i = j;
                j++;
                continue;
            }

            if (res > maxProfit) {
                maxProfit = res;
            }
            j++;
        }

        return maxProfit;
    }

    public static int maxProfit2(int[] prices) {
        int min = Integer.MAX_VALUE;
        int ans = Integer.MIN_VALUE;
        for (int val : prices) {
            min = Math.min(min, val);
            ans = Math.max(ans, val - min);
        }
        return ans;
    }

}
