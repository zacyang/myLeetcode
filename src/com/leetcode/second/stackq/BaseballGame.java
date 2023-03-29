package com.leetcode.second.stackq;

import java.util.Optional;
import java.util.Stack;

public class BaseballGame {
    public int calPoints(String[] operations) {
        Stack<Integer> scoreBoard = new Stack<>();

        for (String operation : operations) {

            if(operation.equals("+")) {
                Integer score1 = scoreBoard.pop();
                Integer score2 = scoreBoard.peek();
                scoreBoard.push(score1);
                scoreBoard.push(score1+score2);
            }else
            if(operation.equals("C")) {

                scoreBoard.pop();

            }else if(operation.equals("D")) {
                int doubleVal = scoreBoard.peek() * 2;
                scoreBoard.push(doubleVal);

            } else {
                scoreBoard.push(Integer.valueOf(operation));
            }


        }


        return  scoreBoard.stream().reduce((a, b) -> a + b).orElse(0);

    }

    public static void main(String[] args) {
        System.out.println(new BaseballGame().calPoints(new String[]{"5","-2","4","C","D","9","+","+"}));
    }
}
