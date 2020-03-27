package com.algorithms.dp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class CuttingRodsTest {

    private final CuttingRods cuttingRods = new CuttingRods();

    @Test
    public void testRecursiveRevenue() {
        int revenue = cuttingRods.recursiveRevenue(5, new int[]{1, 5, 8, 9, 10});
        System.out.println(revenue);
        Assertions.assertEquals(revenue, 13);
    }

    @Test
    public void testCutRodTopDown() {
        int[] cache = new int[6];
        Arrays.fill(cache, -1);
        int revenue = cuttingRods.cutRodTopDown(5, new int[]{1, 5, 8, 9, 10}, cache);
        System.out.println(revenue);
        Assertions.assertEquals(revenue, 13);
    }

    @Test
    public void testDpRevenue() {
        int revenue = cuttingRods.dpRevenue(5, new int[]{1, 5, 8, 9, 10});
        System.out.println(revenue);
        Assertions.assertEquals(revenue, 13);
    }


}