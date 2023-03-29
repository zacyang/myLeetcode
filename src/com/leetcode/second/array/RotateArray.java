package com.leetcode.second.array;

public class RotateArray {
    public void rotate(int[] nums, int k) {
        int length = nums.length;
        k = k % length;
        swap(nums, 0, length-1);
        swap(nums, 0, k-1);
        swap(nums,  k, length-1);
    }

    private void swap(int[] nums, int start, int end) {
        while(start< end
        ) {
            int tmep = nums[start];
            nums[start] =nums[end];
            nums[end] = tmep;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        new RotateArray().rotate(nums, 3);
        for (int num : nums) {
            System.out.println(num);

        }
//        new RotateArray().rotate(new int[]{-1,-100,3,99}, 2);
    }
}
