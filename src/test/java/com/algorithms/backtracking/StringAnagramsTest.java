package com.algorithms.backtracking;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringAnagramsTest {

    private final StringAnagrams stringAnagrams = new StringAnagrams();

    @Test
    void anagrams() {
        stringAnagrams.anagrams("god");
    }
}