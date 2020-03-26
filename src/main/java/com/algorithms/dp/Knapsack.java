package com.algorithms.dp;

/*
States:
1. W - Available Capacity of the bag
2. i - Index of the item being considered

Cost Function : knapsack(W,i) return maximum profit

Identify the base cases.
If W = 0 , it means the knapsack is full. No space available, return 0;
if i = -1, No more item to consider (we start from the last item)

if W == 0 or i == -1 return 0;

Define state transition and optimal choice

option to include the item or exclude the item
1. if we take the ith item and if it fits in the knapsack, then W will become
    W - weight[i],
   to check if the item fits in the knapsack
   weight[i] <= W
2. Skip the ith item , then W will remain same.

                                   f(w ,i)

value[i] + f(W- weight[i], i-1)                         f(W, i-1)

Optimal choice

MAX(value[i] + f(W- weight[i], i-1) , f(W, i -1))

Recurrence Relation
f(W, i) = MAX(value[i] + f(W- weight[i], i-1) , f(W, i -1))
if weight[i] <= w
   MAX(value[i] + f(W- weight[i], i-1) , f(W, i -1))
else
   f(W,i) = f(W, i-1) // exclude the item

Base cases
f(0,i) =  0 // when available capacity is 0
f(W, -1) = 0 // when no more item left to consider

 */
public class Knapsack {

    public int knapsackRecursive(int[] weight, int[] value, int capacity, int index) {
        if (capacity == 0) return 0;
        if (index == -1) return 0;

        if (weight[index] <= capacity) {
            int include = value[index] + knapsackRecursive(weight, value, capacity - weight[index], index - 1);
            int exclude = knapsackRecursive(weight, value, capacity, index - 1);
            return Integer.max(include, exclude);
        } else {
            return knapsackRecursive(weight, value, capacity, index - 1);
        }
    }

    public int knapsackTopDown(int[] weight, int[] value, int capacity, int index, int[][] cache) {
        if (capacity == 0) return 0;
        if (index == -1) return 0;
        if (cache[capacity][index] != -1) {
            return cache[capacity][index];
        }
        if (weight[index] <= capacity) {
            int include = value[index] + knapsackRecursive(weight, value, capacity - weight[index], index - 1);
            int exclude = knapsackRecursive(weight, value, capacity, index - 1);
            cache[capacity][index] = Integer.max(include, exclude);
        } else {
            cache[capacity][index] = knapsackRecursive(weight, value, capacity, index - 1);
        }
        return cache[capacity][index];
    }

    /*

    Rule of thumb If your recurrence relationship, if the value of the parameter passed to
    the recursive call to the function is less than the current value of the parameter, then
    your for loop for the parameter should iterate in ascending order. Otherwise you loop
    for the parameter should iterate in descending order.

     In bottom up approach we convert the recurrence relation to equation


    =============================Recurrence relation============================================

    Base cases
     f(0,i) =  0 // when available capacity is 0
     f(W, -1) = 0 // when no more item left to consider

     f(W, i) = MAX(value[i] + f(W- weight[i], i-1) , f(W, i -1))

     if weight[i] <= w
       MAX(value[i] + f(W- weight[i], i-1) , f(W, i -1))
     else
       f(W,i) = f(W, i-1) // exclude the item
    ==============================================================================================
                            CONVERT RECURRENCE RELATION TO BOTTOM UP EQUATIONS

    ==============================================BOTTOM UP EQUATIONS=============================
    Base case
    let say A is to represent all the items from i to n
    lats say W is to represent all the capacity from i to w

    if i = -1 return 0;
    if w = 0 return 0;

    Bottom up equation

    cache[w][i] = max(value[i] + cache[w-wait[i]][i-1], cache[w][i-1])

    we have problem in this equation at

     cache[w][i-1]
     for i = 0;
     cache[w][i-1] will become cache[w][-1] for -1 will throw an exception

    to over come this we can change the interpretation of i where i = 1 will represent the item at index 0
    and i = 2 will represent the item at index 1 and so on by doing this our equation changes as

    Base case :

    if i = 0, return 0  base cases changes from i=-1 to i = 0
    if w = 0, return 0

    Bottom up equation will be

    cache[w][i] = MAX(value[i-1] + cache[w-weight[i-1]][i] , cache[w][i-1])


    ==============================================================================================

     */
    public int knapsackBottomUp(int[] weight, int[] value, int capacity) {
        int numberOfItems = weight.length;
        int[][] cache = new int[capacity + 1][numberOfItems + 1];
        cache[0][0] = 0; // base case
        for (int i = 1; i <= numberOfItems; i++) {
            for (int j = 1; j <= capacity; j++) {
                if (weight[i - 1] <= j) {
                    int include = value[i - 1] + cache[j - weight[i - 1]][i - 1];
                    int exclude = cache[j][i - 1];
                    cache[j][i] = Integer.max(include, exclude);
                } else {
                    cache[j][i] = cache[j][i - 1];
                }
            }
        }

        return cache[capacity][numberOfItems];
    }

    public int knapsackBottomUpReconstructTheSolution(int[] weight, int[] value, int capacity) {
        int numberOfItems = weight.length;
        int[][] cache = new int[capacity + 1][numberOfItems + 1];
        boolean[][] decisions = new boolean[capacity + 1][numberOfItems + 1];
        cache[0][0] = 0; // base case
        for (int i = 1; i <= numberOfItems; i++) {
            for (int j = 1; j <= capacity; j++) {
                if (weight[i - 1] <= j) {
                    if (value[i - 1] + cache[j - weight[i - 1]][i - 1] > cache[j][i - 1]) {
                        cache[j][i] = value[i - 1] + cache[j - weight[i - 1]][i - 1];
                        decisions[j][i] = true;
                    } else {
                        cache[j][i] = cache[j][i - 1];
                    }
                } else {
                    cache[j][i] = cache[j][i - 1];
                }
            }
        }
        printItemPicked(weight, value, cache, decisions, capacity);

        return cache[capacity][numberOfItems];
    }

    private void printItemPicked(int[] weight, int[] value, int[][] cache, boolean[][] decisions, int capacity) {
        int i = weight.length;
        int w = capacity;
        while (i > 0 && w > 0) {
            boolean picked = decisions[w][i];
            if (picked) {
                String message = String.format("Picked : %d, Weight :%d, Vale : %d", (i - 1), weight[i - 1], value[i - 1]);
                System.out.println(message);
                w = w - weight[i - 1];
            }
            i--; // move to next item
        }

    }

}
