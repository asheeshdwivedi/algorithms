package com.algorithms.dp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class HouseRobberTest {

    private final HouseRobber houseRobber = new HouseRobber();

    @Test
    void robRecursive() {
        int maximum = houseRobber.robRecursive(5, new int[]{1, 2, 3, 4, 5});
        System.out.println(maximum);
        Assertions.assertEquals(maximum, 9);
    }


    @Test
    void rob6HouseRecursive() {
        int maximum = houseRobber.robRecursive(6, new int[]{1, 2, 3, 4, 5, 6});
        System.out.println(maximum);
        Assertions.assertEquals(maximum, 12);
    }


    @Test
    void robDp() {
        int maximum = houseRobber.robDp(5, new int[]{1, 2, 3, 4, 5});
        System.out.println(maximum);
        Assertions.assertEquals(maximum, 9);
    }

    @Test
    void robDp6House() {
        int maximum = houseRobber.robDp(6, new int[]{1, 2, 3, 4, 5 ,6});
        System.out.println(maximum);
        Assertions.assertEquals(maximum, 12);
    }
}