package com.leetcode.second.dp;

public class MaximumLengthofRepeatedSubarray {
    public int findLength(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length][nums2.length];

//        init the edge
        int max = Integer.MIN_VALUE;
        for (int num1idx = dp.length-1; num1idx >=0; num1idx--) {
            for (int num2idx =  dp[0].length-1; num2idx >=0; num2idx--) {
                if (num1idx == dp.length - 1 || num2idx == dp[0].length - 1) {
                    dp[num1idx][num2idx] = nums1[num1idx] == nums2[num2idx] ? 1 : 0;
                } else {
                    dp[num1idx][num2idx] = nums1[num1idx] == nums2[num2idx] ? dp[num1idx + 1][num2idx + 1] + 1 : 0;
                }

                max = Math.max(max,  dp[num1idx][num2idx] );

            }
        }


        return max;
    }

    public static void main(String[] args) {
        int length = new MaximumLengthofRepeatedSubarray().findLength(
                new int[]{1, 2, 3, 2, 1},
                new int[]{3, 2, 1, 4, 7}
        );
        System.out.println(length);
    }

}
