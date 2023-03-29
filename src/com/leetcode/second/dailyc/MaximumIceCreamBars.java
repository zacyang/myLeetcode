package com.leetcode.second.dailyc;

import java.util.Arrays;

public class MaximumIceCreamBars {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int numberOfBars = 0;
        for (int cost : costs) {
            coins -= cost;
            if (coins < 0) {
                return numberOfBars;
            } else {
                numberOfBars++;
            }

        }
        return numberOfBars <= 0 ? 0 : numberOfBars;
    }

    public static void main(String[] args) {
        int i = new MaximumIceCreamBars().maxIceCream(new int[]{
                10, 6, 8, 7, 7, 8
        }, 5);

        System.out.println(i);
    }
}
