package com.leetcode.second.dailyc;

import java.util.ArrayList;
import java.util.List;

public class AddArrayFormInteger {
    public List<Integer> addToArrayForm(int[] num, int k) {

        int intValue= toInt(num);
        return  toArray(intValue+k);
    }

    private List<Integer> toArray(int value) {
        String s = String.valueOf(value);
        int length = s.length();

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            result.add(Integer.valueOf(s.substring(i, i+1)));
        }
        return result;
    }

    private int toInt(int[] num) {
        int result = 0;
        for (int i = 0; i < num.length; i++) {
            result+=num[i] * 10 ^ num.length-1-i;
        }
        return result;
    }
}
