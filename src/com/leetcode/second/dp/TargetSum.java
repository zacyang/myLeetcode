package com.leetcode.second.dp;

import java.util.HashMap;
import java.util.Map;

class TargetSumCache {
    int index;
    int target;

    public TargetSumCache(int index, int target) {
        this.index = index;
        this.target = target;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TargetSumCache)) return false;

        TargetSumCache that = (TargetSumCache) o;

        if (index != that.index) return false;
        return target == that.target;
    }

    @Override
    public int hashCode() {
        int result = index;
        result = 31 * result + target;
        return result;
    }
}

public class TargetSum {
    private Map<TargetSumCache, Integer> cache = new HashMap<>();

    public int findTargetSumWays(int[] nums, int target) {
        return numberOfWays(nums.length - 1, nums, target);
    }

    private int numberOfWays(int i, int[] nums, int target) {
        TargetSumCache cacheKey = new TargetSumCache(i, target);
        if (this.cache.containsKey(cacheKey)) {
            return this.cache.get(cacheKey);
        } else {
            if (i == 0) {
                int result = 0;

                if (nums[i] == target) {
                    result++;
                }
                if (-nums[i] == target) {
                    result++;
                }
                return result;
            }

            int current = nums[i];
            int reminderIfAdd = target - current;
            int reminderIfSubtract = target + current;

            int result = numberOfWays(i - 1, nums, reminderIfAdd) + numberOfWays(i - 1, nums, reminderIfSubtract);
            this.cache.put(cacheKey, result);
            return result;
        }


    }

    public static void main(String[] args) {
//        int targetSumWays = new TargetSum().findTargetSumWays(new int[]{2,1,1,1}, 3);
        int targetSumWays = new TargetSum().findTargetSumWays(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 1}, 1);
        System.out.println(targetSumWays);
    }
}
