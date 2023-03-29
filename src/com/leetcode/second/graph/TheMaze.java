package com.leetcode.second.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TheMaze {
    private int[][] directions = new int[][]{new int[]{0, 1}, new int[]{1, 0}, new int[]{-1, 0}, new int[]{0, -1}};


    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
//        bfs search , on condition the ball roll to the wall
        boolean[][] visisted = new boolean[maze.length][maze[0].length];
        boolean reached = bfs(maze, start, destination, visisted);


        return reached;


    }

    private boolean bfs(int[][] maze, int[] start, int[] destination, boolean[][] visisted) {


        LinkedList<int[]> frontTier = new LinkedList<>();
        frontTier.add(start);

        while (!frontTier.isEmpty()) {
            int[] stop = frontTier.pop();
            visisted[stop[0]][stop[1]] = true;

            if (stop[0] == destination[0] && stop[1] == destination[1]) {
                return true;
            }

            List<int[]> nextStops = rollBallUntilStop(maze, stop);

            for (int[] nextStop : nextStops) {
                if (!alreadyVisisted(nextStop, visisted)) {
                    frontTier.add(nextStop);
                }
            }
        }
        return false;

    }

    private boolean alreadyVisisted(int[] nextStop, boolean[][] visisted) {
        return visisted[nextStop[0]][nextStop[1]] == true;
    }

    private List<int[]> rollBallUntilStop(int[][] maze, int[] stop) {
        List<int[]> result = new LinkedList<>();
        for (int[] direction : this.directions) {

            int newRow = stop[0];
            int newCol = stop[1];
            while ((newRow + direction[0] >= 0 && newRow + direction[0] < maze.length) &&

                    (newCol + direction[1] >= 0 && newCol + direction[1] < maze[0].length)

                    && maze[newRow + direction[0]][newCol + direction[1]] != 1) {
                newRow  +=direction[0];
                newCol += direction[1];
            }
            result.add(new int[]{newRow, newCol});
        }
        return result;
    }

    public static void main(String[] args) {
        boolean b = new TheMaze().hasPath(new int[][]{new int[]{0, 0, 1, 0, 0}, new int[]{0, 0, 0, 0, 0}, new int[]{0, 0, 0, 1, 0}, new int[]{1, 1, 0, 1, 1}, new int[]{0, 0, 0, 0, 0}

        }, new int[]{0, 4}, new int[]{4, 4});
        System.out.println(b);
    }
}
