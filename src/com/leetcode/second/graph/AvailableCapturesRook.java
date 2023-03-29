package com.leetcode.second.graph;

public class AvailableCapturesRook {
    int[][] directions = new int[][]{new int[]{0, 1}, new int[]{1, 0}, new int[]{0, -1}, new int[]{-1, 0},};

    public int numRookCaptures(char[][] board) {

        int[] rookCord = findCordinationForRoot(board);

        int result = 0;
        for (int[] direction : directions) {

            int[] firstBlocker = moveUntilBlocked(direction, rookCord, board);

            if (board[firstBlocker[0]][firstBlocker[1]] == 'p') {
                result++;
            }
        }

        return result;
    }

    private int[] moveUntilBlocked(int[] direction, int[] rookCord, char[][] board) {
        int[] collassionCord = new int[]{rookCord[0], rookCord[1]};
        while (collassionCord[0] + direction[0] >= 0 && collassionCord[0] + direction[0] < board.length && collassionCord[1] + direction[1] >= 0 && collassionCord[1] + direction[1] < board[0].length) {
            collassionCord[0] += direction[0];
            collassionCord[1] += direction[1];
            if (board[collassionCord[0]][collassionCord[1]] == 'B' || board[collassionCord[0]][collassionCord[1]] == 'p') {
                return collassionCord;
            }
        }
        return collassionCord;
    }

    private int[] findCordinationForRoot(char[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (board[row][col] == 'R') {
                    return new int[]{row, col};
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
//        int i = new AvailableCapturesRook().numRookCaptures(new char[][]{new char[]{'.', '.', '.', '.', '.', '.', '.', '.'}, new char[]{'.', '.', '.', 'p', '.', '.', '.', '.'}, new char[]{'.', '.', '.', 'R', '.', '.', '.', 'p'}, new char[]{'.', '.', '.', '.', '.', '.', '.', '.'}, new char[]{'.', '.', '.', '.', '.', '.', '.', '.'}, new char[]{'.', '.', '.', 'p', '.', '.', '.', '.'}, new char[]{'.', '.', '.', '.', '.', '.', '.', '.'}, new char[]{'.', '.', '.', '.', '.', '.', '.', '.'}});
        int i = new AvailableCapturesRook().numRookCaptures(new char[][]{
                new char[]{'.', '.', '.', '.', '.', '.', 'p', '.'},
                new char[]{'p', '.', '.', '.', '.', '.', 'R', '.'},
                new char[]{'.', '.', '.', '.', '.', '.', '.', '.'},
                new char[]{'.', '.', '.', '.', '.', '.', '.', '.'},
                new char[]{'.', '.', '.', '.', '.', '.', '.', '.'},
                new char[]{'.', '.', '.', '.', '.', '.', '.', '.'},
                new char[]{'.', '.', '.', '.', '.', '.', '.', '.'},
                new char[]{'.', '.', '.', '.', '.', '.', 'p', '.'}});
        System.out.println(i);

    }
}
