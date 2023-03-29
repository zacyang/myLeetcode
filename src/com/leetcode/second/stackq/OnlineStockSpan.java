package com.leetcode.second.stackq;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class OnlineStockSpan {
    Stack<Integer[]> register = new Stack();


    public OnlineStockSpan() {

    }

    public int next(int price) {
        int counter= 1;
        while(!register.isEmpty() && register.peek()[0] < price) {
            Integer[] pop = register.pop();
            counter+= pop[1];
        }
        register.push(new Integer[]{price, counter});
        return counter;
    }


    public static void main(String[] args) {
        OnlineStockSpan onlineStockSpan = new OnlineStockSpan();
        onlineStockSpan.next(100);
        onlineStockSpan.next(80);
        onlineStockSpan.next(60);
        onlineStockSpan.next(70);
        onlineStockSpan.next(60);
        onlineStockSpan.next(75);onlineStockSpan.next(85);

    }
}
