package com.leetcode.second.dp;

import java.util.Arrays;

public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()+1][text2.length()+1];

        char[] targe1 = text1.toCharArray();
        char[] targe2 = text2.toCharArray();


        for (int row = targe1.length-1; row >=0; row--) {
            for (int column = targe2.length-1; column >=0; column--) {
                if(targe1[row] == targe2[column]) {
                    dp[row] [column] = dp[row +1][column+1] +1;

                } else {
                    dp[row][column] = Math.max(dp[row ][column+1], dp[row +1][column] );
                }
            }
        }
        return dp[0][0];

    }


    private int findCharLocation(char charAt, String biggerStr) {
        return biggerStr.indexOf(charAt);
    }

    public static void main(String[] args) {
        int result = new LongestCommonSubsequence().longestCommonSubsequence("dbcd", "abc");
        System.out.println(result);
    }
}
