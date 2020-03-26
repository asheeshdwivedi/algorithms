package com.algorithms.dp;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class KnapsackTest {

    private final Knapsack knapsack = new Knapsack();

    @Test
    void knapsackRecursive() {
        int maxProfit = knapsack.knapsackRecursive(new int[]{3, 7, 10, 6},
                new int[]{4, 14, 10, 5},
                20,
                3);

        System.out.println(maxProfit);
    }

    @Test
    void knapsackTopDown() {
        int[][] cache = new int[21][4];
        for (int[] array : cache) {
            Arrays.fill(array, -1);
        }
        int maxProfit = knapsack.knapsackTopDown(new int[]{3, 7, 10, 6},
                new int[]{4, 14, 10, 5},
                20,
                3, cache);

        System.out.println(maxProfit);
    }

    @Test
    void testKnapsackBottomUp() {
        int maxProfit = knapsack.knapsackBottomUp(new int[]{3, 7, 10, 6},
                new int[]{4, 14, 10, 5},
                20);

        System.out.println(maxProfit);
    }

    @Test
    void testKnapsackBottomUpReconstructTheSolution() {
        int maxProfit = knapsack.knapsackBottomUpReconstructTheSolution(new int[]{3, 7, 10, 6},
                new int[]{4, 14, 10, 5},
                20);

        System.out.println(maxProfit);
    }
}