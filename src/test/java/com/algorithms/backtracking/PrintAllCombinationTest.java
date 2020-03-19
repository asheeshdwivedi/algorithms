package com.algorithms.backtracking;

import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class PrintAllCombinationTest {

    private final PrintAllCombination printAllCombination = new PrintAllCombination();

    @Test
    void combination() {
        printAllCombination.combination(new int[]{3, 2, 5, 8 ,10}, 3, new HashSet<>(), 0);
    }

    @Test
    void combinationAlternative() {
        printAllCombination.combinationAlternative(new int[]{3, 2, 5, 8}, new HashSet<>(), 0, 3);
    }

}