package com.algorithms.dp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StairClimbingTest {

    private final StairClimbing stairClimbing = new StairClimbing();

    @Test
    public void testRecursion(){
        int result = stairClimbing.recursion(10);
        System.out.println(result);
        Assertions.assertEquals(result , 89);
    }

    @Test
    public void testWithOutRecursion(){
        int result = stairClimbing.withOutRecursion(10);
        System.out.println(result);
        Assertions.assertEquals(result , 89);
    }
}