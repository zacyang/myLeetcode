package com.leetcode.second.binarysearch;

public class SearchinRotatedSortedArray {
    public int search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;

        while (start <= end) {
        int middle = (start + end) / 2;
            if (target == nums[middle]) {
                return middle;
            }

            if (nums[middle] >= nums[start]) {
                if (target >= nums[start] && target < nums[middle]) {
                    end = middle - 1;
                } else {
                    start = middle + 1;

                }
            } else {
                if (target <= nums[end] && target > nums[middle]) {
                    start = middle + 1;
                } else {
                    end                            = middle - 1;
                }
            }

        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new SearchinRotatedSortedArray().search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
    }
}
