package com.leetcode.second.array;

import java.util.Arrays;

public class FindNumberswithEvenNumberofDigits {
    public int findNumbers(int[] nums) {
        int counter = 0;
        for (int num : nums) {
            if(String.valueOf(num).length() % 2 == 0) {
                counter++;
            }
        }
        return counter;
    }
}
