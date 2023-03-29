package com.leetcode.second.graph;

public class IslandPerimeter {
    int connectedNumber = -1;
    int islandSize = 0;
    public int islandPerimeter(int[][] grid) {
//get the size of the island by dfs

        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[row].length; column++) {
                if (grid[row][column] == 1) {
                    dfs(grid, row, column);
                }
            }
        }

//  in dfs, record the 'link' number of the island

//        result = sizeOfIsland - link * 2;

        return islandSize*4 - connectedNumber * 2;

    }

    private void dfs(int[][] grid, int row, int column ) {
        if (grid[row][column] != 1) {

           return;
        }

        grid[row][column] = 0;
        islandSize += 1;
        connectedNumber++;


        int maxRow = grid.length;
        int maxColumn = grid[row].length;

        if (row > 0) {
            dfs(grid, row - 1, column);
        }

        if (row < maxRow - 1) {
            dfs(grid, row + 1, column);
        }
        if (column > 0) {
            dfs(grid, row, column - 1);
        }
        if (column < maxColumn - 1) {
            dfs(grid, row, column + 1);
        }



    }

    public static void main(String[] args) {
        int i = new IslandPerimeter().islandPerimeter(new int[][]{
                new int[]{1,0}
        });
        System.out.println(i);
    }
}
