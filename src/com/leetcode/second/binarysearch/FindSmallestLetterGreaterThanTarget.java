package com.leetcode.second.binarysearch;

public class FindSmallestLetterGreaterThanTarget {
    public char nextGreatestLetter(char[] letters, char target) {
        int right = letters.length - 1;
        int left = 0;

        return search(letters, target, left, right);
    }

    private char search(char[] letters, char target, int left, int right) {

        while (left < right) {
            int middle = left + (right - left) / 2;
            if (letters[middle] > target) {
                right = middle;
            } else {
                left = middle + 1;
            }


        }
        return letters[left];
    }
}
