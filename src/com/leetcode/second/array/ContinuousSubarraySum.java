package com.leetcode.second.array;

import java.util.HashMap;

public class ContinuousSubarraySum {
    public boolean checkSubarraySum(int[] nums, int k) {
//        sum mod to counter
        HashMap<Integer, Integer> cache = new HashMap<>();
        cache.put(0, 0);

        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (!cache.containsKey((sum) % k)) {
                cache.put(sum % k, i);
            } else if (cache.get(sum % k) < i) {
                return true;
            }

        }

        return false;
    }

    public static void main(String[] args) {
        boolean b = new ContinuousSubarraySum().checkSubarraySum(new int[]{5, 0, 0, 0}, 3);
        System.out.println(b);
    }
}
