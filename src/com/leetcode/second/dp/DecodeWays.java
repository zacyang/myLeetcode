package com.leetcode.second.dp;

//LC 91
public class DecodeWays {
    public int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];
        dp[0] = 0;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;

        for (int i = 2; i < dp.length; i++) {

            if (s.charAt(i) != '0') {
                dp[i] += dp[i - 1];
            }

            int twoDigit = Integer.valueOf(s.substring(i - 2, i));
            boolean isTwoDigitls = twoDigit >= 10 && twoDigit <= 26;

            if (isTwoDigitls) {
                dp[i] += dp[i - 2];
            }

        }

        return dp[s.length()];
    }

    private boolean checkCombo(String s) {
//        return true if only first is valid, false if 2 digits are valid
        int twoDigit = Integer.valueOf(s);
        return twoDigit >= 10 && twoDigit <= 26;
    }

    private boolean isAlphaBeltical(String s, int start, int end) {
        int twoDigit = Integer.valueOf(s.substring(start, end));
        return twoDigit >= 10 && twoDigit <= 26;
//        return chars[start] == '1' || chars[start] == '2' && (chars[end] >= '0' && chars[end] <= '9')
    }

    public static void main(String[] args) {
        System.out.println(new DecodeWays().numDecodings("12"));

    }
}
