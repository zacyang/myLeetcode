package com.leetcode.second.graph;

import java.util.*;
import java.util.stream.Collectors;


public class AlienDictionary {
    private Map<Character, Boolean> seen = new HashMap<>();
    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> adjList = this.createAdjList(words);
        List<String> topoligicalOrderWordStrings = this.getTopoligicalOrder(adjList);
        return String.join("", topoligicalOrderWordStrings);
    }

    private List<String> getTopoligicalOrder(Map<Character, Set<Character>> adjList) {
        Stack<Character> orderedStack = new Stack<>();
        Set<Character> visited = new HashSet<>();
        for (Character character : adjList.keySet()) {
            if(!visited.contains(character)) {
                if(!this.dfs(character, adjList, orderedStack)) {
                    return Collections.emptyList();
                }
            }
        }

        List<String> result = new LinkedList<>();
        while(!orderedStack.isEmpty()) {
            result.add(orderedStack.pop().toString());
        }
        return result;
    }
    private boolean dfs(Character c, Map<Character, Set<Character>> adjList,  Stack<Character> orderedStack) {
        if (seen.containsKey(c)) {
            return seen.get(c); // If this node was grey (false), a cycle was detected.
        }
        seen.put(c, false);
        for (Character next : adjList.getOrDefault(c, Collections.emptySet())) {
            boolean result = dfs(next, adjList, orderedStack);
            if (!result) return false;
        }
        seen.put(c, true);
        orderedStack.push(c);
        return true;
    }
    private Map<Character, Set<Character>> createAdjList(String[] words) {
//        order can be identified by the first differ chart
        Map<Character, Set<Character>> adjNodeWords = new HashMap();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                adjNodeWords.putIfAbsent(c, new HashSet<>());
            }
        }
//        to 2nd last as need 2 pair to compar
        for (int i = 0; i < words.length-1; i++) {

//            get first differ
            String word1 = words[i];
            String word2 = words[i + 1];
            int minLenght = Math.min(word1.length(), word2.length());
            if (word1.length() > word2.length() && word1.startsWith(word2)) {
                adjNodeWords.clear();
                return adjNodeWords;
            }


            for (int idx = 0; idx < minLenght; idx++) {
                if (word1.charAt(idx) != word2.charAt(idx)) {
                    char key = word1.charAt(idx);
                    Set<Character> value = adjNodeWords.getOrDefault(key, new HashSet<>());
                    value.add(word2.charAt(idx));
                    adjNodeWords.put(key, value);
                    break;
                }
            }

        }
        return adjNodeWords;
    }

    public static void main(String[] args) {
//        String result = new AlienDictionary().alienOrder(new String[]{"wrt", "wrf", "er", "ett", "rftt"});
        String result = new AlienDictionary().alienOrder(new String[]{"z","z"});
        System.out.println(result);
    }
}
