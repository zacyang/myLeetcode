package com.leetcode.second.stackq;

import java.util.Arrays;
import java.util.PriorityQueue;

public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> sortedWeights = new PriorityQueue<>((o1, o2) -> o2 - o1);


        for (int stone : stones) {
            sortedWeights.offer(stone);
        }


        while (sortedWeights.size() >= 2) {

            Integer s1 = sortedWeights.poll();

            Integer s2 = sortedWeights.poll();
            if (s1 != s2) {
                sortedWeights.offer(Math.abs(s1 - s2));
            }

        }

        return sortedWeights.isEmpty()?0: sortedWeights.peek();
    }

    public static void main(String[] args) {
        int i = new LastStoneWeight().lastStoneWeight(new int[]{2, 7, 4, 1, 8, 1});
        System.out.println(i);
    }
}
