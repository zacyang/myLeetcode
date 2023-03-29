package com.leetcode.second.dp;

import java.util.Arrays;

public class CoinChangeII {
    public int change(int amount, int[] coins) {

        int[] dp = new int[amount + 1];
        dp[0] =1;
        for (int coin : coins) {
            for (int i = 1; i < dp.length; i++) {
                if (i - coin >= 0) {
                    dp[i] += dp[amount - coin];
                }
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        int change = new CoinChangeII().change(3, new int[]{1, 2, 5});
        System.out.println(change);
    }
}
