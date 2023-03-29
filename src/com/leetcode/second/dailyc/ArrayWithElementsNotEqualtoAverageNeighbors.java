package com.leetcode.second.dailyc;

import java.util.Arrays;
import java.util.List;

public class ArrayWithElementsNotEqualtoAverageNeighbors {
    List<Integer> result;

    public int[] rearrangeArray(int[] nums) {

        Arrays.sort(nums);
        int[] result = new int[nums.length];


        int start = 0;
        int end = nums.length - 1;
        int i =0;
        while (start <= end) {
            result[i] = nums[start];
            start++;
           if(i== nums.length-1){
               break;
           }
            result[i + 1] = nums[end];
            end--;
            i+=2;
        }

        return result;
    }


    public static void main(String[] args) {
        int[] ints = new ArrayWithElementsNotEqualtoAverageNeighbors().rearrangeArray(new int[]{1, 2, 3, 4, 5});
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}
