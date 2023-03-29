package com.leetcode.second.dp;

public class PaintFence {
    public int numWays(int n, int k) {
//        int dp[] = new int[n + 1];

        if(n == 0) {
            return 0;
        }
        if(n == 1) {
            return k;
        }
        if(n == 2) {
            return k* k;
        }

//        dp[0] = 0;
//        dp[1] = k;
//        dp[2] = k * k;
        int twoPostPrevSum = k;
        int previousPostSum = k*k;
        int result=0;
        for (int i = 3; i <= n; i++) {
            int differentColor = previousPostSum * (k - 1);
//            same color will be dp[i-1] <-> dp[i-2] differnt color, as that is gurentee no more than 3
            int sameColor = twoPostPrevSum * (k - 1);

            twoPostPrevSum = previousPostSum;
            previousPostSum = differentColor + sameColor;
            result =  previousPostSum;
        }
        return result;
    }

    public static void main(String[] args) {
        int i = new PaintFence().numWays(3, 2);
        System.out.println(i);
    }
}
