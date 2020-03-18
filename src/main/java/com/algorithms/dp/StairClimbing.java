package com.algorithms.dp;

/*
 Problem Statement : You can climb 1 or 2 stairs with one step. How many different ways can you
 climb n stairs

  Lets assume we have 3 stairs
   - we can climb either 1 stair at a time so 3 times 1 stair
   - we can climb 2 stair and then 1 stair
   - we can climb 1 stair and then 2 stair.
 so total 3 ways to climb 3 stairs

Navie Solution
   Let f(n) be the number of different ways to climb n stairs
   How we can reach to the nth stair?
   1. Be at the (n-2)th stair, then climb 2 steps.
   2. Be at the (n-1) th stair then climb 1 steps.
   for (1), number of ways to reach (n-2)th stair is f(n-2)
   for(2), number of ways to reach (n-1)th stair is f(n-1)

 f(n) = f(n-2) + f(n-1). use recursion! (Base case is f(1) = 1 and f(2) = 2
 */

public class StairClimbing {

    public int recursion(int numberOfStairs) {
        if (numberOfStairs == 1)
            return 1;
        else if (numberOfStairs == 2)
            return 2;
        else
            return recursion(numberOfStairs - 2)
                    + recursion(numberOfStairs - 1);
    }

    public int withOutRecursion(int numberOfStairs) {
        int[] result = new int[numberOfStairs+1];
        result[1] = 1;
        result[2] = 2;
        for (int i = 3; i <= numberOfStairs; i++) {
            result[i] = result[i - 2] + result[i - 1];
        }
        return result[numberOfStairs];
    }

}
