package com.leetcode.second.dp;

import java.util.HashMap;
import java.util.Map;

public class MinimumCostForTickets {
    private Map<Integer, Integer> cache = new HashMap<>();
    private Map<Integer, Integer> passDayRego = new HashMap<>();

    {
        passDayRego.put(0, 1);
        passDayRego.put(1, 7);
        passDayRego.put(2, 30);
    }

    public int mincostTickets(int[] days, int[] costs) {


        int result = dp(0, days, costs);
        return result;

    }

    private int dp(int startingDayIdx, int[] days, int[] costs) {
        if (startingDayIdx >= days.length) {
            return 0;
        }

        if (cache.containsKey(startingDayIdx)) {
            return cache.get(startingDayIdx);
        } else {
            int result = Integer.MAX_VALUE;
            for (int costPickIdx = 0; costPickIdx < costs.length; costPickIdx++) {

                int newPickDayIdx = calculateNextUncoveredDayIdx(startingDayIdx, days, costPickIdx);

                int restPickcost = dp(newPickDayIdx, days, costs);
                result = Math.min(result, costs[costPickIdx] + restPickcost);
            }
            cache.put(startingDayIdx, result);
            return result;

        }
    }

    private int calculateNextUncoveredDayIdx(int startingDayIdx, int[] days, int passDaysIdx) {

        int coveredDateUntil = days[startingDayIdx] + passDayRego.get(passDaysIdx);
        int newPickDayIdx = startingDayIdx;
        for (int i = startingDayIdx; i < days.length; i++) {
            if (days[i] < coveredDateUntil) {
                newPickDayIdx = i;
            } else {
                break;
            }
        }
        return newPickDayIdx + 1;
    }

    public static void main(String[] args) {
        int i = new MinimumCostForTickets().mincostTickets(new int[]{1, 4, 6, 7, 8, 20}, new int[]{2, 7, 15});
        System.out.println(i);

    }
}
