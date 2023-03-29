package com.leetcode.second.dp;

public class PerfectSquares {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;

//        precaculate all perfect sqt

        int maxSqrtLen = (int) Math.sqrt(n) + 1;
        int[] perfectSqrt = new int[maxSqrtLen];
        for (int i = 1; i < maxSqrtLen; i++) {
            perfectSqrt[i] = i * i;
        }

        for (int i = 1; i < dp.length; i++) {
            int numOfMinCombo = Integer.MAX_VALUE;
            for (int j = 1;  j < maxSqrtLen && perfectSqrt[j] <= i; j++) {
                numOfMinCombo = Math.min(numOfMinCombo, dp[i - perfectSqrt[j]] + 1);
            }dp[i] = numOfMinCombo;

        }
        return dp[n];
    }

    public static void main(String[] args) {
        new PerfectSquares().numSquares(12);
    }
}
