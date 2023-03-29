package com.leetcode.second.dp;

import java.util.HashMap;
import java.util.Map;

public class IntegerBreak {
    private Map<Integer, Integer> cache = new HashMap<>();
    public int integerBreak(int n) {

        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }

        return calculateMaxOf(n);
    }

    private int calculateMaxOf(int target) {
        if(cache.containsKey(target)) {
            return cache.get(target);
        } else {
            if (target == 2) {
                return 1;
            }


            int max = target;
            for (int i = 1; i <= target; i++) {
                max = Math.max(i * calculateMaxOf(target - i), max);
            }
            cache.put(target, max);
            return max;
        }

    }

    public static void main(String[] args) {
        int i = new IntegerBreak().integerBreak(10);
        System.out.println(i);
    }

}
