package com.leetcode.second.bits;

public class NumberofBits {
    public int hammingWeight(int n) {

        int numerOfBits=  0;
        while(n!=0){
            n = n & (n-1);
            numerOfBits++;
        }
        return numerOfBits;
    }
}
