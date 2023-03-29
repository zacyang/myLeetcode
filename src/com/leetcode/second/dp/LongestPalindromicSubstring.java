package com.leetcode.second.dp;

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        int N = chars.length+1;
        String maxLenPanSubStr = "";

        boolean[][] dpTable = new boolean[N ][N ];

// one char itself is palindromic sub str
        for (int i = 0; i < N-1; i++) {
            dpTable[i][i] = true;
            maxLenPanSubStr = s.substring(i);
        }

// adjacent two chars
        for (int i = 1; i < N-1; i++) {
            boolean isPalindrom = chars[i - 1]== chars[i];
            dpTable[i - 1][i] = isPalindrom;
            if(isPalindrom) {
                maxLenPanSubStr = s.substring(i-1, i+1);
            }

        }

//        build dp table by looking at 3 chars
        for (int examLen = 2; examLen < N; examLen++) {

            for (int i = 0;  i< N -1 -examLen; i++) {
                boolean isPalindrom = chars[i] == chars[i + examLen] && dpTable[i + 1][i + examLen - 1];
                dpTable[i][i + examLen] = isPalindrom;
                if (isPalindrom) {
// TODO:                    could stop this loop goto next i++
                    maxLenPanSubStr = maxLenPanSubStr.length() > examLen+1? maxLenPanSubStr: s.substring(i, i+examLen+1);
                }

            }

        }
        return maxLenPanSubStr;

    }

    public static void main(String[] args) {
        String result = new LongestPalindromicSubstring().longestPalindrome("a");
        System.out.println(result);
    }
}
