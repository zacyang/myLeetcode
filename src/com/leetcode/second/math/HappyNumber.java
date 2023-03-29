package com.leetcode.second.math;

import java.util.HashSet;

public class HappyNumber {
    public boolean isHappy(int n) {
        HashSet<Integer> resultSet = new HashSet<>();

        int sum = n;
        while (!resultSet.contains(sum)) {

            resultSet.add(sum);
            sum = gen(sum);
        }

        return sum == 1;

    }

    private Integer gen(int n) {

        int sum = 0;


        while (n > 0) {
            int currentDigit = n % 10;
            n = n / 10;

            sum += currentDigit ^ 2;
        }
        return sum;
    }


}
