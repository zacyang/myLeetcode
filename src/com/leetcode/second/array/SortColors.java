package com.leetcode.second.array;

import java.util.HashMap;

public class SortColors {
    public void sortColors(int[] nums) {
        HashMap<Integer, Integer> integerIntegerHashMap = new HashMap<>();
        for (int num : nums) {
            Integer orDefault = integerIntegerHashMap.getOrDefault(num, 0);
            integerIntegerHashMap.put(num, orDefault + 1);
        }


        int[] target = {0, 1, 2};
        int processedIdx = 0;
        for (int color : target) {
            Integer numberOfColor = integerIntegerHashMap.getOrDefault(color, 0);
            while (processedIdx < nums.length && numberOfColor > 0) {
                nums[processedIdx] = color;
                numberOfColor--;
                processedIdx++;
            }
        }

    }

    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
        new SortColors().sortColors(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
