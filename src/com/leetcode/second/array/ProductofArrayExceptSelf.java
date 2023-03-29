package com.leetcode.second.array;

import java.util.Arrays;
import java.util.function.IntBinaryOperator;

public class ProductofArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        int[] leftProduct = new int[nums.length];
        leftProduct[0] = 1;
        int[] rightProduct = new int[nums.length];
        rightProduct[nums.length - 1] = 1;


        for (int i = 1; i < nums.length; i++) {
            leftProduct[i] = leftProduct[i - 1] * nums[i - 1];
        }

        for (int i = nums.length - 2; i >= 0; i--) {
            rightProduct[i] = rightProduct[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < nums.length; i++) {
            ans[i] = leftProduct[i] * rightProduct[i];
        }

        return ans;

    }

}
