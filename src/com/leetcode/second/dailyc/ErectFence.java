package com.leetcode.second.dailyc;

import java.util.List;

public class ErectFence {
    public int[][] outerTrees(int[][] trees) {
//        step 1 find the rough out liner by finding the most up down left right points
        List<int[]> outLinePoints = findOutLine(trees);

//        step2, for each points check if it is inside the current outline, if not, exapand the outline

        for (int i = 0; i < trees.length; i++) {
            if (insideOutline(outLinePoints)) {
                continue;
            } else {
                outLinePoints.add(trees[i]);
            }
        }
        return outLinePoints.toArray(new int[outLinePoints.size()][]);
    }

    private boolean insideOutline(List<int[]> outLinePoints) {
        return false;
    }

    private List<int[]> findOutLine(int[][] trees) {
        return null;
    }
}
