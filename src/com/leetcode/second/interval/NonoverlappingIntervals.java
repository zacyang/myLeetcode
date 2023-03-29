package com.leetcode.second.interval;

import java.util.Arrays;
import java.util.Comparator;

public class NonoverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
//        sort
        Arrays.sort(intervals, (o1, o2) -> o1[0]-o2[0]);


        int lastEnd= intervals[0][1];
        int result = 0;

        for (int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] < lastEnd) {
//                overlap
                lastEnd = Math.min(lastEnd, intervals[i][1]);
                result++;
            }else {
                lastEnd = intervals[i][1];
            }
        }
        return result;
    }
}
