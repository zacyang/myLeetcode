package com.leetcode.second.graph;

import java.util.*;

class ReachableResult {
    boolean toPacific;
    boolean toAtlantic;

}

class Point {
    int x;
    int y;
    int height;

    public Point(int x, int y, int i) {
        this.x = x;
        this.y = y;
        this.height = i;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point)) return false;

        Point point = (Point) o;

        if (x != point.x) return false;
        return y == point.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}

public class PacificAtlanticWaterFlow {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> allPointReachesBothSizes = new LinkedList<>();
        for (int x = 0; x < heights[0].length; x++) {
            for (int y = 0; y < heights.length; y++) {
                Set<Point> visited = new HashSet<>();
                ReachableResult record = new ReachableResult();
                Point currentPoint = new Point(x, y, heights[y][x]);
                ReachableResult result = dfs(currentPoint, heights, visited, record, currentPoint);
                if (result.toAtlantic && result.toPacific) {
                    allPointReachesBothSizes.add(Arrays.asList(y, x));
                }

            }
        }
        return allPointReachesBothSizes;
    }

    private ReachableResult dfs(Point currentPoint, int[][] heights, Set<Point> visited, ReachableResult record, Point parentNode) {

        if (!currentPointIsLowThanParent(currentPoint, parentNode)) {
            return record;
        }
        if (isAdjToPacific(currentPoint, heights)) {
            record.toPacific = true;
        }
        if (isAdjToAltnatic(currentPoint, heights)) {
            record.toAtlantic = true;
        }

        if (visited.contains(currentPoint)) {
            return record;
        }

        visited.add(currentPoint);

        List<Point> adjList = getAdjList(currentPoint, heights);


        for (Point point : adjList) {
            ReachableResult dfs = dfs(point, heights, visited, record, currentPoint);
            record.toAtlantic = dfs.toAtlantic ? dfs.toAtlantic : record.toAtlantic;

            record.toPacific = dfs.toPacific ? dfs.toPacific : record.toPacific;
        }
        return record;
    }

    private List<Point> getAdjList(Point currentPoint, int[][] heights) {
        int x = currentPoint.x;
        int y = currentPoint.y;
        LinkedList<Point> result = new LinkedList<>();
        if (x > 0) {
            result.add(new Point(x - 1, y, heights[y][x - 1]));
        }
        if (x < heights[0].length - 1) {
            result.add(new Point(x + 1, y, heights[y][x + 1]));
        }

        if (y > 0) {
            result.add(new Point(x, y - 1, heights[y - 1][x]));
        }
        if (y < heights.length - 1) {
            result.add(new Point(x, y + 1, heights[y + 1][x]));
        }
        return result;
    }

    private boolean isAdjToAltnatic(Point currentPoint, int[][] heights) {
        return currentPoint.x == 0 || currentPoint.y == 0;

    }

    private boolean isAdjToPacific(Point currentPoint, int[][] heights) {
        return currentPoint.x == heights[0].length - 1 || currentPoint.y == heights.length - 1;
    }

    private boolean currentPointIsLowThanParent(Point currentPoint, Point parentNode) {
        return currentPoint.height <= parentNode.height;
    }
}
