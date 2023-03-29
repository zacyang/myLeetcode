package com.leetcode.second.tires;

import java.util.*;

class Node {
    Character c;
    boolean end;

    Map<Character, Node> next;

    public Node(Character c, boolean end) {
        this.c = c;
        this.end = end;
        this.next = new HashMap<>();
    }


}

// leetcode 208
public class Trie {
    Node root;

    public Trie() {
        root = new Node(null, false);
    }

    public void insert(String word) {
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

        Node node = children.get(currentChar);

        if (node==null) {
            return false;
        } else {

            if (matchingEnds&& start == end) {
                return node.end;
            }

            return searchWord(node.next, chars, start + 1, end, matchingEnds);
        }
    }

    public boolean startsWith(String prefix) {
        char[] target = prefix.toCharArray();
        return searchWord(this.root.next, target, 0, target.length - 1, false);
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        trie.search("apple");   // return True
        trie.search("app");     // return False
        System.out.println(trie.startsWith("app1")); // return True
//        trie.insert("app");
//        trie.search("app");     // return True
    }
}
