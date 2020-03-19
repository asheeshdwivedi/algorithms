package com.algorithms.backtracking;

import java.util.Arrays;
import java.util.Stack;

/*
  Problem Statement:
    Given a list of number, and a target number. Print all the unique combination in
    candidate where the candidate numbers sum to target.

    Example :
    Input = [10, 1, 2, 7, 6, 1 ,5] , target = 8
    Output :
    [1, 1, 6]
    [1, 2, 5]
    [1, 7]
    [2, 6]
    We should pick only one to avoid duplicates like
    [1,2,5] = [2,5,1] = [5,1,2]

 */
public class SumToTarget {

    public void sum(int[] input, int targetSum) {
        Arrays.sort(input);
        this.sum(input, 0, targetSum, new Stack<>(), 0);
    }

    private void sum(int[] input, int sum, int targetSum, Stack<Integer> partial, int start) {
        if (sum == targetSum) {
            System.out.println(partial);
        }
        if (start == input.length) {
            return;
        }
        for (int i = start; i < input.length; i++) {
            int element = input[i];
            /*
                if a candidate is valid
                - sum + candidate should be less then candidate
                - validate if the candidate chosen is same as the candidate
                chosen before we skip the candidate
             */
            if (sum + element > targetSum || (i > start && input[i] == input[i - 1])) {
                continue;
            }
            partial.add(element);
            sum(input, sum + element, targetSum, partial, i + 1);
            partial.pop();
        }
    }
}
