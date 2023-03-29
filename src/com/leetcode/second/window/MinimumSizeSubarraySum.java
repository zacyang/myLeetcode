package com.leetcode.second.window;

public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int start = 0;
        int end = 0;
        int minLen = Integer.MAX_VALUE;
        int sum = 0;

        while (end < nums.length) {

            if (sum+ nums[end] < target) {
                sum += nums[end];
                end++;
            } else {
                minLen = Math.min(end - start +1, minLen);
                if(start>= end) {

                    end++;
                } else{
                    sum -= nums[start];
                    start++;
                }

            }
        }

        return minLen == Integer.MAX_VALUE? 0: minLen;
    }

    public static void main(String[] args) {
        int i = new MinimumSizeSubarraySum().minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3});
//        int i = new MinimumSizeSubarraySum().minSubArrayLen(4, new int[]{1,4,4});
//        int i = new MinimumSizeSubarraySum().minSubArrayLen(11, new int[]{1,1,1,1,1,1,1,1});
        System.out.println(i);
    }
}
