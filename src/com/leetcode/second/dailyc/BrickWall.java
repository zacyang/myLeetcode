package com.leetcode.second.dailyc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BrickWall {
    public int leastBricks(List<List<Integer>> wall) {
//        get the prefix sum
//        find the most common prefix sum
//        result  = listsize - numberOf(most common prefix sum)

        Map<Integer, Integer> prefixSumRegister = new HashMap<>();
        for (int i = 0; i < wall.size(); i++) {

            int currentSum = 0;

            for (int j = 1; j < wall.get(i).size(); j++) {
                currentSum += wall.get(i).get(j - 1);

                prefixSumRegister.compute(currentSum, (k, v) -> prefixSumRegister.getOrDefault(k, 0) + 1);
            }

        }
        if(prefixSumRegister.isEmpty()) {
            return wall.size();
        }
        Integer mostCommon = prefixSumRegister.values().stream().sorted((o1, o2) -> o2 - o1).collect(Collectors.toList()).get(0);
        return wall.size() - mostCommon;

    }

    public static void main(String[] args) {
        List<List<Integer>> l = new ArrayList<>();
        l.add(List.of(1));
        l.add(List.of(1));
        l.add(List.of(1));

//        List<List<Integer>> l = new ArrayList<>();
//        l.add(List.of(1,2,2,1));
//        l.add(List.of(3,1,2));
//        l.add(List.of(1,3,2));
//        l.add(List.of(2,4));
//        l.add(List.of(3,1,2));
//        l.add(List.of(1,3,1,1));
        int i = new BrickWall().leastBricks(l);
        System.out.println(i);

    }

}
