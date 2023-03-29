package com.leetcode.second.array;

public class ValidPalindromeII {
    public boolean validPalindrome(String s) {
        char[] target = s.toCharArray();
        int start = 0;
        int end = target.length-1;
        while(start< end) {
            if(target[start]!=target[end]) {
                return (checkPalindrome(s, start+1, end) ||checkPalindrome(s, start, end-1));
            }
            start++;
            end --;
        }
        return true;
    }
//    public boolean validPalindrome(String s) {
//        int i = 0;
//        int j = s.length() - 1;
//
//        while (i < j) {
//            // Found a mismatched pair - try both deletions
//            if (s.charAt(i) != s.charAt(j)) {
//                return (checkPalindrome(s, i, j - 1) || checkPalindrome(s, i + 1, j));
//            }
//
//            i++;
//            j--;
//        }
//
//        return true;
//    }

    private boolean checkPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }

            i++;
            j--;
        }

        return true;
    }

    public static void main(String[] args) {
        new ValidPalindromeII().validPalindrome("abc");
    }
}
