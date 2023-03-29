package com.leetcode.second.dp;


import java.util.Stack;

public class MaximumSubarrayMinProduct {


    public int maxSumMinProduct(int[] nums) {
        int max = Integer.MIN_VALUE;

        int[] sum = new int[nums.length + 1];
        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }

        Stack<int[]> monoStack = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            int minFromLeftIdx = i;
            while (!monoStack.isEmpty() && monoStack.peek()[1] > nums[i]) {
                int[] pop = monoStack.pop();
                int minProduct = (pop[1] * (sum[i] - sum[pop[0]]));

                max = Math.max(max, minProduct) % 1000_000_007;
                minFromLeftIdx = pop[0];
            }
            monoStack.push(new int[]{minFromLeftIdx, nums[i]});
        }

        while (!monoStack.isEmpty()) {
            int[] pop = monoStack.pop();
            int minProduct = pop[1] * (sum[sum.length - 1] - sum[pop[0]]);
            max = Math.max(minProduct,max) % 1000_000_007;
        }
        return max;
    }


    public static void main(String[] args) {
        int i = new MaximumSubarrayMinProduct().maxSumMinProduct(new int[]{2, 3, 3, 1, 2});
        System.out.println(i);
    }
}
