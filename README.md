# algorithms
Algorithms

### Dynamic Programing

## Tables of Contents
- [Cutting Rod](#Cutting Rod)
- [Stair Climbing](#Stair Climbing)
- [House Robber](#House Robber)

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

## Stair Climbing

#### Problem Statement

 You can climb `1` or `2` stairs with one step. How many different ways can you
 climb `n` stairs

Lets assume we have 3 stairs
   - we can climb either 1 stair at a time so 3 times 1 stair
   - we can climb 2 stair and then 1 stair
   - we can climb 1 stair and then 2 stair.
 so total 3 ways to climb 3 stairs

#### Solution 
 Let `f(n)` be the number of different ways to climb `n` stairs
 
How we can reach to the `nth` stair ?

#### Possible cases 
- Be at the `(n-2)th` stair, then climb `2` steps.
- Be at the `(n-1)th` stair then climb `1` steps.

for case 1st, number of ways to reach `(n-2)th` stair is `f(n-2)`

for case 2nd, number of ways to reach `(n-1)th` stair is `f(n-1)`

 `f(n) = f(n-2) + f(n-1)`. use recursion! 
 
 Base case is `f(1) = 1` and `f(2) = 2`
 
 #### Recursive Solution  
 ```
      public int recursion(int numberOfStairs) {
             if (numberOfStairs == 1)
                 return 1;
             else if (numberOfStairs == 2)
                 return 2;
             else
                 return recursion(numberOfStairs - 2)
                         + recursion(numberOfStairs - 1);
         }

 ```
 
 #### DP Solution
 ```
      public int withOutRecursion(int numberOfStairs) {
             int[] result = new int[numberOfStairs+1];
             result[1] = 1;
             result[2] = 2;
             for (int i = 3; i <= numberOfStairs; i++) {
                 result[i] = result[i - 2] + result[i - 1];
             }
             return result[numberOfStairs];
         }
 ```

## House Robber

#### Problem Statement

You are a professional robber planning to rob a houses along a street.
Each house has a certain amount of money stashed, the only constrain stopping
you from robbing each of them is adjacent houses have security system connected
and it will automatically connect to police if two adjacent house were broken
into on the same night.

Given a list of non negative integer representing the amount of money of each
house, determine the maximum amount of money you can rob tonight
without alerting the police

 Example :
   `A {1, 2, 3, 4, 5}`
   - Can Rob : 2, 4
   - Can Rob : 1, 3 ,5
   - Can Rob : 1, 3
   - Can Rob : 2, 4
   - ...
   
   So many different possibility
 
#### Solution    
Define `R[i]` as the maximum money you can steel from house `1` to house `i`.

#### Possible cases :   
- You steal house i
- You don't steal house i

#### Case 1 :
if you steal house `i`, then you can not steal house `i-1` but you can steel from `i-2, i-3, ... 2, 1`. 
So if you steal from house i then
  ``` 
R[i] = nums[i] + max[R[i-2] , R[i-3] ...., R[1]]
  ```
#### Case 2 : 

If you don't steel from house `i`, then the max money you can steal is `R[i-1]`

```
 R[i] = max[R[i-1] ,nums[i] + max[R[i-2] , R[i-3] ...., R[1]]]
```

Base case : `R[1] = numb[1]`

#### Recursive Solution  
```
    public int robRecursive(int numberOfHouse, int[] moneyStashInHouse) {
            if (numberOfHouse == 1)
                return moneyStashInHouse[0];
            if (numberOfHouse == 2)
                return Integer.max(moneyStashInHouse[0], moneyStashInHouse[1]);
            int MAX_VALUE = -1;
            MAX_VALUE = Integer.max(MAX_VALUE, robRecursive(numberOfHouse - 1, moneyStashInHouse));
            for (int i = numberOfHouse - 2; i > 0; i--) {
                MAX_VALUE = Integer.max(MAX_VALUE, robRecursive(i, moneyStashInHouse) + moneyStashInHouse[numberOfHouse - 1]);
            }
            return MAX_VALUE;
        }
```

#### DP Solution
```
     public int robDp(int numberOfHouse, int[] moneyStashInHouse) {
            int[] maximumRob = new int[numberOfHouse];
            maximumRob[0] = moneyStashInHouse[0];
            maximumRob[1] = Integer.max(moneyStashInHouse[0], moneyStashInHouse[1]);
            for (int i = 2; i < numberOfHouse; i++) {
                maximumRob[i] = maximumRob[i - 1]; // if you don't rob house i
                maximumRob[i] = Integer.max(maximumRob[i], maximumRob[i - 2] + moneyStashInHouse[i]);
            }
            return maximumRob[numberOfHouse - 1];
        }
```