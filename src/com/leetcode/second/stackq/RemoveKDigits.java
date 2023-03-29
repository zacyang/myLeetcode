package com.leetcode.second.stackq;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Stream;

public class RemoveKDigits {
    public String removeKdigits(String num, int k) {
        int start = 0;
        int end = num.length() - k;

        String result = "";
        char[] chars = num.toCharArray();
        while (start <= end) {

            int currentSmall = chars[start];
            for (int i = start; i < end; i++) {
                if (chars[i] < currentSmall) {
                    currentSmall = chars[i];
                    start = i;
                }
            }

            result += chars[start];

            // only move the end if not reach the end of the str
            start++;
            if (end < num.length() - 1) {
                end++;
            }


        }

        return result;
    }

    public static void main(String[] args) {
        String s = new RemoveKDigits().removeKdigits("425", 1);
        System.out.println(s);
    }
}
