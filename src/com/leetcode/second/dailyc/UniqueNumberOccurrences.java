package com.leetcode.second.dailyc;

import java.util.HashMap;
import java.util.stream.Collectors;

public class UniqueNumberOccurrences {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> integerIntegerHashMap = new HashMap<>();

        for (int i : arr) {
            Integer orDefault = integerIntegerHashMap.getOrDefault(i, 0);
            integerIntegerHashMap.put(i, orDefault+1);
        }


        return integerIntegerHashMap.values().stream().collect(Collectors.toSet()).size() == integerIntegerHashMap.keySet().size();
    }

    public static void main(String[] args) {
        boolean b = new UniqueNumberOccurrences().uniqueOccurrences(new int[]{1, 2, 2, 1, 1, 3});
        System.out.println(b);
    }

}
