package com.algorithms.backtracking;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SumToTargetTest {

    private final SumToTarget sumToTarget = new SumToTarget();


    @Test
    void sum() {
        this.sumToTarget.sum(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
    }
}