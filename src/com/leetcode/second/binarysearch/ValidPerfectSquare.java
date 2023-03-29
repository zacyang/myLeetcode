package com.leetcode.second.binarysearch;

public class ValidPerfectSquare {
    public boolean isPerfectSquare(int num) {
        if (num < 2) {
            return true;
        }

        long left = 2;
        long right = num / 2;
        while (left <= right) {
            long middle = left + (right - left) / 2;

            long middlePow = middle * middle;
            if (middlePow == num) {
                return true;
            }

            if (middlePow < num) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }


        }
        return false;
    }
    public boolean isPerfectSquare1(int num) {
        if (num < 2) {
            return true;
        }

        long left = 2, right = num / 2, x, guessSquared;
        while (left <= right) {
            x = left + (right - left) / 2;
            guessSquared = x * x;
            if (guessSquared == num) {
                return true;
            }
            if (guessSquared > num) {
                right = x - 1;
            } else {
                left = x + 1;
            }
        }
        return false;
    }
}
