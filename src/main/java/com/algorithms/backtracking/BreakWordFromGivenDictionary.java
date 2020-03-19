package com.algorithms.backtracking;

import java.util.*;
import java.util.stream.Collectors;

/*
  Problem Statement :
   Given a string s and the dictionary containing a list of words, write a function to break
   the string completely into valid words. Print all such possible sentences.
   The same word in the dictionary may be reused multiple times.

   Example : Input = "catsanddog" dictionary = ["cat", "cats" , "and" ,"dog"]
   Output:
   "cat", "sand" ,"dogs"

   "cat", "and" , "dog"

 */
public class BreakWordFromGivenDictionary {

    public void breakWords(String input, Set<String> dictionary) {
        breakWords(input, dictionary, new Stack<>());
    }

    public void breakWords(String input,
                           Set<String> dictionary,
                           Stack<String> partial) {

        if (input.length() == 0) {
            System.out.println(partial);
            return;
        }

        for (int i = 0; i < input.length(); i++) {
            String word = input.substring(0, i + 1);
            if (dictionary.contains(word)) {
                partial.add(word);
                breakWords(input.substring(i + 1), dictionary, partial);
                partial.pop();
            }
        }

    }
}
