package com.leetcode.second.dp;

public class BestTimeStockWithCooldown {
    public int maxProfit(int[] prices) {
        int[] sold = new int[prices.length+1];
        int[] held = new int[prices.length+1];
        int[] reset = new int[prices.length+1];


        sold[0] = Integer.MIN_VALUE;
        held[0] = Integer.MIN_VALUE;
        reset[0] = 0;
        for (int i = 1; i < prices.length +1; i++) {

            sold[i] =held[i-1] + prices[i-1];
            held[i] = Math.max(held[i-1],   reset[i-1] - prices[i-1]);
            reset[i] = Math.max(reset[i-1], sold[i-1]);
        }

        return Math.max(reset[prices.length-1], sold[prices.length-1]);
    }
//    public int maxProfit(int[] prices) {
////        inx  [ date] [stockStatus 0,  1] [tx status, 0 (no), 1 (sell )]
////
//        int[][][] dbTable = new int[prices.length][][];
//        dbTable[0] = new int[2][2];
//        dbTable[0][0][0] = 0;
//        dbTable[0][1][0] = -prices[0];
////        impossible case
//        dbTable[0][1][1] = Integer.MIN_VALUE;
//        dbTable[0][0][1] = Integer.MIN_VALUE;
//        int result = 0;
//
//        for (int date = 1; date < prices.length; date++) {
//
//            dbTable[date] = new int[2][2];
//            dbTable[date][1][0] = Integer.MIN_VALUE;
//            dbTable[date][0][1] = Integer.MIN_VALUE;
//            dbTable[date][1][1] = Integer.MIN_VALUE;
//            dbTable[date][0][0] = Integer.MIN_VALUE;
//
//
//            dbTable[date][0][0] = Math.max(dbTable[date - 1][0][0], dbTable[date - 1][0][1]);
//
//            dbTable[date][0][1] = Math.max(dbTable[date - 1][1][0], dbTable[date - 1][1][0] + prices[date]);
//
//            dbTable[date][1][0] = Math.max(dbTable[date - 1][1][0], dbTable[date - 1][0][0] - prices[date]);
//
////            dbTable[date][1][1] = dbTable[date - 1][0][0] - prices[date];
//
//            int todayMax = todayMax(dbTable[date]);
//            result = Math.max(result, todayMax);
//        }
//        return result;
//    }

    private int todayMax(int[][] ints) {
        int max = 0;
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints[i].length; j++) {
                max = Math.max(max, ints[i][j]);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int i = new BestTimeStockWithCooldown().maxProfit(new int[]{1, 2, 3, 0, 2});
        System.out.println(i);
    }
}
