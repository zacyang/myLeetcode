package com.leetcode.second.dailyc;

import java.util.Arrays;

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int minDiffTotal = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length-2; i++) {

            int left = i+1;
            int right = nums.length - 1;

            int minDiff = Integer.MAX_VALUE;

            while (left < right) {
                int subSum =  nums[i] + nums[left] + nums[right];
                int diff = target - subSum;

                if(Math.abs(diff) < Math.abs(minDiff)) {
                    minDiff = diff;
                }

                if (diff > 0) {
                    left++;
                } else if (diff < 0) {
                    right--;
                } else {
                    minDiff = 0;
                    break;
                }
            }

            minDiffTotal = Math.abs(minDiff) <= Math.abs(minDiffTotal) ? minDiff : minDiffTotal;
        }
        return target - minDiffTotal;
    }

    public static void main(String[] args) {
        int i = new ThreeSumClosest().threeSumClosest(new int[]{4,0,5,-5,3,3,0,-4,-5}, -2);
        System.out.println(i);
    }
}
