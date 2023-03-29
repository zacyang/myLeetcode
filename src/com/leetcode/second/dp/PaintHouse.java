package com.leetcode.second.dp;

public class PaintHouse {
    public int minCost(int[][] costs) {
       int[][] dp = new int[costs.length][costs[0].length];


        for (int houseIdx = 0; houseIdx < dp.length; houseIdx++) {
            for (int colorIdx = 0; colorIdx < dp[0].length; colorIdx++) {
                if(houseIdx ==0) {
                    dp[houseIdx][colorIdx] = costs[houseIdx][colorIdx];

                } else {
                    dp[houseIdx][colorIdx] = getMinOtherThanThisColor(dp[houseIdx-1], colorIdx) + costs[houseIdx][colorIdx];
                }
            }
        }

        return getMinOtherThanThisColor(dp[dp.length-1], -1);
    }

    private int getMinOtherThanThisColor(int[] ints, int colorIdx) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < ints.length; i++) {
            if(i==colorIdx) {
                continue;
            }

            min = Math.min(ints[i], min);
        }
        return min;
    }

    private int minof(int[] sum) {
        int min = Integer.MAX_VALUE;
        for (int i : sum) {
            min = Math.min(min, i);
        }
        return min;
    }

    private int minLastRowExceptColumn(int[][] dp, int currentRow, int currentCol) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < dp[currentRow - 1].length; i++) {
            if (currentCol == i) {
                continue;
            }
            min = Math.min(dp[currentRow - 1][i], min);
        }
        return min;
    }

    public static void main(String[] args) {
        int i = new PaintHouse().minCost(new int[][]{
                new int[]{17, 2, 17},
                new int[]{16, 16, 5},
                new int[]{14, 3, 19},
        });

//        int i = new PaintHouse().minCost(new int[][]{
//                new int[]{7,6,2},
//
//        });
        System.out.println(i);
    }

}
