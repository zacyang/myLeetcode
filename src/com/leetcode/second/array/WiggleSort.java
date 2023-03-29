package com.leetcode.second.array;

import java.util.Arrays;
import java.util.LinkedList;

public class WiggleSort {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);

//        greedy pick in order

        LinkedList<Integer> list = new LinkedList<>();
        for (int num : nums) {
            list.push(num);
        }

        int[] result = new int[nums.length];

        int counter = 0;
        for (int i = 0; i < result.length; i++) {
            if (counter % 2 == 1) {
//                pick from the end
                result[i] = list.pollFirst();
            } else {

            result[i] = list.pollLast();
            }
            counter++;
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = result[i];
        }
    }

    public static void main(String[] args) {
        int[] nums = {3, 5, 2, 1, 6, 4};
        new WiggleSort().wiggleSort(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
