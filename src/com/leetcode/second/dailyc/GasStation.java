package com.leetcode.second.dailyc;

import java.util.Arrays;

public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if(Arrays.stream(gas).sum() < Arrays.stream(cost).sum()) {
            return -1;
        }
        int[] diff = new int[cost.length];
        for (int i = 0; i < gas.length; i++) {
            diff[i] = gas[i] - cost[i];
        }
        int total = 0;
        int start = 0;
        for (int i = 0; i < diff.length; i++) {

            int d = diff[i];
            total += d;
            if (total < 0) {
                total = 0;
                start = i +1;
            }
        }
        return start;
    }


    public static void main(String[] args) {
        int result = new GasStation().canCompleteCircuit(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2});
//        int result = new GasStation().canCompleteCircuit(new int[]{2,3,4}, new int[]{3,4,3});
        System.out.println(result);
    }
}
