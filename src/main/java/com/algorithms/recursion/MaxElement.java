package com.algorithms.recursion;

/*
    Given an array of integer, write a function which uses recursion to
    find the maximum.
    Input :  [4,3,6,7,0,9,2]
    Output : 9

    Solution :
    1. Define the Max as -1, consider all the elements in an array is positive.
    2.Compare the each element in an array with max if the element is grater then max
      update the max.

   Lets say we have A[i] where elements are from 1... i all non negative integer/
    Recurrence Relation :
    f(A , i) = max(a[i] , f(A , i-1)) // breaking a problem into sub problem
    Base case f(A , 0) = A[0];

     A= [4,3,6,7,0,9,2]

    f(A , 6) = max(2 , f(A , 5) ) => 9

    f(A , 5) = max(9 , f(A , 4)) =>  9

    f(A , 4) = max(0 , f(A , 3)) =>  7

    f(A , 3) = max(7 , f(A , 2)) =>  7

    f(A , 2) = max(6 , f(A , 1)) =>  6

    f(A , 1) = max(3 , f(A , 0)) =>  4

    f(A , 0) = 4


 */
public class MaxElement {

    public int max(int[] a) {
        return this.maximum(a, a.length - 1);
    }

    private int maximum(int[] a, int i) {
        if (i == 0)
            return a[0];
        return Integer.max(a[i], this.maximum(a, i - 1));
    }

}
