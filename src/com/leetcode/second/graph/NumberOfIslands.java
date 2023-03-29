package com.leetcode.second.graph;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

class Pair {
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pair)) return false;

        Pair pair = (Pair) o;

        if (x != pair.x) return false;
        return y == pair.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}

public class NumberOfIslands {
    public int numIslands(char[][] grid) {

        int result = 0;
        Set<Pair> visited = new HashSet<>();
        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[0].length; x++) {
                if (!visited.contains(new Pair(x, y)) && grid[y][x] == '1') {
                    result++;
                    bfs(grid, x, y, visited);
                }

            }
        }
        return result;
    }

    private void bfs(char[][] grid, int x, int y, Set<Pair> visited) {


        LinkedList<Pair> front = new LinkedList<>();

        front.add(new Pair(x, y));


        while (!front.isEmpty()) {
            Pair currentNode = front.poll();
            visited.add(currentNode);

            List<Pair> adjList = getAdjList(grid, currentNode.x, currentNode.y);

            for (Pair pair : adjList) {
                if (!visited.contains(pair) && grid[pair.y][pair.x] == '1') {
                    front.add(pair);
                }
            }
        }
    }

    private List<Pair> getAdjList(char[][] grid, int x, int y) {
        int maxY = grid.length;
        int maxX = grid[0].length;

        List<Pair> result = new LinkedList<>();


        if (x < maxX - 1) {
            result.add(new Pair(x + 1, y));
        }

        if (x > 0) {
            result.add(new Pair(x - 1, y));
        }

        if (y < maxY - 1) {
            result.add(new Pair(x, y + 1));
        }

        if (y > 0) {
            result.add(new Pair(x, y - 1));
        }
        return result;
    }

    public class NumberOfIslands2 {
        public int numIslands(char[][] grid) {

            int result = 0;

            for (int y = 0; y < grid.length; y++) {
                for (int x = 0; x < grid[0].length; x++) {
                    if (grid[y][x] == '1') {
                        result++;
                        checkIsland(grid, x, y);
                    }

                }
            }
            return result;
        }

        private void checkIsland(char[][] grid, int x, int y) {
            if (x < grid[0].length && y < grid.length && x >= 0 && y >= 0) {

                if (grid[y][x] == '1') {
                    grid[y][x] = '0';
                    checkIsland(grid, x + 1, y);
                    checkIsland(grid, x - 1, y);
                    checkIsland(grid, x - 1, y + 1);
                    checkIsland(grid, x - 1, y - 1);
                }

            }
        }

    }
}
