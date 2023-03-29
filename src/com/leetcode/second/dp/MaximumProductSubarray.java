package com.leetcode.second.dp;

import java.util.LinkedList;

import static java.lang.Math.max;


class MaxProductValueHolderNode {
    int maxSoFar;
    int minSoFar;

    public MaxProductValueHolderNode(int maxPositiveValue, int negativeProtentialValue) {
        this.maxSoFar = maxPositiveValue;
        this.minSoFar = negativeProtentialValue;
    }
}

public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int N = nums.length;
        LinkedList<MaxProductValueHolderNode> dbTable = new LinkedList<>();
        dbTable.add(new MaxProductValueHolderNode(nums[0], nums[0]));
        int result = 0;
// from back to the original inx 0

        for (int i = 1; i < N; i++) {
            int candidate = nums[i];
            MaxProductValueHolderNode last = dbTable.getLast();
            int max = Math.max(max(last.maxSoFar * candidate, candidate), candidate * last.minSoFar);
            int min = Math.min(Math.min(last.maxSoFar * candidate, candidate), candidate * last.minSoFar);
            result = max(max, result);
            dbTable.add(new MaxProductValueHolderNode(max, min));
        }
        return result;
    }

    public static void main(String[] args) {
        int result = new MaximumProductSubarray().maxProduct(new int[]{2, 3, -2, 4});
        System.out.println(result);
    }
}
