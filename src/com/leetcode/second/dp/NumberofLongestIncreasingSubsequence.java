package com.leetcode.second.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Collectors;

public class NumberofLongestIncreasingSubsequence {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length, res = 0, max_len = 0;
        int[] len = new int[n];
        int[] cnt = new int[n];
        for (int i = 0; i < n; i++) {
            len[i] = cnt[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
//                    is increasing , check the count
//                 the same len has seen before in j, so get the sum
                    if (len[i] == len[j] + 1) cnt[i] += cnt[j];
//                    then the len[i] +1 is the new longest, since it's new the count will be reset to the cnt[j]
                    if (len[i] < len[j] + 1) {
                        len[i] = len[j] + 1;
                        cnt[i] = cnt[j];
                    }
                }
            }


            if (max_len == len[i]) res += cnt[i];
            if (max_len < len[i]) {
                max_len = len[i];
                res = cnt[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
//        bug: if one point can be reached thru multiple path, then the counter would ended up with less than actual
//        solution: record the number of max path as separated dp array.
        int numberOfLIS = new NumberofLongestIncreasingSubsequence().findNumberOfLIS(new int[]{1, 3, 5, 4, 7});
//        int numberOfLIS = new NumberofLongestIncreasingSubsequence().findNumberOfLIS(new int[]{2, 2, 2, 2, 2});
//        int numberOfLIS = new NumberofLongestIncreasingSubsequence().findNumberOfLIS(new int[]{1, 2, 4, 3, 5, 4, 7, 2});
        System.out.println(numberOfLIS);
    }
}
