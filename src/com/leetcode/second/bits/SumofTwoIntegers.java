package com.leetcode.second.bits;

public class SumofTwoIntegers {
    public int getSum(int a, int b) {
//        get the last bit value 0 or 1 for both
        while (b != 0) {
            int tmp = (a & b) << 1;
            a = a ^ b;
            b = tmp;
        }
        return a;
    }
}
