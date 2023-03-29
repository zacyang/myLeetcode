package com.leetcode.second.backtracking;

import java.util.HashSet;

public class NqueensII {
    int count;
    private int n;

    public int totalNQueens(int n) {

        int row = 0;
        this.n = n;
        HashSet<Integer> occupiedCol = new HashSet<>();
        HashSet<Integer> attachingDiaganal = new HashSet<>();
        HashSet<Integer> attachingAntiDiaganal = new HashSet<>();
        backTracking(0, occupiedCol, attachingDiaganal, attachingAntiDiaganal);

        return count;
    }

    private void backTracking(int row, HashSet<Integer> occupiedCol, HashSet<Integer> attachingDiaganal, HashSet<Integer> attachingAntiDiaganal) {
        if (row == n) {
            this.count++;
            return;
        }

//        place queen
        for (int col = 0; col < this.n; col++) {
            if (notUnderAttach(row, col, occupiedCol, attachingDiaganal, attachingAntiDiaganal)) {
                int diaganal = row - col;
                int antiDiagnal = row + col;
//                place queen
                occupiedCol.add(col);
                attachingDiaganal.add(diaganal);
                attachingAntiDiaganal.add(antiDiagnal);

                backTracking(row + 1, occupiedCol, attachingDiaganal, attachingAntiDiaganal);

//                remove queen

                occupiedCol.remove(col);
                attachingDiaganal.remove(diaganal);
                attachingAntiDiaganal.remove(antiDiagnal);

            }
        }
    }

    private boolean notUnderAttach(int row, int col, HashSet<Integer> occupiedCol, HashSet<Integer> attachingDiaganal, HashSet<Integer> attachingAntiDiaganal) {
        if (occupiedCol.contains(col) || attachingDiaganal.contains(row - col) || attachingAntiDiaganal.contains(row + col)) {
            return false;
        } else {
            return true;
        }
    }

    public static void main(String[] args) {
        int i = new NqueensII().totalNQueens(1);
        System.out.println(i);
    }
}
