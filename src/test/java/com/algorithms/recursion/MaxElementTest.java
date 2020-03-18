package com.algorithms.recursion;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxElementTest {

    private final MaxElement maxElement = new MaxElement();

    @Test
    public void test() {
        int max = this.maxElement.max(new int[]{4, 3, 6, 7, 0, 9, 2});
        System.out.println(max);
        Assertions.assertEquals(max , 9);
    }
}
