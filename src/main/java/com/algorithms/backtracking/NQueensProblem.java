package com.algorithms.backtracking;

import java.util.Stack;

/*
    You have given a chess board of size NXN, where N is at most 8.

    You have to place N queen in this bord such that no two queens attack.
    A Queen can move horizontally, vertically and diagonally in any direction.

    Write a function given which takes N as argument and
    prints out the positions of N Queen

 */
public class NQueensProblem {

    public void placeNQueen(int n) {
        extend(new Stack<>(), n);
    }

    private void extend(Stack<Integer> partial, int n) {
        if (partial.size() == n) {
            System.out.println(partial);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!partial.contains(i)) {
                partial.add(i);
                if (canExtend(partial, n)) {
                    extend(partial, n);
                }
                partial.pop();
            }
        }
    }

    //TODO write the detailed explanation
    private boolean canExtend(Stack<Integer> partial, int n) {
        int i = partial.size() - 1;
        for (int j = 0; j < i; j++) {
            int a = i - j;
            int b = Math.abs(partial.get(i) - partial.get(j));
            if (a == b) {
                return false;
            }
        }
        return true;
    }
}
