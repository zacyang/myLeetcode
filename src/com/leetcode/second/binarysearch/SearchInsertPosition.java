package com.leetcode.second.binarysearch;

public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {

        int start = 0;
        int end = nums.length - 1;

        int pivit = 0;
        while (start < end) {
            pivit = (start + end) / 2;


            if (nums[pivit] < target) {
                start = pivit + 1;
            } else if (nums[pivit] > target) {
                end = pivit - 1;
            } else {
                return pivit;
            }

        }
        return start;

    }
}
