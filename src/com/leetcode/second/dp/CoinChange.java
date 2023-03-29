package com.leetcode.second.dp;

import java.lang.reflect.Array;
import java.util.Arrays;

//LC 322
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int[] dpTable = new int[amount + 1];
        Arrays.fill(dpTable, amount+1);
        dpTable[0]= 0;
        for (int targetAmount = 1; targetAmount < amount + 1; targetAmount++) {

            for (int coin : coins) {
                if (targetAmount - coin >= 0) {
                    dpTable[targetAmount] = Math.min(dpTable[targetAmount - coin] + 1, dpTable[targetAmount]);
//                    dpTable[targetAmount] = Math.min(dpTable[targetAmount], dpTable[targetAmount - coin] + 1);
                }

            }

        }

        return dpTable[amount] > amount? -1: dpTable[amount];
    }

    public static void main(String[] args) {
        int i = new CoinChange().coinChange(new int[]{3,5}, 2);
        System.out.println(i);
        System.out.println(Integer.MAX_VALUE+1);
        System.out.println(Integer.MAX_VALUE);
    }
}
