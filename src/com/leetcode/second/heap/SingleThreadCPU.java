package com.leetcode.second.heap;

import java.util.*;

public class SingleThreadCPU {
    public int[] getOrder(int[][] tasks) {
        LinkedList<int[]> orderedTasks = new LinkedList<>();
        for (int i = 0; i < tasks.length; i++) {
            orderedTasks.add(new int[]{tasks[i][0], tasks[i][1], i});
        }

        orderedTasks.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int readyTimeComp = o1[0] - o2[0];
                if (readyTimeComp == 0) {
                    return o1[1] - o2[1];
                }
                return readyTimeComp;

            }
        });


        PriorityQueue<int[]> taskQ = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int taskTimeComapre = o1[1] - o2[1];
                if (taskTimeComapre == 0) {
//                    compare indx
                    return o1[2] - o2[2];
                }
                return taskTimeComapre;
            }
        });

        int currentTime = 0;

        int[] result = new int[tasks.length];
        int resultIdx = 0;
        while (!orderedTasks.isEmpty()) {

            if(taskQ.isEmpty() && orderedTasks.peekFirst()[0] > currentTime) {
                currentTime = orderedTasks.peekFirst()[0];
            }
            while (taskQ.isEmpty() || !orderedTasks.isEmpty() && orderedTasks.peekFirst()[0] <= currentTime) {

                taskQ.offer(orderedTasks.pollFirst());
            }
//            process tasks

            int[] taskFinished = taskQ.poll();
            result[resultIdx] = taskFinished[2];
            resultIdx++;
            currentTime += taskFinished[1];

        }

//        task left
        while (!taskQ.isEmpty()) {
            int[] taskFinished = taskQ.poll();
            result[resultIdx] = taskFinished[2];
            resultIdx++;
            currentTime += Math.max(currentTime, taskFinished[0]) + taskFinished[1];
        }

        return result;
    }

    public static void main(String[] args) {
//        [[19,13],
//        [16,9],
//        [21,10],
//        [32,25],
//        [37,4],
//        [49,24],
//        [2,15],
//        [38,41],
//        [37,34],
//        [33,6],[45,4],[18,18],[46,39],[12,24]]
//        2,15 ->19,13 ->
//        int[] order = new SingleThreadCPU().getOrder(new int[][]{new int[]{1, 2}, new int[]{2, 4}, new int[]{3, 2}, new int[]{4, 1},});
        int[] order = new SingleThreadCPU().getOrder(new int[][]{
                new int[]{7, 10},
                new int[]{7, 12},
                new int[]{7, 5},
                new int[]{7, 4},
                new int[]{7, 2},


        });
//        int[] order = new SingleThreadCPU().getOrder(new int[][]{
//                new int[]{2, 15},
//                new int[]{19, 13},
//                new int[]{37, 4},
//                new int[]{16, 9},
//
//
//
//        });

        for (int i : order) {
            System.out.println(i);
        }
    }
}
