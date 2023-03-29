package com.leetcode.second.stackq;

public class RotatingBox {
    public char[][] rotateTheBox(char[][] box) {
        char[][] result = new char[box[0].length][box.length];
        int col =result[0].length-1;

        for (char[] row : box) {
            int numberOfFall = 0;
            for (int i = row.length - 1; i >= 0; i--) {

                if (row[i] == '.') {
                    numberOfFall++;
                }
                if (row[i] == '*') {
                    numberOfFall = 0;
                }
                if (row[i] == '#' && numberOfFall > 0) {
                    row[i+numberOfFall] = row[i];
                    row[i] = '.';
                }
            }

            for (int newRow = 0; newRow < result.length; newRow++) {
                result[newRow][col] = row[newRow];

            }
            col--;
        }



        return result;
    }

    public static void main(String[] args) {
//        char[][] chars = new RotatingBox().rotateTheBox(new char[][]{new char[]{'#', '.', '#'},});
        char[][] chars = new RotatingBox().rotateTheBox(new char[][]{new char[]{'*', '#', '*', '.', '.', '.', '#', '.', '*', '.'},});
//        char[][] chars = new RotatingBox().rotateTheBox(new char[][]{
//                new char[]{'#', '.', '*', '.'},
//                new char[]{'#', '#', '*', '.'},
//        });

        for (char[] aChar : chars) {
            for (char c : aChar) {
                System.out.println(c);
            }
            System.out.println("---");
        }


    }
}
