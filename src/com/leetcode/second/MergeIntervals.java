package com.leetcode.second;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class MergeIntervals {
//    public int[][] merge(int[][] intervals) {
////                        assume they are sorted where a-start < b-start
//        List<int[]> target = new ArrayList<>();
//        for (int i = 0; i < intervals.length; i++) {
//            target.add(intervals[i]);
//        }
//        target.sort(Comparator.comparingInt(a -> a[0]));
//
//        List<int[]> result = new LinkedList<>();
//
//
//        int currentStart = target.get(0)[0];
//        int currentEnd = target.get(0)[1];
//        for (int i = 0; i < target.size(); i++) {
//
//            if (currentEnd >= target.get(i)[0]) {
//                currentEnd = Math.max(target.get(i)[1], currentEnd);
//            } else {
//
//                currentStart = target.get(i)[0];
//                currentEnd = target.get(i)[1];
//            }
//
//            if(i== target.size()-1 || currentEnd < target.get(i)[0]) {
//                result.add(new int[]{currentStart, currentEnd});
//            }
//
//        }
//        return result.toArray(new int[result.size()][]);
//    }

    public int[][] merge(int[][] intervals) {
        List<int[]> result = new LinkedList<>();
        List<int[]> target = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            target.add(intervals[i]);
        }
        HashSet<Integer> removed = new HashSet<>();
        for (int i = 0; i < target.size(); i++) {
            int currentStart = target.get(i)[0];
            int currentEnd = target.get(i)[1];
            if(removed.contains(i)) {
                continue;
            }
            for (int j = i+1; j < target.size(); j++) {

                if(isOverLap(currentStart, currentEnd, target.get(j))) {
                    currentStart = Math.min(currentStart, target.get(j)[0]);
                    currentEnd= Math.max(currentEnd, target.get(j)[1]);
//                    target.remove(target.get(j));
                    removed.add(j);
                }
            }

            result.add(new int[]{currentStart, currentEnd});

        }



        return result.toArray(new int[result.size()][]);
    }

    private boolean isOverLap(int currentStart, int currentEnd, int[] target) {

       if(currentStart < target[0]){
           return target[0] < currentEnd;
       } else {
           return currentStart < target[1];
       }

    }

    public static void main(String[] args) {
        System.out.println(new MergeIntervals().merge(new int[][]{
//                [[1,3],[2,6],[8,10],[15,18]]
//                new int[]{1, 3},
//                new int[]{2, 6},
//                new int[]{8, 10},
//                new int[]{15, 18},

                new int[]{1, 4},
                new int[]{0,2 },
                new int[]{3,5 },

        }));
    }
}
