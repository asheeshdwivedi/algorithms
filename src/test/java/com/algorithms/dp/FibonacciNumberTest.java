package com.algorithms.dp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciNumberTest {

    private final FibonacciNumber fibonacciNumber = new FibonacciNumber();

    @Test
    void fibRecursive() {
        int fibonacci = fibonacciNumber.fibRecursive(10);
        System.out.println(fibonacci);
        Assertions.assertEquals(fibonacci, 55);
    }

    @Test
    void fibTopDownApproach(){
        int fibonacci = fibonacciNumber.fibTopDownApproach(10, new int[11]);
        System.out.println(fibonacci);
        Assertions.assertEquals(fibonacci, 55);
    }

    @Test
    void fibBottomUpApproach(){
        int fibonacci = fibonacciNumber.fibTopDownApproach(10, new int[11]);
        System.out.println(fibonacci);
        Assertions.assertEquals(fibonacci, 55);
    }


}