package com.leetcode.second.array;

import java.util.Stack;

class CharCount {
    char value;
    int count;

    public CharCount(char value, int count) {
        this.value = value;
        this.count = count;
    }
}

public class RemoveAllAdjacentDuplicatesStringII {
    public String removeDuplicates(String s, int k) {


        Stack<CharCount> stack = new Stack<>();

        char[] targetChars = s.toCharArray();

//        record the duplicate count and char
//        if the top of the stack reaches K, remove the top pair< char, count> ,
        for (char targetChar : targetChars) {

            if (!stack.isEmpty() && stack.peek().value == targetChar) {
                CharCount pop = stack.pop();
                pop.count += 1;

                if (pop.count < k) {
                    stack.push(pop);
                }

            } else {
                stack.push(new CharCount(targetChar, 1));
            }

            if(!stack.isEmpty() && stack.peek().count == k) {
                stack.pop();
            }



        }

        StringBuilder result = new StringBuilder();
        for (CharCount character : stack) {
            for (int i = 0; i < character.count; i++) {
                result.append(character.value);
            }

        }

        return result.toString();
    }

    public static void main(String[] args) {
        String result = new RemoveAllAdjacentDuplicatesStringII().removeDuplicates("deeedbbcccbdaa", 3);
        System.out.println(result);
    }
}
