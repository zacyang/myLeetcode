package com.leetcode.second.graph;

import java.util.LinkedList;
import java.util.Queue;

public class MaxAreaofIsland {

    private int rowMax;
    private int columnMax;

    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
//        for each node , if v == 1, start bfs

        rowMax = grid.length;
        for (int row = 0; row < rowMax; row++) {
            columnMax = grid[row].length;
            for (int column = 0; column < columnMax; column++) {


                if (grid[row][column] == 1) {

                    int area = bfs(grid, 0, row, column);
                    maxArea = Math.max(area, maxArea);
                }
            }
        }
//        add counter
//        bfs, turn 1 -> 0 (as marker)
//
        return maxArea;
    }

    private int bfs(int[][] grid, int area, int row, int column) {

        Queue<int[]> frontier = new LinkedList<>();
        frontier.add(new int[]{row, column});

        while (!frontier.isEmpty()) {
            int[] poll = frontier.poll();
            int r = poll[0];
            int c = poll[1];
            if (grid[r][c] == 1) {
                grid[r][c] = 0;
                area++;

                if (r >= 1) {
                    frontier.add(new int[]{r - 1, c});
                }
                if (r < rowMax - 1) {
                    frontier.add(new int[]{r + 1, c});

                }
                if (c < columnMax - 1) {
                    frontier.add(new int[]{r, c + 1});
                }
                if (c >= 1) {
                    frontier.add(new int[]{r, c - 1});
                }
            }
        }


        return area;

    }

    public static void main(String[] args) {
        int i = new MaxAreaofIsland().maxAreaOfIsland(new int[][]{

                new int[]{
                        0, 1
                },
                new int[]{
                        1, 1
                }
        });

        System.out.println(i);
    }

}
