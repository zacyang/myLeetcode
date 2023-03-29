package com.leetcode.second.stackq;

import java.util.Stack;

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> monoIncStack = new Stack<>();
        int[] result = new int[temperatures.length];
        for (int currentDay = 0; currentDay < temperatures.length; currentDay++) {
            int currentTemp = temperatures[currentDay];


            while(!monoIncStack.isEmpty() && temperatures[monoIncStack.peek()] < currentTemp) {
                Integer previousColdDay = monoIncStack.pop();
                result[previousColdDay] = currentDay - previousColdDay;
            }
            monoIncStack.push(currentDay);
        }
        return result;

    }

    public static void main(String[] args) {
//        int[] ints = new DailyTemperatures().dailyTemperatures(new int[]{
//                73, 74, 75, 71, 69, 72, 76, 73
//        });

        int[] ints = new DailyTemperatures().dailyTemperatures(new int[]{
                30,40,50,60
        });

        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}
