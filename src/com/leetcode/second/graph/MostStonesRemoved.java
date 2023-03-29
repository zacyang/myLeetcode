package com.leetcode.second.graph;

import java.util.ArrayList;
import java.util.List;

public class MostStonesRemoved {
    int removeStones(int[][] stones) {
        List<Integer>[] adjList = this.generateAdjList(stones);

        boolean[] visited = new boolean[stones.length];

        int component = 0;
        for (int i = 0; i < stones.length; i++) {
            if (!visited[i]) {
                component++;
                bfs(visited, i, adjList);
            }
        }

        return stones.length - component;
    }

    private void bfs(boolean[] visited, int i, List<Integer>[] adjList) {
        visited[i] = true;

        for (Integer stoneIdx : adjList[i]) {
            if(!visited[stoneIdx]){
                bfs(visited, stoneIdx, adjList);
            }

        }
    }

    private List<Integer>[] generateAdjList(int[][] stones) {
        List<Integer>[] adj = new ArrayList[stones.length];
        for (int i = 0; i < stones.length; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < stones.length; i++) {
            for (int j = i + 1; j < stones.length; j++) {
                if (shareCommonRowOrColumn(stones[i], stones[j])) {
                    adj[i].add(j);
                    adj[j].add(i);
                }
            }

        }
        return adj;
    }

    private boolean shareCommonRowOrColumn(int[] stone1, int[] stone2) {
        return stone1[0] == stone2[0] || stone1[1] == stone2[1];
    }
}
