package com.leetcode.second.graph;

import java.util.*;


public class GraphValidTree {
    public boolean validTree(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> adjList = toAdjList(numCourses, prerequisites);
        Set<Integer> visited = new HashSet<>();

        boolean crossPath = dfs(0, adjList, visited, -1);
//            if start from the same node i, any sub node and itself been visited twice is basically not a tree
        if (crossPath) {
            return false;
        }
        return visited.size() == numCourses;

    }

    private boolean dfs(int i, Map<Integer, Set<Integer>> adjList, Set<Integer> visited, int parent) {
        if (visited.contains(i)) {
            return true;
        }

        visited.add(i);
        Set<Integer> neihbours = adjList.getOrDefault(i, new HashSet<>());

        for (Integer neihbour : neihbours) {
            if (neihbour != parent) {
                boolean crossPath = dfs(neihbour, adjList, visited, i);
                if (crossPath) {
                    return true;
                }
            }

        }
        return false;
    }

    private Map<Integer, Set<Integer>> toAdjList(int numberOfCrouses, int[][] prerequisites) {
        HashMap<Integer, Set<Integer>> adjList = new HashMap<>();
        for (int j = 0; j < prerequisites.length; j++) {
            addBiDirectionalAdj(adjList, prerequisites[j]);

        }
        return adjList;
    }

    private void addBiDirectionalAdj(HashMap<Integer, Set<Integer>> adjList, int[] prerequisites) {
        Set<Integer> val = adjList.getOrDefault(prerequisites[0], new HashSet<>());
        val.add(prerequisites[1]);
        adjList.put(prerequisites[0], val);

        Set<Integer> val2 = adjList.getOrDefault(prerequisites[1], new HashSet<>());
        val2.add(prerequisites[0]);
        adjList.put(prerequisites[1], val2);
    }

    public static void main(String[] args) {
        boolean result = new GraphValidTree().validTree(5, new int[][]{
                new int[]{0, 1},
                new int[]{1, 2},
                new int[]{2, 3},
                new int[]{1, 3},
                new int[]{1, 4},
        });
        System.out.println(result);
    }
}
