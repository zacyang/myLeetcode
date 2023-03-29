package com.leetcode.second.dp;

import java.util.HashMap;
import java.util.Map;

class CacheKey1 {
    int startingIdx;
    int reminingDays;

    public CacheKey1(int startingIdx, int reminingDays) {
        this.startingIdx = startingIdx;
        this.reminingDays = reminingDays;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CacheKey1)) return false;

        CacheKey1 cacheKey1 = (CacheKey1) o;

        if (startingIdx != cacheKey1.startingIdx) return false;
        return reminingDays == cacheKey1.reminingDays;
    }

    @Override
    public int hashCode() {
        int result = startingIdx;
        result = 31 * result + reminingDays;
        return result;
    }
}

public class MinimumDifficultyJobSchedule {
    private Map<CacheKey1, Integer> cache = new HashMap();

    public int minDifficulty(int[] jobDifficulty, int d) {


        int start = 0;
        int reminingDays = d;
        int i = calculateMinDiffSum(start, jobDifficulty, reminingDays);
        return i == Integer.MAX_VALUE ? -1 : i;

    }

    private int calculateMinDiffSum(int startingTaskIdx, int[] jobDifficulty, int reminingDays) {
        int min = Integer.MAX_VALUE;
        CacheKey1 cacheKey = new CacheKey1(startingTaskIdx, reminingDays);
        if (this.cache.containsKey(cacheKey)) {
            return this.cache.get(cacheKey);
        } else {
            if (reminingDays == 1) {
//            get the harest in the reminding tasks

                int maxDiff = -1;
                for (int i = startingTaskIdx; i < jobDifficulty.length; i++) {
                    maxDiff = Math.max(maxDiff, jobDifficulty[i]);
                }


                cache.put(cacheKey, maxDiff);
                return maxDiff;

            }

            // at least one task for today, at leave enough( len - reminingDays-1)
            for (int numberOfTaskPicked = 1; numberOfTaskPicked <= jobDifficulty.length - startingTaskIdx - (reminingDays - 1); numberOfTaskPicked++) {
                int maxDiffToday = -1;
                for (int i = startingTaskIdx; i < startingTaskIdx + numberOfTaskPicked; i++) {
                    maxDiffToday = Math.max(maxDiffToday, jobDifficulty[i]);
                }

                int result = maxDiffToday + calculateMinDiffSum(startingTaskIdx + numberOfTaskPicked, jobDifficulty, reminingDays - 1);
                min = Math.min(min, result);
                cache.put(cacheKey, min);
            }
        }

        return min;
    }


    public static void main(String[] args) {
//        int i = new MinimumDifficultyJobSchedule().minDifficulty(new int[]{6, 5, 4, 3, 2, 1}, 2);
//        int i = new MinimumDifficultyJobSchedule().minDifficulty(new int[]{9,9,9}, 4);
        int i = new MinimumDifficultyJobSchedule().minDifficulty(new int[]{7, 1, 7, 1, 7, 1}, 3);
        System.out.println(i);
    }

}
