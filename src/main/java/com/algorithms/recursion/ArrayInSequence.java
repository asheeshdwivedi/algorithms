package com.algorithms.recursion;

/*
 Given an array , write a recursive function to check if elements of array in sequence

  Input : [2, 3 ,4 , 5 , 6 ,7] , output = true
  Input : [2, 4, 5, 6, 7] ,  output is false, because 3 is missing

  isInSequence(A , i ) => isInSequence(A , i+1 ) if A[i]  == A[i+1] -1
  isInSequence(A , i ) => true i == A.length - 1

 */
public class ArrayInSequence {

    public boolean isInSequence(int[] a) {
        return isInSequenceInner(a , 0);
    }

    private boolean isInSequenceInner(int[] a, int i) {
        if (i == a.length - 1) {
            return true;
        }
        return a[i] == a[i + 1] -1 && isInSequenceInner(a, i + 1);
    }


}
