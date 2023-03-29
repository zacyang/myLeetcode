package com.leetcode.second.array;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {

        for (int row = 0; row < board.length; row+=3) {
            for (int column = 0; column < board[0].length; column+=3) {
                if(!this.valid3By3(board, row, column)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean valid3By3(char[][] board, int row, int column) {
        Set<Integer> register = new HashSet<>();
        int digitsCount=0;
        for (int i = row; i < row+3; i++) {
            for (int j = column; j < column+3; j++) {
               if(board[i][j]!='.') {
                   if(!Character.isDigit(board[i][j])) {
                       return false;
                   }
                   register.add(Integer.valueOf(board[i][j]));
                   digitsCount++;
               }

            }
        }
        return register.size() < digitsCount;
    }
}
