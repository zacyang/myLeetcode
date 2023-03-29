package com.leetcode.second.dailyc;

public class FlipStringMonotoneIncreasing {
    public int minFlipsMonoIncr(String s) {
        int n = s.length();
        int[][] dp = new int[n][2];
//0 = end with 0
//        1 = end with 1

        dp[0][0] = s.charAt(0) == '0'? 0: 1;
        dp[0][1] = s.charAt(0) == '1'? 0: 1;

        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '0') {
                dp[i][0] = dp[i-1][0];
                dp[i][1] =  Math.min(dp[i-1][0], dp[i-1][1])+1;
            } else {
                dp[i][1] = Math.min(dp[i-1][1], dp[i-1][0]);
                dp[i][0] =dp[i-1][0] +1;
            }
        }

        return Math.min(dp[n-1][0], dp[n-1][1]);
    }

    public static void main(String[] args) {
        int i = new FlipStringMonotoneIncreasing().minFlipsMonoIncr("010110");
        System.out.println(i);
    }
}
