import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class  Pair {
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
public class Solution {
    public int numIslands(char[][] grid) {

        Set<Pair> visited = new HashSet<>();
        int numberOfIsland = 0;
        for (int xIndex = 0; xIndex < grid.length; xIndex++) {
            for (int yIndex = 0; yIndex < grid[xIndex].length; yIndex++) {
//                System.out.format("outter layer %d %d", xIndex, yIndex);
                if(visited.contains(new Pair(xIndex, yIndex)) || grid[xIndex][yIndex] == '0') {
                    continue;
                } else {
                    bfs(xIndex, yIndex, grid, visited);
                    numberOfIsland ++;
                }
            }
        }
        return numberOfIsland;

    }

    private void bfs(int x, int y, char[][] grid , Set<Pair> visited) {
        Queue<Pair> front = new LinkedList<>();
        front.add(new Pair(x, y));
        int level = 0;
        while(front.peek() != null){
            Pair current = front.poll();
            // System.out.println("processing >" + current.x + " - " + current.y);
            if(visited.contains(current)) {
                continue;
            }
            visited.add(current);


            Queue<Pair> neighbours = getNeighbours(grid, current);
            front.addAll(neighbours);

        }

    }

    private Queue<Pair> getNeighbours( char[][] grid, Pair front) {
        Queue<Pair> neighbours = new LinkedList<>();
        int x  =front.x;
        int y = front.y;
        if(grid[x][y] == '1') {

            if(x < grid.length - 1 ) {
                neighbours.add(new Pair(x + 1, y));
            }
            if(x > 0) {
                neighbours.add(new Pair(x - 1, y));
            }
            if(y < grid[x].length- 1 ) {
                neighbours.add(new Pair(x, y +1));
            }

            if(y !=0) {
                neighbours.add(new Pair(x, y - 1));
            }
        }
        return neighbours;
    }


}
