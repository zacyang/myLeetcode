package com.leetcode.second.dp;

public class InterleavingString {

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        dp[s1.length()][s2.length()] = true;

        for (int s1idx = dp.length - 1; s1idx >= 0; s1idx--) {
            for (int s2idx = dp.length - 1; s2idx >= 0; s2idx--) {

                if (s1idx< s1.length() && s3.charAt(s1idx + s2idx) == s1.charAt(s1idx) && dp[s1idx + 1][s2idx]) {
                    dp[s1idx][s2idx] = true;
                }

                if (s2idx <s2.length() && s3.charAt(s1idx + s2idx) == s2.charAt(s2idx) && dp[s1idx][s2idx + 1]) {
                    dp[s1idx][s2idx] = true;
                }
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        System.out.println(new InterleavingString().isInterleave("aabcc", "dbbca", "aadbbcbcac"));

    }
}
