package com.leetcode.second.graph;

import java.util.*;

public class NumberConnectedComponentsUndirectedGraph {
    public int countComponents(int n, int[][] edges) {
        Map<Integer, Set<Integer>> adjList = getAdjList(edges);

        Set<Integer> visited = new HashSet<>();
        int numberOfComponents = 0;

        for (int i = 0; i < n; i++) {
            if (!visited.contains(i)) {
                numberOfComponents++;
                dfs(i, adjList, visited);
            }
        }
        return numberOfComponents;

    }

    private Map<Integer, Set<Integer>> getAdjList(int[][] edges) {
        Map<Integer, Set<Integer>> adjList = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            int left = edges[i][0];
            int right = edges[i][1];
            addToAdj(adjList, left, right);
            addToAdj(adjList, right, left);
        }
        return adjList;
    }

    private void addToAdj(Map<Integer, Set<Integer>> adjList, int left, int right) {
        Set<Integer> neibougrs = adjList.getOrDefault(left, new HashSet<>());
        neibougrs.add(right);
        adjList.put(left, neibougrs);
    }

    private void dfs(int i, Map<Integer, Set<Integer>> adjList, Set<Integer> visited) {
        if (visited.contains(i)) {
            return;
        }

        visited.add(i);

        Set<Integer> neihbours = adjList.getOrDefault(i, Collections.emptySet());
        for (Integer neihbour : neihbours) {
            dfs(neihbour, adjList, visited);
        }

    }
}
