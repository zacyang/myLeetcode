package com.leetcode.second.binarysearch;

public class BinarySearch {
    public int search(int[] nums, int target) {
        if(nums.length==0 || nums ==null) {
            return -1;
        }

        int start=0;
        int end = nums.length-1;

        while(start <= end) {
            int middle = (start+end)/2;
            if(target == nums[middle]) {
                return middle;
            }

            if(target > nums[middle]) {
                start = middle+1;
            } else {
                end = middle -1;
            }
        }
        return -1;
    }
}
