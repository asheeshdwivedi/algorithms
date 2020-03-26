package com.algorithms.dp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PaintHouseTest {

    private PaintHouse paintHouse = new PaintHouse();

    @Test
    public void testMinCostRecursive() {
        int[][] cost = {{17, 2, 17}, {16, 16, 5}, {14, 3, 9},};
        int minCost = this.paintHouse.minCostRecursive(cost);
        System.out.println(minCost);
        Assertions.assertEquals(10, minCost);
    }

    @Test
    public void testMinCostTopDown() {
        int[][] cost = {{17, 2, 17}, {16, 16, 5}, {14, 3, 9},};
        int minCost = this.paintHouse.minCostTopDown(cost);
        System.out.println(minCost);
        Assertions.assertEquals(10, minCost);
    }

}