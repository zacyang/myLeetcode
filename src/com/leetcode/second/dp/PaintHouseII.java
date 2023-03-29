package com.leetcode.second.dp;

public class PaintHouseII {
    public int minCostII(int[][] costs) {
        int[][] dp = new int[costs.length][costs[0].length];

        for (int houseIdx = 0; houseIdx < dp.length; houseIdx++) {
            for (int costIdx = 0; costIdx < costs[houseIdx].length; costIdx++) {
                if (houseIdx == 0) {
                    dp[houseIdx][costIdx] = costs[houseIdx][costIdx];
                } else {
                    int minCostOtherThanSameColor = minCostOtherThanSameColor(costIdx, dp[houseIdx - 1]);
                    dp[houseIdx][costIdx] = costs[houseIdx][costIdx] + minCostOtherThanSameColor;
                }

            }

        }

        return minCostOtherThanSameColor(-1, dp[dp.length - 1]);
    }

    private int minCostOtherThanSameColor(int costIdx, int[] costs) {
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < costs.length; i++) {
            if (i == costIdx) {
                continue;
            }
            min = Math.min(costs[i], min);
        }
        return min;
    }
}
