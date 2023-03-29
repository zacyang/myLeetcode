package com.leetcode.second.array;

public class GreatestCommonDivisorofStrings {
    public String gcdOfStrings(String str1, String str2) {
        int min = Math.min(str1.length(), str2.length());

        String maxString = "";
        for (int i = 0; i < min; i++) {
            String substring = str1.substring(0, i);
            String result1 = str1.replace(substring, "");
            String result2 = str2.replace(substring, "");
            if (result1.isEmpty() && result2.isEmpty()) {
                if (maxString.length() < substring.length()) {
                    maxString = substring;
                }
            }


        }


        return maxString;
    }
}
