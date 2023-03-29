package com.leetcode.second.stackq;

import java.util.*;
import java.util.stream.Collectors;

public class BasicCalculatorII {
    public int calculate(String s) {

        char[] chars = s.toCharArray();
        int lastNum = 0;
        int num = 0;
        int result = 0;
        char ops = '+';
        for (int i = 0; i < chars.length; i++) {

            char currentCandidate = chars[i];

            if (Character.isDigit(currentCandidate)) {
                num = num * 10 + currentCandidate - '0';
            }

            if (!Character.isDigit(currentCandidate) && !Character.isSpaceChar(currentCandidate) || i == chars.length - 1) {

//                must be operations
                if (ops == '+') {
                    result+= lastNum;
                    lastNum = num;

                } else if (ops == '-') {
                    result += lastNum;
                    lastNum = -num;
                } else if (ops == '*') {
                    lastNum = lastNum * num;
                } else if (ops == '/') {
                    lastNum = lastNum / num;
                }

                ops = currentCandidate;
                num = 0;

            }

        }
        result += lastNum;

        return result;

    }

    public static void main(String[] args) {
        int result = new BasicCalculatorII().calculate("3+2*2");
        System.out.println(result);
    }
}
