package com.leetcode.second.dp;

// LC 70
public class ClimbingStairs {
    public int climbStairs(int n) {
        int[] dpState = new int[n + 1];


        if (n <= 1) {
            return n;
        }

        dpState[1] = 1;
        dpState[2] = 2;

        for (int i = 3; i < n + 1; i++) {
            dpState[i] = dpState[i - 1] + dpState[i - 2];
        }
        return dpState[n];
    }

    public static void main(String[] args) {
        System.out.println(new ClimbingStairs().climbStairs(3));

    }

}
