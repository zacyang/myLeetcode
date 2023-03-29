package com.leetcode.second.math;

public class RotateImage {
    public void rotate(int[][] matrix) {
//        step 1, trasporse
         for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[i].length; j++) {
                if (i == j) {
                    continue;
                }
                flip(i,j,j,i, matrix);
            }
        }
//        step 2, flip left -> right
         int rowLength = matrix[0].length;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length/2; j++) {

                flip(i,j, i, rowLength-1-j, matrix);
            }
        }
        System.out.println(1);
    }

    private void flip(int idxAx, int idxAy, int idxBx, int idxBy, int[][] matrix) {

        int tmp = matrix[idxBx][idxBy];
        matrix[idxBx][idxBy] = matrix[idxAx][idxAy];
        matrix[idxAx][idxAy] = tmp;

    }

    public static void main(String[] args) {
        new RotateImage().rotate(new int[][] {
                new int[]{1,2,3},
                new int[]{4,5,6},
                new int[]{7,8,9}
        });
    }
}
