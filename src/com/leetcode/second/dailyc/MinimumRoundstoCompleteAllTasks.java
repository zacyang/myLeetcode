package com.leetcode.second.dailyc;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class MinimumRoundstoCompleteAllTasks {
    public int minimumRounds(int[] tasks) {
//        diffculty -> task count
        Map<Integer, Integer> record = new HashMap<>();
        for (int task : tasks) {
            record.put(task, record.getOrDefault(task, 0) + 1);
        }

        Integer largestCount = record.values().stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()).get(0);

//        only need to figure out what the largest count's possible value
        int[] dp = new int[largestCount + 1];
        dp[0] = -1;

        if (dp.length >=2) {
            dp[1] = -1;
        }
        if (dp.length >=3) {
            dp[2] = 1;
        }
        if (dp.length >= 4) {
            dp[3] = 1;
        }


        for (int i = 4; i < dp.length; i++) {
//            dp[i] = Math.min(i - 2 + dp[i - 2], i - 3 + dp[i - 3]);
            if (dp[i - 2] == -1 && dp[i - 3] == -1) {
                dp[i] = -1;
            } else {
                if (dp[i - 2] == -1) {
                    dp[i] = 1 + dp[i - 3];
                } else if (dp[i - 3] == -1) {
                    dp[i] = 1 + dp[i - 2];
                } else {
                    dp[i] = Math.min(1 + dp[i - 2], 1 + dp[i - 3]);
                }

            }


        }
        int result = 0;
        for (Integer taskCount : record.values()) {
            if (dp[taskCount] != -1) {
                result += dp[taskCount];
            } else {
                return -1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int i = new MinimumRoundstoCompleteAllTasks().minimumRounds(new int[]{2, 3, 3});
        System.out.println(i);
    }
}
