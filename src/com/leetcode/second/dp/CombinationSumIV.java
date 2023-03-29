package com.leetcode.second.dp;

import com.leetcode.second.backtracking.CombinationSumII;

import java.util.HashMap;
import java.util.Map;

public class CombinationSumIV {
    private Map<Integer, Integer> cache  = new HashMap<>();
    public int combinationSum4(int[] nums, int target) {
        if(cache.containsKey(target)) {
            return cache.get(target);
        } else  {
            int result = 0;

            if (target < 0) {
                return result;
            }


            for (int num : nums) {
                if (target - num == 0) {
                    result++;
                } else {
                    result += combinationSum4(nums, target - num);
                }
            }

            cache.put(target, result);

            return result;
        }

    }

    public static void main(String[] args) {
        int i = new CombinationSumIV().combinationSum4(new int[]{9}, 4);
        System.out.println(i);
    }
}
