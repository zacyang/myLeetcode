package com.leetcode.second.graph;

import java.util.HashSet;
import java.util.Set;

public class NumberofProvinces {

    public int findCircleNum(int[][] isConnected) {
        DisjointSet disjointSet = new DisjointSet(isConnected.length);

        for (int i = 0; i < isConnected.length; i++) {

            for (int j = 0; j < isConnected.length; j++) {
                if(isConnected[i][j] == 1) {
                    disjointSet.union(i, j);
                }

            }
        }

        Set<Integer> provincedCap = new HashSet<>();
        for (int i = 0; i < disjointSet.root.length; i++) {
            provincedCap.add(disjointSet.find(i));
        }


        return provincedCap.size();
    }
}


class DisjointSet {

    final int[] root;
    private final int[] rank;

    public DisjointSet(int size) {

        root = new int[size];
        rank = new int[size];


        for (int i = 0; i < size; i++) {
            root[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int x) {
        if (x == root[x]) {
            return x;
        }
        return root[x] = find(root[x]);
    }


    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            if (rank[rootX] > rank[rootY]) {
                root[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                root[rootX] = rootY;
            } else {
                root[rootY] = rootX;
                rank[rootX] += 1;
            }
        }


    }

    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }
}