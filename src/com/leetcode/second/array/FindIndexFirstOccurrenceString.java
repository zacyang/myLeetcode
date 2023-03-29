package com.leetcode.second.array;

public class FindIndexFirstOccurrenceString {
    public int strStr(String haystack, String needle) {
        char[] hayArray = haystack.toCharArray();

        for (int i = 0; i <= hayArray.length- needle.length(); i++) {

            if (isNeedle(haystack, i, needle)) {
                return i;
            }
        }

        return -1;
    }

    private boolean isNeedle(String heystack, int i, String needle) {
        return heystack.substring(i, i + needle.length()).equals(needle);

    }

    public static void main(String[] args) {
        int i = new FindIndexFirstOccurrenceString().strStr("sadbutsad", "sad");
        System.out.println(i);
    }
}
