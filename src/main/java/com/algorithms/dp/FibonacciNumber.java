package com.algorithms.dp;

/*

Recurrence Relation :
  f(n) = f(n-1) + f(n-2)
  Base case :
  f(0) = 0
  f(1) = 1
 */
public class FibonacciNumber {

    public int fibRecursive(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fibRecursive(n - 1) + fibRecursive(n - 2);
    }

    public int fibTopDownApproach(int n, int[] cache) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (cache[n] != 0) return cache[n];
        int result = fibTopDownApproach(n - 1, cache) + fibTopDownApproach(n - 2, cache);
        cache[n] = result;
        return result;
    }
    /*
      - We solve all the smaller sub problems first which will be needed to solve the
        larger problems then move on to solving larger problems using the result
        of smaller sub problems

       - We use for-loop to iterate over all the sub problems and solve them.


    */
    public int fibBottomUpApproach(int n) {
        int result[] = new int[n + 1];
        result[0] = 0;
        result[1] = 1;
        for (int i = 2; i <= n; i++) {
            result[i] = result[i - 1] + result[i - 2];
            // smaller sub problems are solved before solving the bigger one
        }
        return result[n];
    }
}
