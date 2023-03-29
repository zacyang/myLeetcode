package com.leetcode.second.dp;

import static java.lang.Math.*;

public class BestTimeBuyandSellStockwithTransactionFee {
    public int maxProfit(int[] prices, int fee) {

        int[][] dbTable = new int[prices.length][2];

        dbTable[0][0] = 0;
        dbTable[0][1] = -prices[0] ;

        int result = Integer.MIN_VALUE;
        for (int date = 1; date < prices.length; date++) {
            dbTable[date][0] = max(dbTable[date - 1][0], dbTable[date - 1][1] + prices[date] - fee);
            dbTable[date][1] = max(dbTable[date - 1][0] - prices[date], dbTable[date - 1][1]);

            int todayMax = max(dbTable[date][0], dbTable[date][1]);

            result = max(result, todayMax);
        }

        return result;
    }

    public static void main(String[] args) {
        int i = new BestTimeBuyandSellStockwithTransactionFee().maxProfit(new int[]{1, 3, 2, 8, 4, 9}, 2);
        System.out.println(i);
    }
}
