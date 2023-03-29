package com.leetcode.second.dp;

import java.util.HashMap;
import java.util.Map;

class CacheKey{
    int start;
    int end;
    int i;

    public CacheKey(int start, int end, int i) {
        this.start = start;
        this.end = end;
        this.i = i;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CacheKey)) return false;

        CacheKey cacheKey = (CacheKey) o;

        if (start != cacheKey.start) return false;
        if (end != cacheKey.end) return false;
        return i == cacheKey.i;
    }

    @Override
    public int hashCode() {
        int result = start;
        result = 31 * result + end;
        result = 31 * result + i;
        return result;
    }
}
public class MaxScoreMuliplication {

    private Map<CacheKey, Integer> cache = new HashMap();
    public int maximumScore(int[] nums, int[] multipliers) {


        int start = 0;
        int end = nums.length - 1;
        int i = 0;
        int currentResult = 0;
        int max = calculateMaxScore(currentResult, start, end, nums, multipliers, i);
        return max;
    }

    private int calculateMaxScore(int currentSum, int start, int end, int[] nums, int[] multipliers, int i) {
        CacheKey key = new CacheKey(start, end, i);
        if(cache.containsKey(key)) {
            return cache.get(key);

        }else {
            if (i == multipliers.length) {
                return currentSum;

            }
//        pick start
            int pickStart = nums[start] * multipliers[i] + calculateMaxScore(currentSum , start + 1, end, nums, multipliers, i + 1);
            int pickEnd = nums[end] * multipliers[i] + calculateMaxScore(currentSum , start, end - 1, nums, multipliers, i + 1);

            int result =  Math.max(pickStart, pickEnd);
            cache.put(key, result);
            return result;
        }

    }

    public static void main(String[] args) {
        int i = new MaxScoreMuliplication().maximumScore(new int[]{1, 2, 3}, new int[]{3, 2, 1});
        System.out.println(i);
    }
}
