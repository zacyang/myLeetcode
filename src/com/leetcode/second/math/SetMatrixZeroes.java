package com.leetcode.second.math;

import java.util.Arrays;

public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {

        if(matrix.length ==0 || matrix[0].length==0){
            return;
        }

        int[] rowIndicator = new int[matrix.length];
        int[] columnIndicator = new int[matrix[0].length];
        Arrays.fill(rowIndicator, 1);
        Arrays.fill(columnIndicator, 1);

        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                if(matrix[row][column] == 0 ) {
                    rowIndicator[row] = 0;
                    columnIndicator[column] = 0;
                }
            }
        }

        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                if(rowIndicator[row] == 0 || columnIndicator[column] ==0) {
                    matrix[row][column] =0;
                }
            }
        }

    }


}
