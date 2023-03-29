package com.leetcode.second.array;

import java.util.*;

import static java.util.Comparator.*;

class IntegerToFrequency {
    public IntegerToFrequency(int value, int counter) {
        this.value = value;
        this.counter = counter;
    }

    int value;
    int counter;
}

public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {


        Map<Integer, Integer> register = new HashMap<>();

        for (int num : nums) {
            Integer value = register.getOrDefault(num, 0);
            register.put(num, value + 1);
        }

        List<Integer>[] counterArray = new List[nums.length + 1];


        register.keySet().forEach(ks -> {
            Integer count = register.get(ks);
            if (counterArray[count] == null) {
                ArrayList<Integer> integers = new ArrayList<>();
                integers.add(ks);
                counterArray[count] = integers;
            } else {
                counterArray[count].add(ks);
            }
        });

        int[] result = new int[k];
        for (int i = counterArray.length - 1; i > 0; i--) {
            List<Integer> integers = counterArray[i];
            if (integers == null) {
                continue;
            }
            for (Integer integer : integers) {
                k--;
                result[k] = integer;
                if (k == 0) {
                    return result;
                }

            }
        }
        return result;

    }

    public static void main(String[] args) {
//        int[] ints = new TopKFrequentElements().topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2);
        int[] ints = new TopKFrequentElements().topKFrequent(new int[]{1, 2}, 2);
//        new TopKFrequentElements().topKFrequent(new int[]{3,0,1,0
//
//        }, 1);
        System.out.println(ints);
    }
}
