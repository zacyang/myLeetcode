package com.leetcode.second.array;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class TwoSumLessThanK {
    public int twoSumLessThanK(int[] nums, int k) {
        Map<Integer, Integer> register = new HashMap();
        int closestTarget = k;
        int max = -1;
        for (int num : nums) {
            Optional<Integer> biggest = register.keySet().stream().filter(key -> key <  num ).sorted(Comparator.reverseOrder()).findFirst();
            register.put( closestTarget-num,num);


            if(biggest.isPresent()) {
                max = Math.max(register.get(biggest.get())+num, max);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int i = new TwoSumLessThanK().twoSumLessThanK(new int[]{
                34, 23, 1, 24, 75, 33, 54, 8
        }, 60);
        System.out.println(i);
    }
}
