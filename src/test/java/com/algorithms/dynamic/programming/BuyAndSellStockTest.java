package com.algorithms.dynamic.programming;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BuyAndSellStockTest {

    private final BuyAndSellStock buyAndSellStock = new BuyAndSellStock();

    @Test
    void maxProfitRecursive() {
        int maxProfit = this.buyAndSellStock.maxProfitRecursive(6, new int[]{7, 1, 5, 3, 6, 4});
        System.out.println(maxProfit);
        Assertions.assertEquals(maxProfit, 5);

    }

    @Test
    void maxProfitDp() {
        int maxProfit = this.buyAndSellStock.maxProfitDp(6, new int[]{7, 1, 5, 3, 6, 4});
        System.out.println(maxProfit);
        Assertions.assertEquals(maxProfit, 5);
    }

}