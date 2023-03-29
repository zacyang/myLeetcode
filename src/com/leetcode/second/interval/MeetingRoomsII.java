package com.leetcode.second.interval;

import java.util.*;
import java.util.stream.Collectors;

class IntervalPair{
    int value;
    boolean isStart;

    public IntervalPair(int value, boolean isStart) {
        this.value = value;
        this.isStart = isStart;
    }
}
public class MeetingRoomsII {
    public int minMeetingRooms(int[][] intervals) {
        LinkedList<IntervalPair> intervalPairs = new LinkedList<>();
        for (int[] interval : intervals) {
            intervalPairs.add(new IntervalPair(interval[0], true));
            intervalPairs.add(new IntervalPair(interval[1], false));
        }

        intervalPairs.sort(new Comparator<IntervalPair>() {
            @Override
            public int compare(IntervalPair o1, IntervalPair o2) {
                if(o1.value==o2.value) {
                    return o1.isStart? 1: -1;
                }
                return o1.value-o2.value;
            }
        });
        int counter = 0;
        int maxRoom = 0;
        for (IntervalPair intervalPair : intervalPairs) {
            if(intervalPair.isStart) {
                counter++;
            } else {
                counter--;
            }
            maxRoom = Math.max(counter, maxRoom);
        }
      return maxRoom;
    }

    public static void main(String[] args) {
        int i = new MeetingRoomsII().minMeetingRooms(new int[][]{new int[]{5, 8}, new int[]{6, 8}});
        System.out.println(i);
    }
}
