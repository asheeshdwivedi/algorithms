package com.algorithms.recursion;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SumOfDigitTest {

    private final SumOfDigit sumOfDigit = new SumOfDigit();

    @Test
    void sum() {
        int sum = sumOfDigit.sum(123456);
        Assertions.assertEquals(sum, 21);
    }
}