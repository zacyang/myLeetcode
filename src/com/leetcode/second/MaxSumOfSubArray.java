package com.leetcode.second;

public class MaxSumOfSubArray {

    public int maxSubArray(int[] nums) {
        int bestSum = nums[0];
        int currentMax= nums[0];
        for (int i = 0; i < nums.length; i++) {


            currentMax = Math.max(nums[i], currentMax + nums[i]);
            bestSum = Math.max(currentMax, bestSum);
        }

        return bestSum;
    }
}
