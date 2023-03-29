package com.leetcode.second.array;

import java.util.*;

public class FindAllNumbersDisappearedArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int num : nums) {
            if(nums[Math.abs(num)] > 0) {
                nums[num] *=-1;
            }
        }
        List<Integer> result = new ArrayList<>();
//        find the negative
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] > 0 ) {
                result.add(i+1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new FindAllNumbersDisappearedArray().findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1}));
    }
}
