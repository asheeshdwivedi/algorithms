package com.algorithms.dynamic.programming;

public class BuyAndSellStock {

    public int maxProfitRecursive(int i, int[] price) {
        if (i == 0) {
            return 0;
        }
        int maxValue = maxProfitRecursive(i - 1, price);
        for (int j = 1; j < i; j++) {
            maxValue = Integer.max(maxValue, price[i - 1] - price[j - 1]);
        }
        return maxValue;
    }

    public int maxProfitDp(int i, int[] price) {
        int[] profits = new int[i];
        profits[0] = 0;
        int MIN_VALUE = price[0];
        for (int j = 1; j < i; j++) {
            MIN_VALUE = Integer.min(MIN_VALUE, price[j]);
            profits[j] = Integer.max(profits[j - 1], price[j] - MIN_VALUE);
        }
        return profits[i - 1];
    }
}
