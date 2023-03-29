package com.leetcode.second.array;

import com.leetcode.second.linkedlist.MergeKSortedLists;

public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int nums1Idx = m - 1;
        int nums2Idx = n - 1;
        for (int i = nums1.length - 1; i >= 0; i--) {

            if (nums1Idx >= 0 ) {
                if (nums1[nums1Idx] >= nums2[nums2Idx]) {
                    nums1[i] = nums1[nums1Idx];
                    nums1Idx--;
                } else {
                    nums1[i] = nums2[nums2Idx];
                    nums2Idx--;
                }

            } else {
                if(nums1Idx <0 ) {
                    nums1[i] = nums2[nums2Idx];
                    nums2Idx--;
                } else {
                    nums1[i] = nums1[nums1Idx];
                    nums1Idx--;
                }
            }

        }
    }

    public static void main(String[] args) {
        new MergeSortedArray().merge(new int[]{0}, 0, new int[]{1}, 1);
    }
}
