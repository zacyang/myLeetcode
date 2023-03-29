package com.leetcode.second.dp;

class StockStatus {
    int currentMax;
    double numberOfTx;

    public StockStatus(int currentMax, double numberOfTx) {
        this.currentMax = currentMax;
        this.numberOfTx = numberOfTx;
    }
}

//LC 188
public class BestTimeBuyandSellStockHard {
    public int maxProfit(int k, int[] prices) {
//        date , own stock?, number of tx
        StockStatus[][] dpTable = new StockStatus[prices.length][2];

        dpTable[0][0] = new StockStatus(0, 0);
        dpTable[0][1] = new StockStatus(prices[0], 0.5);



        return 0;
    }
}
