package com.leetcode.second.twopointer;

import java.util.Locale;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {


        char[] chars = s.toCharArray();
        StringBuilder validString = new StringBuilder();
        for (Character aChar : chars) {
            if (Character.isAlphabetic(aChar) ||  Character.isDigit(aChar)) {
                validString.append(aChar);
            }

        }
        String target = validString.toString().toUpperCase();
        int start= 0;
        int end = target.length()-1;
        while (start <= end) {

            if(target.charAt(start) != target.charAt(end)) {
                return false;
            }

            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        new ValidPalindrome().isPalindrome("0P");
    }
}
