package com.leetcode.second.array;

public class SingleElementSortedArray {
    public int singleNonDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {

            int middle = (left + right) / 2;


            if (nums[middle] == nums[middle - 1]) {
                if ((middle + 1 - left) % 2 == 1) {
                    right = middle - 2;
                } else {
                    left = middle + 1;
                }
            } else if (nums[middle] == nums[middle + 1]) {
                if ((right + 1 - middle) % 2 == 1) {
                    left = middle + 2;
                } else {
                    right = middle - 1;
                }
            } else {
                return nums[middle];
            }

        }

        return nums[right];
    }

    public static void main(String[] args) {
        int i = new SingleElementSortedArray().singleNonDuplicate(new int[]{
                1, 1, 2, 3, 3, 4, 4, 8, 8
        });

//        int i = new SingleElementSortedArray().singleNonDuplicate(new int[]{
//                1,1,2,2,3
//        });
        System.out.println(i);
    }
}
