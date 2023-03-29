package com.leetcode.second.array;

public class FindPivotIndex {
    public int pivotIndex(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        int leftSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (leftSum == sum - leftSum - nums[i]) {
                return i;
            }

            leftSum += nums[i];

        }
        return -1;
    }
}
