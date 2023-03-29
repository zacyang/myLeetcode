package com.leetcode.second.interval;

import java.util.Arrays;
import java.util.Comparator;

public class MeetingRooms {
    public boolean canAttendMeetings(int[][] intervals) {
        if(intervals==null || intervals.length==0) {
            return true;
        }
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        int previousEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] < previousEnd) {
//                overlap
                return  false;
            }
            previousEnd = intervals[i][1];
        }
        return true;
    }
}
