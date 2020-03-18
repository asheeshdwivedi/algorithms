package com.algorithms.recursion;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayInSequenceTest {

    private ArrayInSequence arrayInSequence = new ArrayInSequence();

    @Test
    void isInSequence() {
        boolean result = arrayInSequence.isInSequence(new int[]{2, 3, 4, 5, 6, 7});
        Assertions.assertTrue(result);
    }

    @Test
    void isInSequence_False() {
        boolean result = arrayInSequence.isInSequence(new int[]{2, 4, 5, 6, 7});
        Assertions.assertFalse(result);
    }
}