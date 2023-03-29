package com.leetcode.second.dp;

// LC 647
public class PalindromicSubstrings {
    public int countSubstrings(String s) {
        char[] chars = s.toCharArray();
        boolean[][] dpTable = new boolean[chars.length][chars.length];
        int result = chars.length;
        if (chars.length <= 1) {
            return chars.length;
        }

        for (int i = 0; i < chars.length; i++) {
            dpTable[i][i] = true;
        }

        for (int i = 0; i < chars.length-1; i++) {
            dpTable[i][i+1] = chars[i] == chars[i+1];
            result += (dpTable[i][i + 1] ? 1 : 0);
        }

        for (int len = 3; len <= chars.length; len++) {
            for (int i = 0, j = i + len - 1; j < chars.length; i++, j++) {
                dpTable[i][j] = dpTable[i + 1][j - 1] && (chars[i] == chars[j]);
                result = result + (dpTable[i][j] ? 1 : 0);
            }
        }

        return result;

    }

    public static void main(String[] args) {
        int aba = new PalindromicSubstrings().countSubstrings("aba");
        System.out.println(aba);
    }
}
