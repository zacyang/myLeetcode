package com.leetcode.second.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        ArrayList<List<Integer>> objects = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            ArrayList<Integer> e =new  ArrayList<Integer>(Collections.nCopies(i+1, 1));


            for (int j = 1; j < e.size()-1; j++) {
                List<Integer> previousRow = objects.get(i - 1);
                int result = previousRow.get(j - 1) + previousRow.get(j );
                e.set(j, result);
            }
            objects.add(e);
        }
        return objects;
    }

    public static void main(String[] args) {
        new PascalTriangle().generate(5);
    }
}
