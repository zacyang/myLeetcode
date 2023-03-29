package com.leetcode.second.dailyc;

import java.util.HashMap;
import java.util.Map;

public class FindOriginalArrayFromDoubledArray {
    public int[] findOriginalArray(int[] changed) {
        if (changed.length % 2 == 1) {
            return new int[0];
        }
        Map<Integer, Integer> register = new HashMap<>();
        for (int i : changed) {
            Integer value = register.getOrDefault(i, 0);
            register.put(i, value + 1);
        }

        int[] original = new int[changed.length / 2];
        int index = 0;
        for (int num : changed) {
            if (register.get(num) > 0) {
                register.put(num, register.get(num) - 1);
                int twiceNum = num * 2;
                if (register.containsKey(twiceNum) && register.get(twiceNum) > 0) {
                    // Pair up the elements, decrement the count
                    register.put(twiceNum, register.get(twiceNum) - 1);
                    // Add the original number to answer
                    original[index++] = num;
                } else {
                    return new int[0];
                }
            }

        }
        return original;
    }
}
