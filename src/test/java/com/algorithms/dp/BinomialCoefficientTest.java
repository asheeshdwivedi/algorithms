package com.algorithms.dp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinomialCoefficientTest {

    private final BinomialCoefficient binomialCoefficient = new BinomialCoefficient();

    @Test
    void binomialCoefficientRecursive() {
        int result = binomialCoefficient.binomialCoefficientRecursive(6, 4);
        System.out.println(result);
        Assertions.assertEquals(15 , result);
    }

    @Test
    void binomialCoefficientTopDown(){
        int result = binomialCoefficient.binomialCoefficientTopDown(6, 4 , new int[7][5]);
        System.out.println(result);
        Assertions.assertEquals(15 , result);
    }

    @Test
    void binomialCoefficientBottomUp(){
        int result = binomialCoefficient.binomialCoefficientBottomUp(6, 4);
        System.out.println(result);
        Assertions.assertEquals(15 , result);
    }

}