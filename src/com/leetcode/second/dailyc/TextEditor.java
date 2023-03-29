package com.leetcode.second.dailyc;

import java.util.LinkedList;

public class TextEditor {
    private LinkedList<Character> left;
    private LinkedList<Character> right;

    public TextEditor() {
        left = new LinkedList<>();
        right = new LinkedList<>();
    }

    public void addText(String text) {
        for (char c : text.toCharArray()) {
            left.add(c);
        }
    }

    public int deleteText(int k) {
        int actualDeleted=0;
        while (left.size()> 0 && k > 0) {
            left.removeLast();
            actualDeleted++;
            k--;
        }
        return actualDeleted;
    }

    public String cursorLeft(int k) {
        while (k > 0 && left.size()> 0) {
            right.addFirst(left.pollLast());
            k--;
        }

        return getLastTenToTheLeft();
    }

    private String getLastTenToTheLeft() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = Math.max(0, left.size() -10); i <  left.size(); i++) {
            stringBuilder.append(left.get(i));

        }
        return stringBuilder.toString();
    }

    public String cursorRight(int k) {
        while (k > 0 && right.size()>0) {
            left.add(right.pollFirst());
            k--;
        }
        return getLastTenToTheLeft();
    }



    public static void main(String[] args) {
        TextEditor textEditor = new TextEditor(); // The current text is "|". (The '|' character represents the cursor)
        textEditor.addText("leetcode"); // The current text is "leetcode|".
        System.out.println(textEditor.deleteText(4)); // return 4
        // The current text is "leet|".
        // 4 characters were deleted.
        textEditor.addText("practice"); // The current text is "leetpractice|".
        System.out.println(textEditor.cursorRight(3)); // return "etpractice"
        // The current text is "leetpractice|".
        // The cursor cannot be moved beyond the actual text and thus did not move.
        // "etpractice" is the last 10 characters to the left of the cursor.
        System.out.println(textEditor.cursorLeft(8)); // return "leet"
        // The current text is "leet|practice".
        // "leet" is the last min(10, 4) = 4 characters to the left of the cursor.
        System.out.println(textEditor.deleteText(10)); // return 4
        // The current text is "|practice".
        // Only 4 characters were deleted.
        System.out.println(textEditor.cursorLeft(2)); // return ""
        // The current text is "|practice".
        // The cursor cannot be moved beyond the actual text and thus did not move.
        // "" is the last min(10, 0) = 0 characters to the left of the cursor.
        System.out.println(textEditor.cursorRight(6)); // return "practi"
        // The current text is "practi|ce".
        // "practi" is the last min(10, 6) = 6 characters to the left of the cursor.System.out.println(
    }
}
