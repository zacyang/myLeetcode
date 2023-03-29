package com.leetcode.second.array;

import java.util.HashMap;
import java.util.stream.Collectors;

public class SingleNumber {
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> seen = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            Integer orDefault = seen.getOrDefault(nums[i], 0);
            int newVal = orDefault + 1;
            seen.put(nums[i], newVal);
            if(newVal == 2) {
                seen.remove(nums[i]);
            }

        }

        return seen.keySet().stream().findFirst().orElseGet(() -> 0);
    }
}
