package com.leetcode.second.math;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        boolean carry = false;

        Stack<Integer> result = new Stack<>();
        for (int i = digits.length-1; i >= 0; i--) {
            int currentDigit = 0;
            if(i==digits.length-1 ) {
                currentDigit= digits[i] + 1;
            } else {
                currentDigit = carry? digits[i] +1:digits[i];
            }
            carry = currentDigit/10 >0;

            currentDigit = currentDigit%10;
            result.push(currentDigit);

        }
        if(carry) {
            result.push(1);
        }

        int[] ints = new int[result.size()];

        for (int i = 0; i < ints.length; i++) {
            ints[i] = result.pop();
        }

        return ints;
    }

    public static void main(String[] args) {
        int[] x = new PlusOne().plusOne(new int[]{9});
        for (int i : x) {
            System.out.println(i);
        }

    }
}
