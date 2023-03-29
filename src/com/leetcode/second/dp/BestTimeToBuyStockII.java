package com.leetcode.second.dp;

import static java.lang.Math.*;

public class BestTimeToBuyStockII {
    public int maxProfit(int[] prices) {
//        dp table 1 idx corresponds to date, 2nd idx indicates stock holding states (0,1)
        int[][] dpTable = new int[prices.length][2];

        dpTable[0][0] = 0;
        dpTable[0][1] = -prices[0];
        int result = 0;

        for (int date = 1; date < prices.length; date++) {
//            do not sell nor buy
            dpTable[date][0] = max(dpTable[date - 1][0], dpTable[date - 1][1] + prices[date]);
            dpTable[date][1] = max(dpTable[date - 1][0] - prices[date], dpTable[date - 1][1]);

            int todayMax = max( dpTable[date][0],  dpTable[date][1]);
            result = max(todayMax, result);

        }
        return result;
    }
}
