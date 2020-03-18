package com.algorithms.recursion;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringPalindromeTest {

    private final StringPalindrome palindrome = new StringPalindrome();
    @Test
    void isPalindrome_dabad() {
        boolean result = this.palindrome.isPalindrome("dabad");
        Assertions.assertTrue(result);
    }

    @Test
    void isPalindrome_xyyx() {
        boolean result = this.palindrome.isPalindrome("xyyx");
        Assertions.assertTrue(result);
    }

    @Test
    void isPalindrome_ppq() {
        boolean result = this.palindrome.isPalindrome("ppq");
        Assertions.assertFalse(result);
    }
}