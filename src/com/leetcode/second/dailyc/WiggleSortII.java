package com.leetcode.second.dailyc;

import java.util.Arrays;

public class WiggleSortII {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);

        int left = 0;
        int end = nums.length-1;


        int[] result = new int[nums.length];
        for (int i = 0; i < result.length; i+=3) {

            result[i]= nums[left];
            result[i+1]= nums[end];
            int middle = (left+ end)/2;
            result[i+2]=nums[middle];
            left++;
            end--;
        }
        for (int i = 0; i < result.length; i++) {
            nums[i] = result[i];
        }
    }
}
