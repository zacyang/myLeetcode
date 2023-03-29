package com.leetcode.second.tires;


import java.util.*;


// leetcode 208
public class WordDictionary {
    Node root;

    public WordDictionary() {
        root = new Node(null, false);
    }

    public void addWord(String word) {
        char[] chars = word.toCharArray();
        int start = 0;
        int end = chars.length - 1;

        findAndInsert(root.next, chars, start, end);

    }

    private void findAndInsert(Map<Character, Node> children, char[] chars, int start, int end) {
        if (start > end) {
            return;
        }

        char currentChar = chars[start];

        Node node = children.get(currentChar);
        if (node == null) {
            Node newNode = new Node(currentChar, start == end);
            children.put(currentChar, newNode);
            findAndInsert(children, chars, start, end);
        } else {
            if (start == end) {
                node.end = true;
            } else {
                findAndInsert(node.next, chars, start + 1, end);
            }

        }
    }

    public boolean search(String word) {
        char[] chars = word.toCharArray();
        return searchWord(root.next, chars, 0, chars.length - 1, true);
    }

    private boolean searchWord(Map<Character, Node> children, char[] chars, int start, int end, boolean matchingEnds) {
        if (start > end) {
            return true;
        }
        char currentChar = chars[start];

        if(currentChar == '.') {
            return children.values().stream().anyMatch(n -> matchedCurrentNode(chars, start, end, matchingEnds, n));
        } else {
            Node node = children.get(currentChar);

            return matchedCurrentNode(chars, start, end, matchingEnds, node);
        }

    }

    private boolean matchedCurrentNode(char[] chars, int start, int end, boolean matchingEnds, Node node) {
        if (node ==null) {
            return false;
        } else {

            if (matchingEnds && start == end) {
                return node.end;
            }

            return searchWord(node.next, chars, start + 1, end, matchingEnds);
        }
    }
}
/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */