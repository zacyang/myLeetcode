package com.leetcode.second.array;

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int idx = 0;
        int moveForwardIdx = 0;
        while(moveForwardIdx< nums.length) {

            if(nums[moveForwardIdx]!=val) {
                nums[idx] = nums[moveForwardIdx];
                idx++;
            }

            moveForwardIdx ++;
        }
        return idx;
    }

    public static void main(String[] args) {
        int i = new RemoveElement().removeElement(new int[]{3, 2, 2, 3,2,5}, 5);
        System.out.println(i);
    }
}
