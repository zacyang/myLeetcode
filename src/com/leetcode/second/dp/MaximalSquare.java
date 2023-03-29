package com.leetcode.second.dp;

public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
//        check each point, calculate the square size based on it as top left pivot point
        int dp[][] = new int[matrix.length][matrix[0].length];

        int maxSize = 0;
        for (int row = 0; row < dp.length; row++) {
            dp[row][dp[0].length - 1] = matrix[row][dp[0].length - 1]-'0';
            maxSize =Math.max(maxSize,   dp[row][dp[0].length - 1] );
        }
        for (int c = 0; c < dp[0].length; c++) {
            dp[dp.length - 1][c] = matrix[dp.length - 1][c] - '0';
            maxSize =Math.max(maxSize,    dp[dp.length - 1][c]);
        }



        for (int row = dp.length - 2; row >= 0; row--) {
            for (int column = dp[0].length - 2; column >= 0; column--) {
//                no need to calculate right most and botton as it is the current value


                if (matrix[row ][column] == '1') {
//                    could be a new square
//                    check if the row and column can match
                    int minSquare = Math.min(Math.min(dp[row + 1][column], dp[row][column + 1]), dp[row + 1][column + 1]);
                    dp[row][column] = minSquare+1;
                    maxSize =Math.max(maxSize, dp[row][column]);

                }  else {
                    dp[row][column] = matrix[row][column] - '0';
                }
            }
        }
        return maxSize * maxSize;
    }

    public static void main(String[] args) {
        int i = new MaximalSquare().maximalSquare(new char[][]{

                new char[]{'1', '0', '1', '0', '0'},
                new char[]{'1', '0', '1', '1', '1'},
                new char[]{'1', '1', '1', '1', '1'},
                new char[]{'1', '0', '0', '1', '0'}
        });
        System.out.println(i);
    }

}
