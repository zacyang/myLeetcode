package com.leetcode.second.interval;


import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        LinkedList<int[]> result = new LinkedList<>();

        int insertIdx = -1;
        for (int i = 0; i < intervals.length; i++) {
            if (newInterval[0] > intervals[i][0]) {
                result.add(intervals[i]);
                insertIdx = i;
            } else {
                break;
            }
        }

        if(result.isEmpty()) {
            result.add(newInterval);
        } else  {
            int[] last = result.getLast();
            if (newInterval[0] <= last[1]) {
                last[1] = Math.max(newInterval[1],last[1]);
            } else {
                result.add(newInterval);
            }
        }


        for (int i = insertIdx + 1; i < intervals.length; i++) {
            int[] previous = result.getLast();
            if (intervals[i][0] <= previous[1]) {
                previous[1] = Math.max(intervals[i][1], previous[1]);
            } else {
                result.add(intervals[i]);
            }
        }

        return result.toArray(new int[result.size()][]);


    }

    public static void main(String[] args) {
//        int[][] insert = new InsertInterval().insert(new int[][]{new int[]{1, 3}, new int[]{6, 9}}, new int[]{2, 5});
//        int[][] insert = new InsertInterval().insert(new int[][]{new int[]{1, 2}, new int[]{3, 5},  new int[]{6, 7}, new int[]{8, 10}, new int[]{12, 16}},new int[]{4,8});
        int[][] insert = new InsertInterval().insert(new int[][]{new int[]{1, 5}},new int[]{0,3});
        System.out.println(insert);
    }
}
