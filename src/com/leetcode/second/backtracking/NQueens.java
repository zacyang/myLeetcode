package com.leetcode.second.backtracking;

import java.util.*;

public class NQueens {
    List<List<int[]>> queenPlacements = new ArrayList<>();
    private int size;

    public List<List<String>> solveNQueens(int n) {

        this.size = n;

        backTracking(0, new HashSet<>(), new HashSet<>(), new HashSet<>(), new LinkedList<>());

        return convertToBoard(queenPlacements);
    }


    private void backTracking(int row, Set<Integer> attachedCols, Set<Integer> attachedDiagonal, Set<Integer> attachAntiDiagonal, LinkedList<int[]> queenPlacement) {

        if (row == size) {
//                    deep copy
            LinkedList<int[]> copyOfQueenPlacement = new LinkedList<>();
            copyOfQueenPlacement.addAll(queenPlacement);
            queenPlacements.add(copyOfQueenPlacement);
            return;
        }
        for (int column = 0; column < this.size; column++) {

            if (notUnderAttach(row, column, attachedCols, attachedDiagonal, attachAntiDiagonal)) {

                placeQueen(queenPlacement, attachedCols, attachedDiagonal, attachAntiDiagonal, row, column);
                backTracking(row + 1, attachedCols, attachedDiagonal, attachAntiDiagonal, queenPlacement);
                removeQueen(queenPlacement, attachedCols, attachedDiagonal, attachAntiDiagonal, row, column);
            }
        }

    }

    private void removeQueen(LinkedList<int[]> queenPlacement, Set<Integer> attachedCols, Set<Integer> attachedDiagonal, Set<Integer> attachAntiDiagonal, int row, int column) {
        queenPlacement.removeLast();
        attachedCols.remove(column);
        attachedDiagonal.remove(row - column);
        attachAntiDiagonal.remove(row + column);
    }

    private void placeQueen(List<int[]> queenPlacement, Set<Integer> attachedCols, Set<Integer> attachedDiagonal, Set<Integer> attachAntiDiagonal, int row, int column) {
        queenPlacement.add(new int[]{row, column});

        attachedCols.add(column);
        attachedDiagonal.add(row - column);
        attachAntiDiagonal.add(row + column);
    }

    private boolean notUnderAttach(int row, int column, Set<Integer> attachedCols, Set<Integer> attachedDiagonal, Set<Integer> attachAntiDiagonal) {
        if (attachAntiDiagonal.contains(row + column) || attachedDiagonal.contains(row - column) || attachedCols.contains(column)) {
            return false;
        }
        return true;
    }

    private List<List<String>> convertToBoard(List<List<int[]>> queenPlacements) {
        List<List<String>> result = new LinkedList<>();
        for (List<int[]> queenPlacement : queenPlacements) {

            LinkedList<String> strResentationOfQueens = new LinkedList<>();
            for (int row = 0; row < size; row++) {

                String rowStr = "";
                for (int column = 0; column < size; column++) {
                    int[] queenCord = queenPlacement.get(row);
                    if (row == queenCord[0] && column == queenCord[1]) {
                        rowStr += "Q";

                    } else {
                        rowStr += ".";
                    }
                }
                strResentationOfQueens.add(rowStr);
            }

            result.add(strResentationOfQueens);
        }
        return result;

    }

    public static void main(String[] args) {
        new NQueens().solveNQueens(4);
    }
}
