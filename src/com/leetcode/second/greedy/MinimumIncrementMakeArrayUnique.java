package com.leetcode.second.greedy;

import java.util.Arrays;

public class MinimumIncrementMakeArrayUnique {
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);

        int moves = 0;

        for (int i = 0; i < nums.length-1; i++) {

            if(nums[i] == nums[i+1]) {

                nums[i+1] +=1;
                moves++;
            }

            if(nums[i+1] < nums[i]) {
                int move = nums[i] - nums[i + 1] + 1;
                nums[i+1] += move;
                moves+=move;
            }
        }

        return moves;

    }

    public static void main(String[] args) {
        int i = new MinimumIncrementMakeArrayUnique().minIncrementForUnique(new int[]{
                3, 2, 1, 2, 1, 7
        });

//        112237 =>
//        01014inf
//        =>
//
        System.out.println(i);
    }
}
