package com.leetcode.second.twopointer;

import com.leetcode.second.graph.NumberOfIslands;

import java.util.Arrays;

public class NumberSubbsequencesSatisfyCondition {
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int res = 0, n = nums.length, l = 0, r = n - 1, mod = (int) 1e9 + 7;
        int[] pows = new int[n];
        pows[0] = 1;
        for (int i = 1; i < n; ++i)
            pows[i] = pows[i - 1] * 2 % mod;
        while (l <= r) {
            if (nums[l] + nums[r] > target) {
                r--;
            } else {
                res = (res + pows[r - l++]) % mod;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int i = new NumberSubbsequencesSatisfyCondition().numSubseq(new int[]{3, 3, 6, 8}, 10);
        System.out.println(i);
    }
}
