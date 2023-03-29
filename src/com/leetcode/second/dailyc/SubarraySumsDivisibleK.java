package com.leetcode.second.dailyc;

public class SubarraySumsDivisibleK {
    public int subarraysDivByK(int[] nums, int k) {
        int[] modgroup = new int[k];

        modgroup[0] = 1;
        int prefixMod = 0;
        int result = 0;
        for (int num : nums) {
            prefixMod = (prefixMod + num % k + k) % k;
            result += modgroup[prefixMod];
            modgroup[prefixMod]++;
        }
        return result;

    }

    public static void main(String[] args) {
        int i = new SubarraySumsDivisibleK().subarraysDivByK(new int[]{4, 5, 0, -2, -3, 1}, 5);
        System.out.println(i);
    }
}
