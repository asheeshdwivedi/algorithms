package com.algorithms.dynamic.programming;

/*
  Given a rod of length n and price P[i] for i = 1, ..., n where P[i] is the price
   of the rod of length i. find the maximum total revenue you can make by cutting the rod
   (Assume no cost for cutting the rod).

   length  i = 1 | 2 | 3 | 4 | 5  | 6  | 7  | 8  | 9  | 10
   price  Pi = 1 | 5 | 8 | 9 | 10 | 17 | 17 | 20 | 24 | 30

   Lets say we have the rod length ogf 9 how we can maximize the profit by cutting them
   a) sell one piece code will be 24
   b) sell two pieces one for length 1 and other of length 8 price will be 1 + 20 = 21
   c) sell two pieces one for length 5 and other of length 4 price will be 10 + 9 = 19

   and so on there are so many ways to cut the rod

 Navie solution :
     lets say we a length of rod is n and we divided the rod in n pieces
     which is 1,2 , 3, .... , n
  Possible cases
   1. cut a piece of length 1 and find the optimal division for length(n-1)
       Revenue ->  P1 + r(n-1)
   2. cut a piece of length 2 and find the optimal division for length(n-2)
       Revenue -> P2 + r(n-2)
   3. cut a piece of length 3 and find the optimal division for length(n-3)
       Revenue -> P3 + r(n-3)
  (n-1). cut a piece of length (n-1) and find the optimal division of length of 1
       Revenue -> P(n-1) + r1 = P(n-1) + P1
   n.  Sell in one price
       Revenue -> Pn

  so , the best choice is the maximum of
    max of these value [P1 + r(n-1) , P2 + r(n-2) , P3 + r(n-3) ... , P(n-1)+ r1 , Pn]

  Define R[n] as the maximum revenue you can make from a rod of length n then
    R[N] = max[P[1] + R[n-1] , P[2] + R[n-2] , P[3] + R[n-3] ... , P[n-1]+ R[1] , P[n] + R[0]]
  Base case R[0] = 0;
 */
public class CuttingRods {


    public int recursiveRevenue(int lengthOfRod, int[] price) {
        if (lengthOfRod == 0)
            return 0;
        int MAX_VAL = -1;
        for (int i = 0; i < lengthOfRod; i++) {
            int tmp = price[lengthOfRod - i - 1] + recursiveRevenue(i, price);
            if (tmp > MAX_VAL)
                MAX_VAL = tmp;
        }
        return MAX_VAL;
    }

    public int dpRevenue(int lengthOfRod, int[] price) {
        int[] revenue = new int[lengthOfRod+1];
        revenue[0] = 0;
        for (int i = 1; i <= lengthOfRod; i++) {
            int MAX_VAL = -1;
            for (int j = 1; j <= i; j++) {
                int tmp = price[j-1] + revenue[i - j];
                if (tmp > MAX_VAL) {
                    MAX_VAL = tmp;
                }
                revenue[i] = MAX_VAL;
            }
        }
        return revenue[lengthOfRod];
    }


}
