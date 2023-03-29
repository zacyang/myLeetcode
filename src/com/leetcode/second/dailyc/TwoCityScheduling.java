package com.leetcode.second.dailyc;

import java.util.Arrays;
import java.util.Comparator;

public class TwoCityScheduling {
    int minCost = Integer.MAX_VALUE;
    private int balanceLimit;

    public int twoCitySchedCost(int[][] costs) {
//        back tracking, keep a balance b , it can not excced n/2, on both ends
        Arrays.sort(costs, (o1, o2) -> o1[0]-o2[0] - (o1[1]-o2[1]));

        int sum = 0;
        int n = costs.length / 2;
        for (int i = 0; i < n; i++) {
             sum+=costs[i][0]+costs[i+n][1];
        }
        return sum;
    }

    private void explore(int[][] costs, int currentIdx, int currentCost, int currentBalance) {

        if(currentIdx==costs.length) {
            minCost = Math.min(minCost, currentCost);
            return;
        }

        for (int i = 0; i < costs[currentIdx].length; i++) {

            if(i==0 && currentBalance > -balanceLimit) {
                explore(costs, currentIdx+1, currentCost+costs[currentIdx][0], currentBalance-1);
            }
            if(i==1 && currentBalance < balanceLimit) {
                explore(costs, currentIdx+1, currentCost+costs[currentIdx][1], currentBalance+1);
            }
        }


    }


}
