package com.leetcode.second.twopointer;

import javax.swing.plaf.metal.MetalBorders;
import java.util.Arrays;

public class BoatsSavePeople {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int start = 0;
        int end = people.length - 1;
        int numberOfBoart = 0;

        while (start <= end) {
            int reminder = limit - people[end];
            if (reminder >= people[start] && reminder > 0) {
//                can fit both, pick the smaller one
                start++;
            }
            end--;
            numberOfBoart++;

        }
        return numberOfBoart;
    }

    public static void main(String[] args) {
        int i = new BoatsSavePeople().numRescueBoats(new int[]{3, 2, 2, 1}, 3);
//        int i = new BoatsSavePeople().numRescueBoats(new int[]{3,5,3,4}, 5);
//        int i = new BoatsSavePeople().numRescueBoats(new int[]{1,2}, 3);
        System.out.println(i);
    }
}
