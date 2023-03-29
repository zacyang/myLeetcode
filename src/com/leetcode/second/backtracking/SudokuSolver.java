package com.leetcode.second.backtracking;

public class SudokuSolver {
//    public void solveSudoku(char[][] board) {
//        backTrack(0, 0, board);
//
//    }
//
//    private void backTrack(int row, int col, char[][] board) {
//        if (row == board.length && col == board[0].length) {
////            find a solution
//            return;
//        }
//
////        place a candidate number into next avaiblle slot
//        int[] nums = generateCandidateNumber(board, row, col);
//
//        for (int i = 0; i < nums.length; i++) {
//
//            char c = Character.forDigit(nums[i], 1);
//            if (canPlace(row, col, board, c)) {
//                board[row][col] = c;
//
//                if (col < board[0].length) {
//                    col++;
//                } else {
//                    col = 0;
//                    row++;
//                }
//                backTrack(row, col, board);
//            }
//
//        }
//    }

    private int[] generateCandidateNumber(char[][] board, int row, int col) {
        return new int[0];
    }
}
