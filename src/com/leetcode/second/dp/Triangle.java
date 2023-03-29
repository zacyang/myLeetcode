package com.leetcode.second.dp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//LC 120
public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {

        LinkedList<List<Integer>> result = new LinkedList<>();
        result.add(new LinkedList<>(triangle.get(triangle.size() - 1)));
        for (int i = triangle.size() - 2; i >= 0; i--) {
            List<Integer> integers = triangle.get(i);
            List<Integer> currentLayerMin = new ArrayList<>();
            for (int j = 0; j < integers.size(); j++) {

                int minValue = minPath(i, j, triangle, result);
                currentLayerMin.add(minValue);
            }

            result.add(currentLayerMin);

        }
//        result is reversed of original triage
        return result.get(result.size() - 1).get(0);
    }

    private int minPath(int i, int j, List<List<Integer>> triangle, LinkedList<List<Integer>> result) {
        Integer currentValue = triangle.get(i).get(j);
        Integer sameIdxNextRow = result.getLast().get(j);
        Integer nextIdxNextRow = result.getLast().get(j + 1);
        return Math.min(currentValue + sameIdxNextRow, currentValue + nextIdxNextRow);
    }

    public static void main(String[] args) {
        LinkedList<List<Integer>> triangle = new LinkedList<>();
        triangle.add(List.of(2));
        triangle.add(List.of(2,4));
        triangle.add(List.of(6,5,7));
        triangle.add(List.of(1,4,8,3));

        int i = new Triangle().minimumTotal(triangle);
        System.out.println(i);
    }
}
