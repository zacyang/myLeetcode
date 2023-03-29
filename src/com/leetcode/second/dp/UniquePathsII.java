package com.leetcode.second.dp;

public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];

        for (int row = 0; row < dp.length; row++) {
            for (int column = 0; column < dp[0].length; column++) {
                if (row == 0 && column == 0) {
                    if (obstacleGrid[row][column] != 1) {

                        dp[row][column] = 1;
                    }
                } else {

                    int up = 0;
                    if (row > 0 && obstacleGrid[row - 1][column] != 1) {
                        up = dp[row - 1][column];
                    }
                    int left = 0;
                    if (column > 0 && obstacleGrid[row][column - 1] != 1) {
                        left = dp[row][column - 1];
                    }

                    if (obstacleGrid[row][column] != 1) {
                        dp[row][column] = up + left;
                    }
                }


            }
        }
        return dp[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }

    public static void main(String[] args) {
        int i = new UniquePathsII().uniquePathsWithObstacles(new int[][]{new int[]{
                0, 0
        }});
    }
}
