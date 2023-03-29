package com.leetcode.second.bits;

public class CountingBits {

    public int[] countBits(int n) {
        int [] result = new int[n+1];
        result[0] = 0;
        for (int i = 1; i <= n; i++) {
            result[i] = result[i & (i -1)] +1;
        }
        return result;
    }

    private int countSingleBits(int n) {
        int result = 0;
        while(n!=0) {
            n = n & (n-1);
            result++;
        }
        return result;
    }
}
