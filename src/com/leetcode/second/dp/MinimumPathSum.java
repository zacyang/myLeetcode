package com.leetcode.second.dp;

public class MinimumPathSum {
    public int minPathSum(int[][] grid) {

        int dp[][] = new int[grid.length][grid[0].length];


        for (int row = 0; row < dp.length; row++) {
            for (int column = 0; column < dp[0].length; column++) {


                int current = grid[row][column];
                dp[row][column] = current;
                if (row - 1 >= 0 && column - 1 >= 0) {
                    dp[row][column] = Math.min(current + dp[row - 1][column], current + dp[row][column - 1]);
                } else {
                    if (row == 0 && column == 0) {
                        dp[row][column] = grid[row][column];
                    }

                    if (row >= 1) {
                        dp[row][column] = current + dp[row - 1][column];
                    }

                    if (column >= 1) {
                        dp[row][column] = current + dp[row][column - 1];
                    }
                }

            }
        }
        return dp[grid.length - 1][grid[0].length - 1];
    }

    public static void main(String[] args) {
        int i = new MinimumPathSum().minPathSum(new int[][]{new int[]{1, 3, 1}, new int[]{1, 5, 1}, new int[]{4, 2, 1},});
        System.out.println(i);
    }
}
