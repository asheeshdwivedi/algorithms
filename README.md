# algorithms
Algorithms

### Dynamic Programing

## Tables of Contents
- [Cutting Rod](#Cutting Rod)

## Cutting Rod

#### Problem Statement

Given a rod of length n and price `P[i]` for `i = 1, 2, 3, ..., n` where `P[i]` is the price 
of the rod of length i. Find the maximum total revenue you can make by cutting the rod (Assume
no cost for cutting the rod) 

```
 length  i = 1 | 2 | 3 | 4 | 5  | 6  | 7  | 8  | 9  | 10
 price  Pi = 1 | 5 | 8 | 9 | 10 | 17 | 17 | 20 | 24 | 30

```

Lets say we have the rod length of 9 how we can maximize the profit by cutting them 
 - Sell one piece cost will be `24`
 - Sell two pieces one for length `1` and other of length `8` price will be `1 + 20 = 21`
 - Sell two pieces one for length `5` and other for length `4` price will be `10 + 9 = 29`

ans so on there are so many ways to cut the rod 

#### Solution

Lets say we have a length of rod is n ans we divided the rod in n pieces which is 
`1, 2, 3, ...,  n`

####  Possible cases 
- Cut a piece of length 1 and find the optimal division of length(n-1)
    `Revenue = P[1] + revenue(n-1)`
- Cut a piece of length 2 and find the optimal division of length(n-2)
    `Revenue = P[2] + revenue(n-2)`
- Cut a piece of length 3 and find the optimal division of length(n-3)
    `Revenue = P[3] + revenue(n-3)`
- Cut a piece of length n-1 and find the optimal division of length 1
     ```
      Revenue = P[n-1] + revenue(1)
              = P[n-1] + P[1]
     ```
- Sell in one price 
    `Revenue = P[N]` 

So, the best choice is the maximum of 
 ```
 max of { P[1]+ revenue(n-1), P[2] + revenue(n-1), P[3] + revenue(n-3), ...., P[n-1] + revenue(1), P[N] }
``` 

Define `R[n]` as the maximum revenue you can make from rod of length m then

```
    R[n] = max[P[1] + R[n-1], P[2] + R[n-2], P[3] + R[n-3] ..., P[n-1] + R[1] , P[n] + R[0]]
```

Base case `R[0] = 0` if the length of rod is 0 the revenue will be 0

#### Recursive Solution  
```
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
```

#### DP Solution
```
    public int dpRevenue(int lengthOfRod, int[] price) {
        int[] revenue = new int[lengthOfRod + 1];
        revenue[0] = 0;
        for (int i = 1; i <= lengthOfRod; i++) {
            int MAX_VAL = -1;
            for (int j = 1; j <= i; j++) {
                int tmp = price[j - 1] + revenue[i - j];
                if (tmp > MAX_VAL) {
                    MAX_VAL = tmp;
                }
                revenue[i] = MAX_VAL;
            }
        }
        return revenue[lengthOfRod];
    }
```