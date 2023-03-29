package com.leetcode.second.matrix;

public class GameOfLife {
    int[][] directions = new int[][]{new int[]{0, 1}, new int[]{1, 1}, new int[]{1, 0}, new int[]{1, -1}, new int[]{0, -1}, new int[]{-1, -1}, new int[]{-1, 0}, new int[]{-1, 1},

    };

    public void gameOfLife(int[][] board) {
//        int[][] nextStage = new int[board.length][board[0].length];


        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                int numberOfLivingNeighbours = getLiveN(row, col, board);

                if (board[row][col] == 0 && numberOfLivingNeighbours == 3) {
                    board[row][col] = 2;
                }

                if (board[row][col] == 1) {
                    if (numberOfLivingNeighbours < 2 || numberOfLivingNeighbours > 3) {
                        board[row][col] = -1;
                    } else if (numberOfLivingNeighbours <= 3) {
                        board[row][col] = 1;
                    }
                }
            }
        }


//        updateToNextStage(board, nextStage);
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {

                if(board[row][col] == 2) {
                    board[row][col] = 1;
                }
                if(board[row][col] == -1) {
                    board[row][col] = 0;
                }

            }
        }

    }

    private void updateToNextStage(int[][] board, int[][] nextStage) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {

                board[row][col] = nextStage[row][col];
            }
        }
    }

    private int getLiveN(int row, int col, int[][] board) {
        int result = 0;
        for (int[] direction : this.directions) {

            if (row + direction[0] >= 0 && row + direction[0] < board.length & col + direction[1] >= 0 && col + direction[1] < board[0].length) {
                if (board[row + direction[0]][col + direction[1]] == 1 || board[row + direction[0]][col + direction[1]] == -1) {
                    result++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        new GameOfLife().gameOfLife(new int[][]{new int[]{0, 1, 0}, new int[]{0, 0, 1}, new int[]{1, 1, 1}, new int[]{0, 0, 0},});
    }
}
