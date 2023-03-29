package com.leetcode.second.twopointer;

import java.util.Arrays;

public class MinDiffOfKScores {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int[] result = new int[nums.length -k+1];

        for (int i = 0; i < nums.length-k+1; i++) {
            result[i] = nums[i+k-1] - nums[i];
        }

        Arrays.sort(result);
        return result[0];
    }

    public static void main(String[] args) {
        int i = new MinDiffOfKScores().minimumDifference(new int[]{9, 4, 1, 7}, 2);
        System.out.println(i);
    }
}
