package com.leetcode.second.dailyc;

import java.util.HashSet;
import java.util.Set;

public class UglyNumber {
    static  Set<Integer> candidte = new HashSet();
    static{
        candidte.add(2);
        candidte.add(3);
        candidte.add(5);
    }
    public boolean isUgly(int n) {
        if (n <= 0) {
            return false;
        }

        for (int i : candidte) {

            n = divide(n , i);
        }
        return n==1;
    }

    private int divide(int candidate, int dividend) {
        while(candidate%dividend == 0) {
            candidate = candidate/dividend;

        }

        return candidate;
    }
}
