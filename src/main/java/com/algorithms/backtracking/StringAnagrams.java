package com.algorithms.backtracking;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Stack;
import java.util.stream.Collectors;

/*
  Problem Statement :
    Given a string, write a function to print out all its anagrams.
    Example:
    Input = "god"
    Output :
    "god"
    "gdo"
    "dog"
    "dgo"
    "ogd"
    "odg"
 */
public class StringAnagrams {

    public void anagrams(String input) {
        anagramInternal(input, new Stack<>());
    }

    private void anagramInternal(String input, Stack<Character> partial) {
        if (partial.size() == input.length()) {
            final String anagram = partial.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining());
            System.out.println(anagram);
        }
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (!partial.contains(c)) {
                partial.add(c);
                anagramInternal(input, partial);
                partial.pop();
            }
        }
    }
}
