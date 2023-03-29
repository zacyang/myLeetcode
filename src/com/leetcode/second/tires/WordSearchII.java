package com.leetcode.second.tires;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

class BoardNode {
    int row;
    int column;

    public BoardNode(int x, int y) {
        this.row = x;
        this.column = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BoardNode)) return false;

        BoardNode boardNode = (BoardNode) o;

        if (row != boardNode.row) return false;
        return column == boardNode.column;
    }

    @Override
    public int hashCode() {
        int result = row;
        result = 31 * result + column;
        return result;
    }
}
public class WordSearchII {
    public List<String> findWords(char[][] board, String[] words) {
        Trie root = this.buildTires(words);

        List<String> result = new LinkedList<>();
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[row].length; column++) {
                List<BoardNode> visited = new LinkedList<>();
                this.dfs(new BoardNode(row,column),board, root,visited, result);
            }
        }
        return result;
    }

    private void dfs(BoardNode boardNode, char[][] board, Trie root, List<BoardNode> visited, List<String> result) {

        if(visited.contains(boardNode)){
            return;
        }
//        List<Character> collect = visited.stream().map(v -> board[v.x][v.y]).collect(Collectors.toList());
        visited.add(boardNode);

        String currentVisited = visited.stream()
                .map(v -> board[v.row][v.column])
                .map(String::valueOf)
                .collect(Collectors.joining());

        if(root.search(currentVisited)) {
            result.add(currentVisited);
        }


        List<BoardNode> nodes = this.getAdjNodes(boardNode,board);

        for (BoardNode node : nodes) {
            this.dfs(node, board, root, visited, result);
        }
        visited.remove(boardNode);
    }

    private List<BoardNode> getAdjNodes(BoardNode boardNode, char[][] board) {
        List<BoardNode> result = new LinkedList<>();
        if(boardNode.row > 1){
            result.add(new BoardNode(boardNode.row -1, boardNode.column));
        }
        if(boardNode.row < board.length-2){
            result.add(new BoardNode(boardNode.row +1, boardNode.column));
        }
        if(boardNode.column < board[0].length-2){
            result.add(new BoardNode(boardNode.row,  boardNode.column +1));
        }

        if(boardNode.column > 1){
            result.add(new BoardNode(boardNode.row,  boardNode.column -1));
        }


        return result;
    }


    private Trie buildTires(String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        return trie;
    }


}
