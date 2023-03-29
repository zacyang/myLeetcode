package com.leetcode.second.dp;

import java.util.Arrays;
import java.util.Stack;

public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {

        int[] dp = new int[nums.length + 1];

//        at least 1
        Arrays.fill(dp, 1);
        int result = 1;

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if(nums[j] < nums[i]) {
//                    increasing detected
                    dp[i] = Math.max(dp[i], dp[j] +1);
                }

            }
            result = Math.max(result, dp[i]);
        }
        return result;
    }

    public static void main(String[] args) {
//        int i = new LongestIncreasingSubsequence().lengthOfLIS(new int[]{0, 1, 0, 3, 2, 3});
        int i = new LongestIncreasingSubsequence().lengthOfLIS(new int[]{1, 3, 6, 7, 9, 4, 10, 5, 6});
        System.out.println(i);
    }

}
