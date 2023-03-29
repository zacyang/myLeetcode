package com.leetcode.second.array;

import java.util.HashMap;

public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> sumToFreq = new HashMap<>();
        int currentSum = 0;
        int result = 0;
        sumToFreq.put(0, 1);
        for (int num : nums) {

            currentSum += num;

            if (sumToFreq.containsKey(currentSum - k)) {
                result += sumToFreq.get(currentSum - k);
            }

            Integer freq = sumToFreq.getOrDefault(currentSum, 0);
            sumToFreq.put(currentSum, freq + 1);

        }

        return result;
    }

    public static void main(String[] args) {
        int i = new SubarraySumEqualsK().subarraySum(new int[]{1, -1, 0}, 0);
        System.out.println(i);
    }
}
