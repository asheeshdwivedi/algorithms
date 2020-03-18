package com.algorithms.backtracking;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/*
    Given an array of integer, print all the permutations of the given array.

    Input = [1, 2, 3]
    output =
    1, 2, 3
    1, 3, 2
    2, 1, 3
    2, 3, 1
    3, 1, 2
    3, 2, 1
                                          [  ]

            [ 1 ]                        [ 2 ]                         [ 3 ]

      [1, 2]      [1, 3]          [2, 1]        [2, 3]          [ 3, 1]       [3, 2]

     [1, 2, 3]   [1, 3, 2]      [2, 1, 3]     [2, 3, 1]        [3, 1, 2]      [3, 2, 1]

How so we achive this by recursion and backtracking

Backtracking is a systematic approach to generate all the possibilities for a given exhaustive
search/combinatorial  search problem using recursion.

Steps :
1. we start of with initial state with an empty solution, at every step we extend the partial solution by
considering all the possibilities.

2. We check if the partial solution meets the given criteria, if it does not then backtrack
one step and try out another possibility.

Pseudo code
function(input, partial, ,output){

   if (isValidSolution(partial)){
       processSolution(partial)
       return
   }

   // in every step we extend the solution to extend the solution we need to generate the candidate
   candidates = generateCandidates(input, partial)

   for c in candidates {
        addCandidate(c , input , partial) // add candidate to partial solution
        function(input, partial, output)  //  call the function with the partial result
        remove(c , input , partial) // once the recursive function end remove the candidate
  }
Here adding the candidate and going down the path and removing the candidate form the result and
adding the different candidate is called the backtracking

Backtracking can be used solution two brod categories of problem
1. To generate permutation (Sequence is important )
2. To generate combination (Sequence is not important )

In permutation the order matters and in combination the order not matter.

 */
public class PrintAllPermutations {

    public void permutation(int[] input, List<Integer> partial, boolean[] used) {
        if (partial.size() == input.length) { //isValidSolution(partial)
            System.out.println(Arrays.toString(partial.toArray())); //processSolution(partial)
            return;
        }
        //generateCandidates(input, partial)
        for (int i = 0; i < input.length; i++) {
            if (!used[i]) {
                used[i] = true;
                partial.add(input[i]); //addCandidate
                permutation(input, partial, used); //  call the function with the partial result
                used[i] = false;
                partial.remove(partial.size() - 1); //once the recursive function end remove the candidate
            }
        }
    }

    public void permutationAlternative(int[] input, Stack<Integer> partial) {
        if (partial.size() == input.length) {
            System.out.println(partial);
        }
        for (int i = 0; i < input.length; i++) {
            int element = input[i];
            if (!partial.contains(element)) {
                partial.add(element);
                permutationAlternative(input ,partial);
                partial.pop();
            }
        }
    }
}
