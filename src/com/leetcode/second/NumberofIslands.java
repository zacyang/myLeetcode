package com.leetcode.second;

import java.util.*;

class Adj {
    int x;
    int y;

    public Adj(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Adj)) return false;

        Adj adj = (Adj) o;

        if (x != adj.x) return false;
        return y == adj.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}

public class NumberofIslands {
    public int numIslands(char[][] grid) {
//build adj list
        Map<Adj, List<Adj>> adjListMap = new HashMap<Adj, List<Adj>>();
        int xLen = grid[0].length;
        int yLen = grid.length;
        for (int x = 0; x < xLen; x++) {
            for (int y = 0; y < yLen; y++) {
                List<Adj> adjList = new ArrayList<>();
                if (x > 0) {
                    adjList.add(new Adj(x - 1, y));
                }
                if (x < xLen - 1) {

                    adjList.add(new Adj(x + 1, y));

                }

                if (y < yLen - 1) {


                    adjList.add(new Adj(x, y + 1));

                }

                if (y > 0) {

                    adjList.add(new Adj(x, y - 1));


                }
                adjListMap.put(new Adj(x, y), adjList);
            }
        }
//        dfs
        Set<Adj> visisted = new HashSet<>();
        int numberOfIsland = 0;
        for (int x = 0; x < xLen; x++) {
            for (int y = 0; y < yLen; y++) {
                if (!visisted.contains(new Adj(x, y)) && isIsland(grid, x, y)) {
                    this.bfs(new Adj(x, y), adjListMap, visisted);
                    numberOfIsland++;
                }

            }
        }
        return numberOfIsland;
    }

    private boolean isIsland(char[][] grid, int x, int y) {
        return grid[y][x] == '1';
    }

    private void bfs(Adj adj, Map<Adj, List<Adj>> adjListMap, Set<Adj> visisted) {
        Queue<Adj> front = new PriorityQueue<>();

        front.addAll(adjListMap.get(adj));





    }

    public static void main(String[] args) {
//        [
//  ['1','1','1','1','0'],
//  ['1','1','0','1','0'],
//  ['1','1','0','0','0'],
//  ['0','0','0','0','0']
//]
        new NumberofIslands().numIslands(new char[][]{
                new char[]{
                        '1', '1', '1', '1', '0'
                },
                new char[]{
                        '1', '1', '1', '1', '0'
                },
                new char[]{
                        '1', '1', '1', '1', '0'
                },
                new char[]{
                        '1', '1', '1', '1', '0'
                },
        });
    }
}
