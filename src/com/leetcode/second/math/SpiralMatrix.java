package com.leetcode.second.math;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

class SpiralLocation {
    public int x;
    public int y;

    public SpiralLocation(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SpiralLocation)) return false;

        SpiralLocation that = (SpiralLocation) o;

        if (x != that.x) return false;
        return y == that.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}


public class SpiralMatrix {
    int[][] directions = new int[][]{new int[]{0, 1}, new int[]{1, 0}, new int[]{0, -1}, new int[]{-1, 0},};

    public List<Integer> spiralOrder(int[][] matrix) {

        int currentDirection = 0;

        List<SpiralLocation> visited = new LinkedList<>();

        SpiralLocation currentSpace = new SpiralLocation(0, 0);
        visited.add(currentSpace);
        while (visited.size() != matrix.length * matrix[0].length) {

            currentDirection = getDirection(currentDirection, currentSpace, visited, matrix);

//            move
            currentSpace = calculateNewSpace(currentSpace, currentDirection, directions);

            visited.add(currentSpace);

        }
        return visited.stream().map(sp -> matrix[sp.x][sp.y]).collect(Collectors.toList());


    }

    private SpiralLocation calculateNewSpace(        SpiralLocation currentSpace, int currentDirection, int[][] directions) {
        return new SpiralLocation(currentSpace.x + this.directions[currentDirection][0], currentSpace.y + this.directions[currentDirection][1]);

    }

    private int getDirection(int currentDirection, SpiralLocation currentSpace, List<SpiralLocation> visited, int[][] matrix) {

        SpiralLocation xlc = calculateNewSpace(currentSpace, currentDirection, directions);


        if (xlc.x >=0 &&  xlc.x <= matrix.length-1 && xlc.y <= matrix[0].length-1 && xlc.y >=0&& !visited.contains(new SpiralLocation(xlc.x,xlc.y))) {
            return currentDirection;
        } else {
            return (currentDirection+1) %4;
        }
    }

    public static void main(String[] args) {
        List<Integer> integers = new SpiralMatrix().spiralOrder(new int[][]{
                new int[]{1, 2, 3},
                new int[]{4, 5, 6},
                new int[]{7, 8, 9},
        });
        System.out.println(integers);
    }
}
