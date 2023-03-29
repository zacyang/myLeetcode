package com.leetcode.second.bits;

public class ReverseBits {
    public int reverseBits(int n) {
        int result = 0;
        int power = 31;
        while(n !=0) {
            result += (n & 1) << power;
            power--;

            n= n >>>1;
        }

        return 0;
    }
}
