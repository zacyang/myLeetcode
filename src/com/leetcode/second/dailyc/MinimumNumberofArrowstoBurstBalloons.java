package com.leetcode.second.dailyc;

import com.leetcode.second.array.MinimumNumberofSwapstoMakeTheStringBalanced;

import java.util.*;
import java.util.stream.Collectors;

public class MinimumNumberofArrowstoBurstBalloons {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (o1, o2) -> {
            if (o1[1] == o2[1]) return 0;
            if (o1[1] < o2[1]) return -1;
            return 1;
        });

        int end = points[0][1];

        int result = 1;

        for (int i = 0; i < points.length; i++) {

            if (end < points[i][0]) {
                result++;
                end = points[i][1];
            }
        }
        return result;

    }

    public static void main(String[] args) {
        int minArrowShots = new MinimumNumberofArrowstoBurstBalloons().findMinArrowShots(new int[][]{
                new int[]{10, 16},
                new int[]{2, 8},
                new int[]{1, 6},
                new int[]{7, 12},
        });
        System.out.println(minArrowShots);
    }
}
