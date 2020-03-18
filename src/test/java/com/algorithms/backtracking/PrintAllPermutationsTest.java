package com.algorithms.backtracking;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

class PrintAllPermutationsTest {

    private final PrintAllPermutations printAllPermutations = new PrintAllPermutations();

    @Test
    void permutation() {
        printAllPermutations.permutation(new int[] {1,2,3} , new ArrayList<>() , new boolean[4]);
    }

    @Test
    void permutationAlternative() {
        printAllPermutations.permutationAlternative(new int[]{1, 2, 3}, new Stack<>());
    }
}