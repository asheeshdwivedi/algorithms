package com.algorithms.dp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class HouseRobberTest {

    private final HouseRobber houseRobber = new HouseRobber();

    @Test
    void robRecursive() {
        int maximum = houseRobber.robRecursive(4, new int[]{1, 2, 3, 4, 5});
        System.out.println(maximum);
        Assertions.assertEquals(maximum, 9);
    }

    @Test
    void rob2HousesRecursive() {
        int maximum = houseRobber.robRecursive(1, new int[]{1, 2});
        System.out.println(maximum);
        Assertions.assertEquals(maximum, 2);
    }

    @Test
    void rob1HousesRecursive() {
        int maximum = houseRobber.robRecursive(0, new int[]{1});
        System.out.println(maximum);
        Assertions.assertEquals(maximum, 1);
    }


    @Test
    void robTopDown() {
        int[] cache = new int[6];
        int maximum = houseRobber.robTopDown(5, new int[]{1, 2, 3, 4, 5, 6} , cache);
        System.out.println(maximum);
        Assertions.assertEquals(maximum, 12);
    }

    @Test
    void rob6HouseRecursive() {
        int maximum = houseRobber.robRecursive(5, new int[]{1, 2, 3, 4, 5, 6});
        System.out.println(maximum);
        Assertions.assertEquals(maximum, 12);
    }


    @Test
    void robDp() {
        int maximum = houseRobber.robDp( new int[]{1, 2, 3, 4, 5});
        System.out.println(maximum);
        Assertions.assertEquals(maximum, 9);
    }

    @Test
    void robDp6House() {
        int maximum = houseRobber.robDp( new int[]{1, 2, 3, 4, 5 ,6});
        System.out.println(maximum);
        Assertions.assertEquals(maximum, 12);
    }

    @Test
    void robDpAlternative() {
        int maximum = houseRobber.robDpAlternativeReconstruct( new int[]{1, 2, 3, 4, 5 ,6});
        System.out.println(maximum);
        Assertions.assertEquals(maximum, 12);
    }

    @Test
    void robDpAlternativeReconstruct() {
        int maximum = houseRobber.robDpAlternativeReconstruct( new int[]{20, 25, 30, 15, 10});
        System.out.println(maximum);
        Assertions.assertEquals(maximum, 60);
    }
}