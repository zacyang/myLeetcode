package com.leetcode.second;

import java.util.HashMap;

public class TwoSums {
//    brutal force n!
//    public int[] twoSum(int[] nums, int target) {
//        for (int i = 0; i < nums.length; i++) {
//            int reminder = target - nums[i];
//            for (int j = i; j < nums.length; j++) {
//                if(reminder == nums[j]) {
//                    return new int[]{i,j};
//                }
//            }
//        }
//        return new int[]{};
//    }

//corresponded index  2N
//    public int[] twoSum(int[] nums, int target) {
////        reminder value to correspond index
//        HashMap<Integer, Integer> register = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            register.put(target - nums[i], i);
//        }
//
//        for (int i = 0; i < nums.length; i++) {
//            Integer correspondedIndex = register.get(target-nums[i]);
//            if(correspondedIndex !=null && correspondedIndex!=i) {
//                return new int[]{i, correspondedIndex};
//            }
//        }
//        return new int[]{};
//    }

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> register = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(register.containsKey(nums[i]) ) {
                return new int[]{i, register.get(nums[i])};
            }
            register.put(target - nums[i], i);
        }

        return null;

    }
}
