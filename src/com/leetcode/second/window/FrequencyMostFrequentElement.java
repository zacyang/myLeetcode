package com.leetcode.second.window;

import java.util.Arrays;

public class FrequencyMostFrequentElement {
//    public int maxFrequency(int[] nums, int k) {
//        Arrays.sort(nums);
//
//        int maxFreq = 1;
//        for (int i = nums.length - 1; i >= 0; i--) {
//            int max = maxPossibleFreqForPivot(i, nums, k);
//            maxFreq = Math.max(max, maxFreq);
//        }
//        return maxFreq;
//    }
//
//    private int maxPossibleFreqForPivot(int pivotIdx, int[] nums, int k) {
//        int reminder = k;
//        int result = 1;
//        for (int i = pivotIdx-1; i >= 0; i--) {
//            reminder = reminder - (nums[pivotIdx] - nums[i]);
//
//            if (reminder >= 0) {
//                result++;
//            } else {
//                return result;
//            }
//        }
//
//        return result;
//
//    }

    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);

        int maxFreq = 1;

        int windowStart = nums.length - 1;
        int windowEnd = nums.length - 1;

        int reminder = k;
        int currentResult = 0;
        while (windowStart >= 0) {

            reminder = reminder - (nums[windowEnd] - nums[windowStart]);
            currentResult = windowEnd - windowStart;
            if(reminder >= 0) {
                currentResult++;
            }
            maxFreq = Math.max(maxFreq, currentResult);
            if (reminder <= 0) {
                reminder += (nums[windowEnd] - nums[windowEnd - 1]) * (windowEnd - windowStart);
                windowEnd--;
                currentResult--;
            } else {
                windowStart--;
            }

        }

        return maxFreq;
    }

    public static void main(String[] args) {
        int i = new FrequencyMostFrequentElement().maxFrequency(new int[]{9940,9995,9944,9937,9941,9952,9907,9952,9987,9964,9940,9914,9941,9933,9912,9934,9980,9907,9980,9944,9910,9997}, 7925);
        System.out.println(i);
    }
}
