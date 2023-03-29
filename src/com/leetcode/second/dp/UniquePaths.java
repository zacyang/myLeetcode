package com.leetcode.second.dp;

import java.util.Arrays;

public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        dp[0][0] = 1;

        for (int row = 0; row < dp.length; row++) {
            for (int column = 0; column < dp[0].length; column++) {
                if(row==0 && column==0) {
                    continue;
                }
                int up = 0;
                if (row > 0) {
                    up = dp[row - 1][column];
                }

                int left = 0;
                if (column > 0) {
                    left = dp[row][column - 1];
                }

                dp[row][column] = up + left;
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int i = new UniquePaths().uniquePaths(3, 7);
        System.out.println(i);
    }
}
