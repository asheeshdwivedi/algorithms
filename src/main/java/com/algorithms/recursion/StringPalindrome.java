package com.algorithms.recursion;

/*
  Given a string write a function which uses a recursion to check if its
  palindrome. A palindrome is a string which is same when read from either
  direction.
 Example :
 Input : "dabad" Output " true

 Input : "xyyx" Output " true

 Input : "ppq" Output " false

 Solution :
 lets say we have a array of A[i] where elements are from 1 to i;
 1.take two pointer at from the start i.e 1 and at the end i.e i
 2. Compare the charter from the pointer a[1] = a[i] if they are same move the pointer invert
 2. after moving the pointer invert compare the char again a[2] = a[i-1]
 3. Repeat this until both the pointers points to the same char left pointer == right pointer
 or the left pointer passed the right pointers

 Recurrence Relation
 isPalindrome(S , i , j) = isPalindrome(S , i+1 , j-1) if(S[i] == S[J]) else false
 base case i >= j return true;

*/
public class StringPalindrome {

    public boolean isPalindrome(String input) {
        return isPalindrome(input, 0, input.length() - 1);
    }

    private boolean isPalindrome(String input, int i, int j) {
        if (i >= j)
            return true;
        return input.charAt(i) == input.charAt(j) && isPalindrome(input, i + 1, j - 1);
    }

}
