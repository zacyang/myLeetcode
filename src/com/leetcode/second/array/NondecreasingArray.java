package com.leetcode.second.array;

public class NondecreasingArray {
    public boolean checkPossibility(int[] nums) {
        boolean changed= false;

        for (int i = 0; i < nums.length-1; i++) {
//            valid case
            if(nums[i] <= nums[i+1] ) {
                continue;
            }
            if(changed) {
                return false;
            }


            if(i==0 || nums[i+1] >= nums[i-1]) {
                nums[i] = nums[i+1];
            } else {
                nums[i+1] = nums[i];
            }
            changed = true;
        }
        return true;
    }

    public static void main(String[] args) {
//        boolean b = new NondecreasingArray().checkPossibility(new int[]{4, 2, 1});
        boolean b = new NondecreasingArray().checkPossibility(new int[]{5, 7, 1, 8});
        System.out.println(b);

    }
}
