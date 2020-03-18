package com.algorithms.backtracking;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NQueensProblemTest {

    private NQueensProblem nQueensProblem = new NQueensProblem();

    @Test
    void place4Queen(){
        nQueensProblem.placeNQueen(4);
    }

    @Test
    void place8Queen(){
        nQueensProblem.placeNQueen(8);
    }
}