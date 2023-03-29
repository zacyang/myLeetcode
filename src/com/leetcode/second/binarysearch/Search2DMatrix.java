package com.leetcode.second.binarysearch;

public class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int numOfColumn = matrix[0].length;
        int numOfRow = matrix.length;
        int start =0;
        int end = numOfRow * numOfColumn -1;

        while(start<=end) {
            int middle = (start+ end)/2;
            int elementVal = matrix[middle / numOfColumn][middle % numOfColumn];
            if(target== elementVal) {
                return true;
            }

            if(target<elementVal) {
                end = middle -1;
            }else {
                start = middle +1;
            }

        }
        return false;


    }

    public static void main(String[] args) {
        boolean b = new Search2DMatrix().searchMatrix(new int[][]{

                new int[]{1, 3, 5, 7},
                new int[]{10, 11, 16, 20},
                new int[]{23, 30, 34, 60}
        }, 20);
        System.out.println(b);
    }
}
