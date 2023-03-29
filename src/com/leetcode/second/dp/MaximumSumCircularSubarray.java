package com.leetcode.second.dp;

public class MaximumSumCircularSubarray {
    public int maxSubarraySumCircular(int[] nums) {

        int overmax = Integer.MIN_VALUE;
        int localMax = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
//            go left, find the left portion max


//            go right, find the righg portion of max


            localMax = 0;
        }
        for (int i = n-1; i >0; i++) {
//            go left, find the left portion max


//            go right, find the righg portion of max


            localMax = 0;
        }
        return overmax;
    }
}
