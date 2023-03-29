package com.leetcode.second.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class CarPooling {
    public boolean carPooling(int[][] trips, int capacity) {
//        put trips into q, ordered by destination in acending order
//        pick up top, update reminding capacity,
//        continue loop
//        pick up top,if overlap, update reminding capacity, else, restore
//         termination condition, when Q is empty and remining capacity > 0, True


        PriorityQueue<int[]> tripQ = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });

        Arrays.sort(trips, (o1, o2) -> o1[1] - o2[1]);

        int currentCapacity = capacity;
        for (int[] trip : trips) {

            while (!tripQ.isEmpty() && tripQ.peek()[2] <= trip[1]) {
                int[] finishedTrip = tripQ.poll();
                currentCapacity += finishedTrip[0];
            }
            currentCapacity -= trip[0];
            if (currentCapacity < 0) {
                return false;
            }

            tripQ.offer(trip);
        }

        return currentCapacity >= 0;
    }

    public static void main(String[] args) {
        boolean b = new CarPooling().carPooling(new int[][]{

                new int[]{2, 1, 5},
                new int[]{3, 3, 7},

        }, 5);

        System.out.println(b);

    }
}
