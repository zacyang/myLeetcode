package com.leetcode.second.tires;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

class WordNode {
    int x;
    int y;


    public WordNode(int x, int y) {
        this.x = x;
        this.y = y;

    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (!(o instanceof WordNode)) return false;

        WordNode wordNode = (WordNode) o;

        if (x != wordNode.x) return false;
        return y == wordNode.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}

public class WordSearch {
    int[] xindex = new int[]{1, -1, 0, 0};
    int[] yindex = new int[]{0, 0, 1, -1};

    public boolean exist(char[][] board, String word) {
        char[] target = word.toCharArray();
        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[0].length; x++) {
                if (board[y][x] != target[0]) {
                    continue;
                }
                Set<WordNode> visited = new HashSet<>();
                boolean result = dfs(board, x, y, target, 0, visited);
                if (result) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int x, int y, char[] chars, int start, Set<WordNode> visited) {
        WordNode currentNode = new WordNode(x, y);

        if (visited.contains(currentNode)) {
            return false;
        }

        visited.add(currentNode);
        if (board[y][x] == chars[start]) {
            List<WordNode> adjList = getAdj(board, x, y);
            if (start == chars.length - 1) {
                return true;
            }
            for (WordNode wordNode : adjList) {
                boolean found = dfs(board, wordNode.x, wordNode.y, chars, start + 1, visited);
                if (found) {
                    return true;
                }
            }
        }
        visited.remove(currentNode);
        return false;
    }

    private List<WordNode> getAdj(char[][] board, int x, int y) {
        List<WordNode> result = new LinkedList<>();
        for (int i = 0; i < this.xindex.length; i++) {
            if (x + xindex[i] >= 0 && x + xindex[i] < board[0].length && y + yindex[i] >= 0 && y + yindex[i] < board.length)
                result.add(new WordNode(x + xindex[i], y + yindex[i]));
        }

        return result;
    }

    public static void main(String[] args) {
//        boolean result = new WordSearch().exist(new char[][]{
//
//                new char[]{'A', 'B', 'C', 'E'},
//                new char[]{'A', 'F', 'C', 'S'},
//                new char[]{'A', 'D', 'E', 'E'},
//
//        }, "ABCB");
//        boolean result = new WordSearch().exist(new char[][]{
//
//                new char[]{'A'},
//
//        }, "A");

//        boolean result = new WordSearch().exist(new char[][]{
//
//                new char[]{'A','B'},
//                new char[]{'C','D'},
//
//        }, "ACDB");
//        System.out.println(result);
    }
}
