package com.algorithms.dp;
/*
 (n k) n choose k, denote number of ways to choose k items from n items
 where sequence does not matter.

formula :
(n ,k) = n!/(n-k)!k!

Recursive formula

f(n,k) = f(n-1 , k-1)+ f(n-1 ,k) where f(n,n) = 0 and f(n,0) = 1
 */


public class BinomialCoefficient {

    public int binomialCoefficientRecursive(int n, int k) {
        if (n == k) return 1;
        if (k == 0) return 1;
        return binomialCoefficientRecursive(n - 1, k - 1)
                + binomialCoefficientRecursive(n - 1, k);
    }

    public int binomialCoefficientTopDown(int n, int k, int[][] cache) {
        if (n == k) return 1;
        if (k == 0) return 1;
        if (cache[n][k] != 0) {
            return cache[n][k];
        }
        int result = binomialCoefficientTopDown(n - 1, k - 1, cache)
                + binomialCoefficientRecursive(n - 1, k);
        cache[n][k] = result;
        return result;
    }

    public int binomialCoefficientBottomUp(int n, int k) {
        int[][] cache = new int[n + 1][k + 1];

        for (int i = 0; i <= n; i++) {
            cache[i][0] = 1;
            if (i <= k) {
                cache[i][i] = 1;
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                cache[i][j] = cache[i - 1][j - 1] + cache[i - 1][j];
            }
        }
        return cache[n][k];
    }

}


