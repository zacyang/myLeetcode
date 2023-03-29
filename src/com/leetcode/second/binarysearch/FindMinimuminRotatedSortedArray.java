package com.leetcode.second.binarysearch;

public class FindMinimuminRotatedSortedArray {
    public int findMin(int[] nums) {
        int start = 0 ;
        int end = nums.length - 1;

        int pivot = 0;
        while(start<end) {
            int middle =( start + end) /2;

            if( nums[middle] > nums[middle+1]) {
                pivot = middle+1;
                break;
            }

            if(start == end-1 && nums[start] < nums[end]) {
                pivot = 0;
                break;
            }

            if(nums[start] > nums[middle]) {
//                pivot in left
                end = middle ;
            } else {
                start = middle ;
            }


        }
        return nums[pivot];
    }

    public static void main(String[] args) {
        int min = new FindMinimuminRotatedSortedArray().findMin(new int[]{
                3,4,5,1,2
        });
        System.out.println(min);

    }
}
