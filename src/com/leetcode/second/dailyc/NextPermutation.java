package com.leetcode.second.dailyc;

import java.util.Arrays;

public class NextPermutation {

    public void nextPermutation(int[] nums) {


//        from the end find the next smaller integer and closer (higher prio)to the current idx, so that when swap the whole nums became lexicon larger


        boolean swapped = false;
        for (int i = nums.length - 1; i >= 0; i--) {

            int currentExamingNumer = nums[i];

            int closestSmallerPosition = -1;
            for (int j = i; j >= 0; j--) {
                if (nums[j] < currentExamingNumer) {
                    closestSmallerPosition = Math.max(j, closestSmallerPosition);
                }
            }
            if (closestSmallerPosition == -1) {
//                move to next
            } else {
//                swap
                int tmp = nums[closestSmallerPosition];
                nums[closestSmallerPosition] = currentExamingNumer;
                nums[i] = tmp;
                swapped = true;
                break;
            }

        }
        if(!swapped) {
            Arrays.sort(nums);
        }

    }

    public static void main(String[] args) {
        new NextPermutation().nextPermutation(new int[]{1, 2, 3});
    }
}
