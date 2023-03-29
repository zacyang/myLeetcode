package com.leetcode.second.graph;

import java.util.*;
import java.util.stream.Collectors;

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

public class CloneGraph {

    public Node cloneGraph(Node node) {
        if(node==null) {
            return node;
        }
        HashMap<Node, Node> cloneMap = new HashMap<>();
        bfs(node,cloneMap );

        for (Node originalNode : cloneMap.keySet()) {
            Node cloned = cloneMap.get(originalNode);
            List<Node> collect = originalNode.neighbors.stream().map(n -> cloneMap.get(n)).collect(Collectors.toList());
            cloned.neighbors.addAll(collect);
        }
        return cloneMap.get(node);
    }

    private void bfs(Node node, HashMap<Node, Node> cloneMap) {
        Set<Integer> visited = new HashSet<>();
        Queue<Node> front = new LinkedList<>();
        front.add(node);
        while(!front.isEmpty()) {
            Node currentNode = front.poll();
            if(!visited.contains(currentNode.val)) {
                visited.add(currentNode.val);
                cloneMap.put(currentNode, new Node(currentNode.val, new ArrayList<>()));
                for (Node neighbor : currentNode.neighbors) {
                    if(neighbor!=null) {
                        front.add(neighbor);
                    }
                }

            }

        }


    }


}
