package com.algorithms.dynamic.programming;

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
 */
public class HouseRobber {

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
}
