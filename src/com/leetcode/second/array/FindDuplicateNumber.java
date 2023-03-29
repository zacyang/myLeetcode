package com.leetcode.second.array;

public class FindDuplicateNumber {
    public int findDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int abs = Math.abs(nums[i]);
            if(nums[abs]<0){
                nums[i] = abs;
                return abs;
            }
            nums[abs] =nums[abs]* -1;
        }
        return 0;
    }

}
