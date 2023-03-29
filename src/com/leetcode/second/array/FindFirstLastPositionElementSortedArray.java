package com.leetcode.second.array;

public class FindFirstLastPositionElementSortedArray {

    public int[] searchRange(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int middle = start + (end - start) / 2;

            if (nums[middle] > target) {
                end = middle - 1;
            }
            if (nums[middle] < target) {
                start = middle + 1;
            }

            if (nums[middle] == target) {
                int firstAppreanceIdx = middle;
                int lastAppreanceIdx = middle;

                while (firstAppreanceIdx > 1 && nums[firstAppreanceIdx-1] == target) {
                    firstAppreanceIdx--;
                }
                while (lastAppreanceIdx <= nums.length - 2 && nums[lastAppreanceIdx+1] == target) {
                    lastAppreanceIdx++;
                }
                return new int[]{firstAppreanceIdx, lastAppreanceIdx};
            }

        }
        return new int[]{-1, -1};
    }
}
