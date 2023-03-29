package com.leetcode.second.binarysearch;

public class PeakIndexMountainArray {
    public int peakIndexInMountainArray(int[] arr) {
        int left = 0;
        int right = arr.length;

        while (left < right) {
            int peakInx = left + (right - left) / 2;

//            check the right side
            if (arr[peakInx + 1] >= arr[peakInx]) {
//                peak is on the right

                left = peakInx+1;
            } else {
                right = peakInx;
            }


        }
        return left;
    }

    public static void main(String[] args) {
        int i = new PeakIndexMountainArray().peakIndexInMountainArray(new int[]{
                0, 2, 1, 0
        });
        System.out.println(i);
    }
}
