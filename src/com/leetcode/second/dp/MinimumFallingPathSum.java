package com.leetcode.second.dp;

import com.leetcode.second.window.MinimumSizeSubarraySum;

public class MinimumFallingPathSum {
    public int minFallingPathSum(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];


        for (int row = 0; row < dp.length; row++) {
            for (int column = 0; column < dp[0].length; column++) {
                if (row < 1) {
                    dp[row][column] = matrix[row][column];
                } else {
                    int top = dp[row - 1][column];

                    int smallest = top;

                    if (column > 0) {
//                        top left
                        smallest = Math.min(smallest, dp[row - 1][column - 1]);
                    }
                    if (column < dp[0].length - 1) {
//                        top right
                        smallest = Math.min(smallest, dp[row - 1][column + 1]);
                    }
                    dp[row][column] = smallest + matrix[row][column];
                }

            }
        }
        int result = Integer.MAX_VALUE;
        for (int column = 0; column < dp[0].length; column++) {
            result = Math.min(result, dp[dp.length - 1][column]);
        }
        return result;
    }

    public static void main(String[] args) {
        int i = new MinimumFallingPathSum().minFallingPathSum(new int[][]{
                new int[]{2, 1, 3},
                new int[]{6, 5, 4},
                new int[]{7, 8, 9},
        });
    }
}
