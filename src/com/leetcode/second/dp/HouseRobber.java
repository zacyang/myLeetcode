package com.leetcode.second.dp;

import java.util.Arrays;

public class HouseRobber {
    private int[] mem;

    public int rob(int[] nums) {
        mem = new int[100];
        Arrays.fill(mem, -1);


        return this.robFrom(0, nums);

    }

    private int robFrom(int i, int[] nums) {
        if (i >= nums.length) {
            return 0;
        }

        if (mem[i] != -1) {
            return mem[i];
        }
        int max = Math.max(this.robFrom(i + 2, nums) + nums[i], this.robFrom(nums[i + 1], nums));
        mem[i] = max;
        return max;
    }


}

//1. find the patten where the optimal result is the optimalFunction(subResult)
//2. lodge the result into dp table, for simplicity create a N+1 length arrays, as the last elment in the original list needs the botton case (0)
//3. reversely loop thru the dp table
//DP approach
class HouseRobber2 {

    public int rob(int[] nums) {
        int N = nums.length;
        int[] dpTable = new int[N + 1];
        Arrays.fill(dpTable, 0);


        if (N == 0) {
            return 0;
        }

        dpTable[N] = 0;
        dpTable[N - 1] = nums[N - 1];

        for (int i = N - 2; i >= 0; i--) {
            dpTable[i] = Math.max(dpTable[i + 2] + nums[i], dpTable[i + 1]);
        }

        return dpTable[0];

    }
}
