package com.algorithms.dp;

import java.util.Arrays;

/*
     There are a row of houses, each house can be painted with one of the three colors:
     Red,Blue, Green The cost of painting each house with a certain color is different.
     You have to paint all the houses such that no two adjacent houses have the same color.
     What is the minimum cost?

     Input is a 2d NX3 array with n houses and 3 color

     Input : cost[][] = [
        [17,2,17]
        [16,16,5]
        [14,3,9]
     ]
     cost[1..1] = represent number of houses for 1 to i
     cost[i][1..3] = represent cost to color the ith house

     Let's say

     i is index of the house
     c- color of the paint, It can be Red, Blue, Green. We use 0 , 1 , 2
     to denote it

    Cost Function

      min_cost(i,c) returns the minimum cost of the painting the
       house i with paint c

   Transition :
       We start at house index at 0.
       Option 0
         1. We can paint house 0 with RED, BLUE , GREEN
       if we choose Red for house 0 , then house number 1 can be either painted with GREEN, BLUE,

                                        min_cost(0 , RED)

                          min_cost(1, BLUE)                 min_cost(1, GREEN)

        Optimal Choice will be : min(min_cost(1, BLUE),min_cost(1, GREEN))

     Recurrence Relation :
        min_cost(i , RED) = cost[i][RED] + MIN(min_cost(i+1 , BLUE) , min_cost(i+1 , GREEN))
        min_cost(i , BLUE) = cost[i][BLUE] + MIN(min_cost(i+1 , RED) , min_cost(i+1 , GREEN))
        min_cost(i , GREEN) = cost[i][GREEN] + MIN(min_cost(i+1 , BLUE) , min_cost(i+1 , RED))
     Base Case :
       i == n  , where n is number of houses, we return 0. We have reached the end of array
 */
public class PaintHouse {

    private final int RED = 0;
    private final int BLUE = 1;
    private final int GREEN = 2;

    public int minCostRecursive(int[][] cost) {
        int costRed = minCostRecursive(cost, 0, RED);
        int costBlue = minCostRecursive(cost, 0, BLUE);
        int costGreen = minCostRecursive(cost, 0, GREEN);
        return Integer.min(costRed, Integer.min(costBlue, costGreen));
    }

    private int minCostRecursive(int[][] cost, int houseIndex, int colorIndex) {
        if (houseIndex == cost.length) {
            return 0;
        }
        switch (colorIndex) {
            case RED: {
                int costBlue = minCostRecursive(cost, houseIndex + 1, BLUE);
                int costGreen = minCostRecursive(cost, houseIndex + 1, GREEN);
                return cost[houseIndex][RED] + Integer.min(costBlue, costGreen);
            }
            case BLUE: {
                int costRed = minCostRecursive(cost, houseIndex + 1, RED);
                int costGreen = minCostRecursive(cost, houseIndex + 1, GREEN);
                return cost[houseIndex][BLUE] + Integer.min(costRed, costGreen);
            }
            case GREEN: {
                int costRed = minCostRecursive(cost, houseIndex + 1, RED);
                int costBlue = minCostRecursive(cost, houseIndex + 1, BLUE);
                return cost[houseIndex][GREEN] + Integer.min(costBlue, costRed);
            }
        }
        return 0;
    }

    public int minCostTopDown(int[][] cost) {
        int[][] cache = new int[cost.length][3];
        for (int[] row : cache) {
            Arrays.fill(row, -1);
        }
        int costRed = minCostTopDown(cost, 0, RED, cache);
        int costBlue = minCostTopDown(cost, 0, BLUE, cache);
        int costGreen = minCostTopDown(cost, 0, GREEN, cache);
        return Integer.min(costRed, Integer.min(costBlue, costGreen));
    }

    private int minCostTopDown(int[][] cost, int houseIndex, int colorIndex, int[][] cache) {
        if (houseIndex == cost.length) {
            return 0;
        }
        if (cache[houseIndex][colorIndex] != -1) {
            return cache[houseIndex][colorIndex];
        }
        switch (colorIndex) {
            case RED: {
                int costBlue = minCostTopDown(cost, houseIndex + 1, BLUE, cache);
                int costGreen = minCostTopDown(cost, houseIndex + 1, GREEN, cache);
                return cache[houseIndex][colorIndex] = cost[houseIndex][RED] + Integer.min(costBlue, costGreen);
            }
            case BLUE: {
                int costRed = minCostTopDown(cost, houseIndex + 1, RED, cache);
                int costGreen = minCostTopDown(cost, houseIndex + 1, GREEN, cache);
                return cache[houseIndex][colorIndex] = cost[houseIndex][BLUE] + Integer.min(costRed, costGreen);
            }
            case GREEN: {
                int costRed = minCostTopDown(cost, houseIndex + 1, RED, cache);
                int costBlue = minCostTopDown(cost, houseIndex + 1, BLUE, cache);
                return cache[houseIndex][colorIndex] = cost[houseIndex][GREEN] + Integer.min(costBlue, costRed);
            }
        }
        return 0;
    }
}
