package com.leetcode.second.dp;

public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {


        if (cost.length == 0) {

            return 0;
        }
        if (cost.length == 1) {

            return cost[0];
        }

        int one = 0;
        int two = 0;


        for (int i = 2; i < cost.length+1; i++) {
            int fromOne = one + cost[i - 1];
            int fromTwo = two + cost[i - 2];


//            moved to next
            two = one;
            one = Math.min(fromOne, fromTwo);
        }

        return one;

    }

    public static void main(String[] args) {
        int i = new MinCostClimbingStairs().minCostClimbingStairs(new int[]{
                10, 15, 20
        });
        System.out.println(i);
    }
}
