package com.algorithms.recursion;

/*
Recurrence Relation :
sum(num) = (num%10) + sum(num/10)
sum(num) = 0 if num = 0
 */
public class SumOfDigit {

    public int sum(int input) {
        if (input == 0) {
            return 0;
        }
        return input % 10 + sum(input / 10);
    }
}
