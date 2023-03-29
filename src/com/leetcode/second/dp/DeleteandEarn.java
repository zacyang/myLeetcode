package com.leetcode.second.dp;

import java.util.HashMap;

public class DeleteandEarn {
    public int deleteAndEarn(int[] nums) {
        HashMap<Integer, Integer> points = new HashMap<>();
        int maxNum = 0;
        for (int num : nums) {
            Integer pointWhenThisNumTaken = points.getOrDefault(num, 0);
            points.put(num, pointWhenThisNumTaken + num);

            maxNum = Math.max(maxNum, num);
        }


        int[] dp = new int[maxNum + 1];

        //base case 0, if only 0 then gain is also 0, if anything > 0 , then for sure gain more to choose non-zeror that is 1
        dp[1] = points.getOrDefault(1, 0);

        for (int i = 2; i < dp.length; i++) {

            dp[i] = Math.max(dp[i - 2] + points.getOrDefault(i, 0), dp[i - 1]);


        }
        return dp[maxNum];

    }
}
