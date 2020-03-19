package com.algorithms.backtracking;

import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class BreakWordFromGivenDictionaryTest {

    private final BreakWordFromGivenDictionary beak = new BreakWordFromGivenDictionary();

    @Test
    public void test(){
        beak.breakWords("catsanddog" , new HashSet<String>()
                {{
                    add("cat");
                    add("cats");
                    add("and");
                    add("sand");
                    add("dog");
                }}
        );
    }
}