package com.leetcode.second.array;

import java.util.*;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new LinkedList<>();
        int i = 0;
        while ( i < nums.length && nums[i]<= 0) {
//            for first number since it's sorted, it must be smaller than 0;

//            for next item, since we need dedupilicate it, simply check if the next one is same as this i

            if(i==0|| nums[i-1]!=nums[i]) {
                twoSum(nums, i , result);
            }

            i++;



        }

        return result;
    }

    private void twoSum(int[] nums, int i, List<List<Integer>> result) {

        Set<Integer> complements = new HashSet<>();

        for (int j = i+1; j < nums.length; j++) {
            if(complements.contains(-nums[i] - nums[j])) {
                result.add(Arrays.asList(nums[i], nums[j], -nums[i] - nums[j]));
                while (j+1 < nums.length && nums[j+1] ==nums[j]){
                    j++;
                }
            }
            complements.add(nums[j]);
        }

    }


}
