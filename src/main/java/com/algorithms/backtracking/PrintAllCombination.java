package com.algorithms.backtracking;

/*
 Problem Statement :
 Given an input array and integer 'K' which is at most the size of the array,
 generate all the ways we can choose K integers from array.

Example
Input = [3, 2, 5 ,8] , K = 3 we have to print out the ways to chose 3 integer from the given array

Output :
    [3, 2, 5]
    [3, 2, 8]
    [3, 5, 8]
    [2, 5, 8]

                                                [ ] 3,2,5,8


           [3] 2,5,8                              [2]5,8                         [5] 8


     [3,2]5,8          [3, 5]8               [2,5]8      [2,8]                   [5,8]


[3,2,5]8   [3,2,8]5    [3,5,8]             [2,5,8]
 */

import java.util.Set;

public class PrintAllCombination {

    public void combination(int input[], int k, Set<Integer> set, int start) {
        if (set.size() == k) {
            System.out.println(set);
            return;
        }
        if (start == input.length) {
            return;
        }
        for (int i = start; i < input.length; i++) {
            set.add(input[i]);
            combination(input, k, set, i + 1);
            set.remove(input[i]);
        }
    }

    /*
    =================================================================================================================================================
            - We go through one element at a time and every element we have two choices,
               - Either we include the element
               - Or Not include the element.

    -----------------------------------------------[]-------------------------------------------------------------------------------------3

    --------------------[3]---------------------------------------------------------------------------[]----------------------------------2

    --------[3,2]---------------------[3]-----------------------------------------------[2]----------------------------[]-----------------5

    -[3,2,5]-----[3,2]---------[3,5]--------[3]---------------------------------[2,5]---------[2]---------------[2]-------------[]---------8

           [3,2,8]  [3,2]  [3,5,8] [3,5] [3,8] [3]                      [2,5,8]   [2,5]   [2,8]   [2]      [2,5]  [2]     [2]      []

    =================================================================================================================================================
         */
    public void combinationAlternative(int[] input, Set<Integer> partial, int index, int k) {
        if (partial.size() == k) {
            System.out.println(partial);
            return;
        }
        if(index == input.length){
            return;
        }
        partial.add(input[index]); // include the element
        combinationAlternative(input, partial, index + 1, k); // may or may not lead to solution
        partial.remove(input[index]); // exclude the element
        combinationAlternative(input, partial, index + 1, k); // may or may not lead to solution
    }
}
