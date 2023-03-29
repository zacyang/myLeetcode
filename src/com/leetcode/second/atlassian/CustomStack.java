package com.leetcode.second.atlassian;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

class CustomStack {
    private Stack<Integer> stack;

    private int[] addedValueTable;
    private int maxSize;

    public CustomStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new Stack<>();
        addedValueTable = new int[maxSize];
    }

    public void push(int x) {
        if (stack.size() < maxSize) {
            stack.push(x);
        }
    }

    public int pop() {

        int index = stack.size() - 1;

        if(index < 0) {
            return -1;

        }
        if(index >0) {
//            at least 2 record
            addedValueTable[index-1] += addedValueTable[index];

        }
//        equals 0 do noth, as only 1 record

        int result = addedValueTable[index] + stack.pop();
        addedValueTable[index] = 0;
        return result;
    }

    public void increment(int k, int val) {
        int recordingIdx = Math.min(k, stack.size()) - 1;
        if(recordingIdx>=0) {
            addedValueTable[recordingIdx] += val;
        }

    }


    public static void main(String[] args) {
        CustomStack customStack = new CustomStack(3); // Stack is Empty []
        customStack.push(1);                          // stack becomes [1]
        customStack.push(2);                          // stack becomes [1, 2]
        customStack.pop();                            // return 2 --> Return top of the stack 2, stack becomes [1]
        customStack.push(2);                          // stack becomes [1, 2]
        customStack.push(3);                          // stack becomes [1, 2, 3]
        customStack.push(4);                          // stack still [1, 2, 3], Don't add another elements as size is 4
        customStack.increment(5, 100);                // stack becomes [101, 102, 103]
        customStack.increment(2, 100);                // stack becomes [201, 202, 103]
        customStack.pop();                            // return 103 --> Return top of the stack 103, stack becomes [201, 202]
        customStack.pop();                            // return 202 --> Return top of the stack 102, stack becomes [201]
        customStack.pop();                            // return 201 --> Return top of the stack 101, stack becomes []
        customStack.pop();
    }
}
