package com.algorithms.dp;

/*
Problem Statement :
   You are a professional robber planning to rob a houses along a street.
   Each house has a certain amount of money stashed, the only constrain stopping
   you from robbing each of them is adjacent houses have security system connected
   and it will automatically connect to police if two adjacent house were broken
   into on the same night.

   Given a list of non negative integer representing the amount of money of each
   house, determine the maximum amount of money you can rob tonight
   without alerting the police

   example A {1, 2, 3, 4, 5}
   Can Rob : 2, 4
   Can Rob : 1, 3 ,5
   Can Rob : 1, 3
   Can Rob : 2, 4
   ...
   so many different possibility

   Navine Solution :

   Define R[i] as the maximum money you can steel from house 1 to house i.
   There is two cases
   1. You steal house i
   2. You don't steal house i

  Case 1:
   if you steal house i, then you can not steal house i-1 but you can steel from
   i-2, i-3, ... 2, 1. so if you steal from house i then
   R[i] = nums[i] + max[R[i-2] , R[i-3] ...., R[1]]
 Case 2:
   If you don't steel from house i, then the max money you can steal is R[i-1]

R[i] = max[R[i-1] ,nums[i] + max[R[i-2] , R[i-3] ...., R[1]]]

Base case R[1] = numb[1]

Recurrence Relation :
i is the index of house to rob
nums are the money for house i .. n
maxProfit(i, nums) = Max(nums[i] + maxProfit(i-2 , nums) , maxProfit(i-1 , nums) )
base cases :
i == 0 return nums[0]
i < 0 return 0 // edge case if since each recursive call we are calling with i-2
  so if i=1 will have i-2 will become -1
 */
public class HouseRobber {

    public int robRecursive(int indexOfHouse, int[] moneyStashInHouse) {
        if (indexOfHouse < 0) {
            return 0;
        }
        if (indexOfHouse == 0) {
            return moneyStashInHouse[0];
        }
        int robCurrentHouse = moneyStashInHouse[indexOfHouse] + robRecursive(indexOfHouse - 2, moneyStashInHouse);
        int skipCurrentHouse = robRecursive(indexOfHouse - 1, moneyStashInHouse);
        return Integer.max(robCurrentHouse, skipCurrentHouse);
    }

    public int robTopDown(int indexOfHouse, int[] moneyStashInHouse, int cache[]) {
        if (indexOfHouse < 0) {
            return 0;
        }
        if (indexOfHouse == 0) {
            return moneyStashInHouse[0];
        }
        if (cache[indexOfHouse] != 0) {
            return cache[indexOfHouse];
        }
        int robCurrentHouse = moneyStashInHouse[indexOfHouse] + robRecursive(indexOfHouse - 2, moneyStashInHouse);
        int skipCurrentHouse = robRecursive(indexOfHouse - 1, moneyStashInHouse);
        int maxProfit = Integer.max(robCurrentHouse, skipCurrentHouse);
        cache[indexOfHouse] = maxProfit;
        return maxProfit;
    }


    public int robDp(int[] moneyStashInHouse) {
        int numberOfHouse = moneyStashInHouse.length;
        int[] maximumRob = new int[numberOfHouse];
        maximumRob[0] = moneyStashInHouse[0];
        maximumRob[1] = Integer.max(moneyStashInHouse[0], moneyStashInHouse[1]);
        for (int i = 2; i < numberOfHouse; i++) {
            maximumRob[i] = maximumRob[i - 1]; // if you don't rob house i
            maximumRob[i] = Integer.max(maximumRob[i], maximumRob[i - 2] + moneyStashInHouse[i]);
        }
        return maximumRob[numberOfHouse - 1];
    }

    /* converting recurrence relation  with the DP equation
     Recurrence Relation :
     cache[i]  = Max(nums[i-1] + cache[i-2] , cache[i-1]))
     */
    public int robDpAlternative(int[] moneyStashInHouse) {
        int n = moneyStashInHouse.length;
        int[] cache = new int[n + 1];
        cache[1] = moneyStashInHouse[0];
        for (int i = 2; i <= n; i++) {
            cache[i] = Integer.max(moneyStashInHouse[i - 1] + cache[i - 2], cache[i - 1]);
        }
        return cache[n];
    }

    public int robDpAlternativeReconstruct(int[] moneyStashInHouse) {
        int n = moneyStashInHouse.length;
        int[] cache = new int[n + 1];
        boolean[] decision = new boolean[n];
        cache[1] = moneyStashInHouse[0];
        for (int i = 2; i <= n; i++) {
            int robCurrentHouse = moneyStashInHouse[i - 1] + cache[i - 2];
            int skipCurrentHouse = cache[i - 1];
            if (robCurrentHouse > skipCurrentHouse) {
                cache[i] = robCurrentHouse;
                decision[i - 1] = true;
            } else {
                cache[i] = cache[i - 1];
                decision[i - 1] = false;
            }
        }
        int i = n - 1;
        while (i >= 0) {
            if (decision[i]) {
                System.out.println(i + " " + moneyStashInHouse[i]);
                i = i - 2;
            } else {
                i--;
            }
        }
        return cache[n];
    }
}
