package com.leetcode.second.bits;

import java.util.Arrays;

public class MissingNumber {
    public int missingNumber(int[] nums) {
        int targetSum =( nums.length ) *(nums.length+1) /2;

        int currentSum = 0;
        for (int num : nums) {
            currentSum += num;
        }



        return targetSum - currentSum;



    }

    public static void main(String[] args) {
        int i = new MissingNumber().missingNumber(new int[]{3, 0, 1});
        System.out.println(i);
    }
}
