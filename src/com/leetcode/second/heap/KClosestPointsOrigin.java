package com.leetcode.second.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestPointsOrigin {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((o1, o2) -> calculateDist(o2) - calculateDist(o1) > 0 ? 1 : -1);
        for (int[] point : points) {
            if (maxHeap.size() < k) {
                maxHeap.offer(point);
            } else {
                if (calculateDist(maxHeap.peek()) - calculateDist(point) > 0) {
                    maxHeap.poll();
                    maxHeap.offer(point);
                }
            }
        }
        int[][] result = new int[maxHeap.size()][];
        int size = maxHeap.size();
        for (int i = 0; i < size; i++) {
            result[i] = maxHeap.poll();
        }
        return result;
    }

    private double calculateDist(int[] o1) {
        return Math.sqrt(Math.pow(o1[0], 2) + Math.pow(o1[1], 2));
    }

    public static void main(String[] args) {
        new KClosestPointsOrigin().kClosest(new int[][]{
                new int[]{3,3},
                new int[]{5,-1},
                new int[]{-2,4},
        },2);
    }
}
