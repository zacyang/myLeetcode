package com.leetcode.second.window;

import java.util.Arrays;
import java.util.Comparator;

public class FrequencyoftheMostFrequentElement {
    public int maxFrequency(int[] nums, int k) {
        int res = 1, start = 0, end = 0;
        long sum = 0;
        Arrays.sort(nums);
        while (end < nums.length) {
            sum += nums[end];
            while (sum + k < (long) nums[end] * (end - start + 1)) {
                sum -= nums[start];
                start += 1;
            }
            res = Math.max(res, end - start + 1);
            end++;
        }

        return res;
    }

    public static void main(String[] args) {
        int i = new FrequencyoftheMostFrequentElement().maxFrequency(new int[]{9940, 9995, 9944, 9937, 9941, 9952, 9907, 9952, 9987, 9964, 9940, 9914, 9941, 9933, 9912, 9934, 9980, 9907, 9980, 9944, 9910, 9997}, 7925);
        System.out.println(i);
    }
}
