package com.leetcode.second.dp;

import java.nio.charset.IllegalCharsetNameException;

public class BestTimeToBuyAndSellStockIV {
    public int maxProfit(int k, int[] prices) {

//        day, state (hold, sold) , number of transactions
//        1 = hold
//        0 = sold
        int[][][] dp = new int[prices.length][2][k + 1];

        for (int i = 0; i < prices.length; i++) {
            for (int j = 0; j <= k; j++) {
                dp[i][0][i] = -1000000000;
                dp[i][1][i] = -1000000000;
            }
        }

        dp[0][0][0] = 0;
        dp[0][1][1] = -prices[0];

        for (int i = 1; i < dp.length; i++) {

//            find the previous max profile within k range
            for (int transactionNumber = 0; transactionNumber + 1 <= k + 1; transactionNumber++) {


                dp[i][0][transactionNumber] = Math.max(dp[i - 1][0][transactionNumber], dp[i - 1][1][transactionNumber] + prices[i]);
                //                sold
//                getting from previous hold + price[today] and shift to right (k+1)

                if (transactionNumber > 0) {
                    dp[i][1][transactionNumber] = Math.max(dp[i - 1][1][transactionNumber], dp[i - 1][0][transactionNumber] - prices[i]);
                }


            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < dp[prices.length - 1].length; i++) {
            for (int i1 = 0; i1 <= k + 1; i1++) {
                max = Math.max(max, Math.max(dp[prices.length - 1][1][i], dp[prices.length - 1][0][i]));
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int i = new BestTimeToBuyAndSellStockIV().maxProfit(2, new int[]{2, 4, 1});
        System.out.println(i);
    }
}
