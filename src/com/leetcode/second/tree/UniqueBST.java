package com.leetcode.second.tree;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class UniqueBST {

    public int numTrees(int n) {
        int[] dpTable = new int[n + 1];

        dpTable[0] = 1;
        dpTable[1] = 1;
        for (int totalNumberOfNodes = 2; totalNumberOfNodes < n + 1; totalNumberOfNodes++) {
            int sum = 0;
            for (int rootIdx = 0; rootIdx < totalNumberOfNodes; rootIdx++) {
                int numberOfLeft = dpTable[rootIdx];
                int numerOfRight = dpTable[totalNumberOfNodes - rootIdx - 1];
                sum += numberOfLeft * numerOfRight;

            }
            dpTable[totalNumberOfNodes] = sum;
        }
        return dpTable[n];

    }


}
