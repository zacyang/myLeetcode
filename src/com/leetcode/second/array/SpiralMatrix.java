package com.leetcode.second.array;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

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

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Pair> visited = new LinkedList<>();
        int x = 0;
        int y = 0;

        int maxY = matrix.length;
        int maxX = matrix[0].length;
        int totalNumberOfElm = maxY * maxX;
        List<Pair> directions = new LinkedList<>();
        directions.add(new Pair(1, 0));
        directions.add(new Pair(0, 1));
        directions.add(new Pair(-1, 0));
        directions.add(new Pair(0, -1));

        int currentDirection = 0;
        while (visited.size() != totalNumberOfElm) {
            visited.add(new Pair(x, y));

            currentDirection = getDirection(visited, x, y, maxX, maxY, currentDirection);
            currentDirection = currentDirection %4;

            x = directions.get(currentDirection).x + x;
            y = directions.get(currentDirection).y + y;

        }

        return visited.stream().map(p -> matrix[p.y][p.x]).collect(Collectors.toList());
    }

    private int getDirection(List<Pair> visited, int x, int y, int maxX, int maxY, int currentDirection) {
        if (currentDirection == 0) {
            if (visited.contains(new Pair(x + 1, y)) || x + 1 >= maxX) {
                return currentDirection + 1;
            }
        }
        if (currentDirection == 1) {
            if (visited.contains(new Pair(x, y + 1)) || y + 1 >= maxY ) {
                return currentDirection + 1;
            }
        }

        if (currentDirection == 2) {
            if (visited.contains(new Pair(x - 1, y)) || x - 1 < 0) {
                return currentDirection + 1;
            }
        }

        if (currentDirection == 3) {
            if (visited.contains(new Pair(x, y - 1)) || y - 1 < 0) {
                return currentDirection + 1;
            }
        }
        return currentDirection;
    }

    public static void main(String[] args) {
        System.out.println(new SpiralMatrix().spiralOrder(new int[][]{
                new int[]{1,2,3},
                new int[]{4,5,6},
                new int[]{7,8,9}

        }));;
    }

}
