package com.leetcode.second.array;

public class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int currentMax = 0;
        for (int num : nums) {
            if (num == 1) {
                currentMax++;
            } else {
                max = Math.max(max, currentMax);
                currentMax = 0;
            }
        }
        return max;
    }
}
