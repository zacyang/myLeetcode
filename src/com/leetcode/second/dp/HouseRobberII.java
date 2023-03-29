package com.leetcode.second.dp;

import java.util.Arrays;

public class HouseRobberII {
    public int rob(int[] nums) {
        int length = nums.length;
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0], nums[1]);
        return Math.max(robHouse(nums, 0, length -1), robHouse(nums, 1, length));
    }

    public int robHouse(int[] nums, int start, int end) {
        int maxOneHouseBefore = 0, maxTwoHouseBefore = 0;
        for (int i = start; i < end; i++) {
            int currentMax = Math.max(maxOneHouseBefore, maxTwoHouseBefore + nums[i]);
            maxTwoHouseBefore = maxOneHouseBefore;
            maxOneHouseBefore= currentMax;
        }
        return maxOneHouseBefore;
    }

    public static void main(String[] args) {
        int rob = new HouseRobberII().rob(new int[]{1,2,3,1});
        System.out.println(rob);
    }
}
