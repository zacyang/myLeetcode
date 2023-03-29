package com.leetcode.second.atlassian;

import java.util.*;


class Coordinate {
    int row;
    int column;

    public Coordinate(int row, int column) {
        this.row = row;
        this.column = column;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Coordinate)) return false;

        Coordinate that = (Coordinate) o;

        if (row != that.row) return false;
        return column == that.column;
    }

    @Override
    public int hashCode() {
        int result = row;
        result = 31 * result + column;
        return result;
    }
}

public class DesignSnakeGame {
    private Deque<Coordinate> snakeBody;

    private int[][] board;
    int score;

    private Queue<Coordinate> foodPosition;

    public DesignSnakeGame(int width, int height, int[][] food) {
        snakeBody = new LinkedList();
        snakeBody.addFirst(new Coordinate(0, 0));
        board = new int[height][width];
        this.foodPosition = new LinkedList<>();
        for (int[] arrayCord : food) {
            foodPosition.add(new Coordinate(arrayCord[0], arrayCord[1]));
        }
    }

    public int move(String direction) {
        Coordinate nextHeadPosition = moveTo(snakeBody, direction);
        boolean collision = checkIfSnakeCollides(snakeBody, nextHeadPosition, board);

        if (!collision) {
            snakeBody.addFirst(nextHeadPosition);
            if (foodIsIn(nextHeadPosition)) {
                foodPosition.poll();
                score++;
            } else {
                snakeBody.removeLast();
            }
            return score;
        } else {
            return -1;
        }
    }

    private boolean foodIsIn(Coordinate nextHeadPosition) {
        return !foodPosition.isEmpty() && foodPosition.peek().equals(nextHeadPosition);
    }

    private boolean checkIfSnakeCollides(Deque<Coordinate> snakeBody, Coordinate nextHeadPosition, int[][] board) {
        //            edge case should check moving both head and tail

        if (nextHeadPosition.row < 0 || nextHeadPosition.row >= board.length || nextHeadPosition.column < 0 || nextHeadPosition.column >= board[0].length ||
                !snakeBody.peekLast().equals(nextHeadPosition) && snakeBody.contains(nextHeadPosition)) {
            return true;
        }
        return false;
    }

    private Coordinate moveTo(Deque<Coordinate> snakeBody, String direction) {
        Coordinate head = snakeBody.peek();
        switch (direction) {
            case "L":
                return new Coordinate(head.row, head.column - 1);

            case "R":
                return new Coordinate(head.row, head.column + 1);
            case "D":
                return new Coordinate(head.row + 1, head.column);
            case "U":
                return new Coordinate(head.row - 1, head.column);
            default:
                break;
        }

        return head;

    }

    public static void main(String[] args) {
        DesignSnakeGame snakeGame = new DesignSnakeGame(3, 3, new int[][]{new int[]{2, 0}, new int[]{0, 0}, new int[]{0, 2}, new int[]{2, 2},});
        snakeGame.move("D"); // return 0
        snakeGame.move("D"); // return 0
        snakeGame.move("R"); // return 1, snake eats the first piece of food. The second piece of food appears at (0, 1).
        snakeGame.move("U"); // return 1
        snakeGame.move("U"); // return 1
        System.out.println(snakeGame.move("L")); // return 2, snake eats the second food. No more food appears.
        snakeGame.move("D"); // return 0
        snakeGame.move("R"); // return 0
        snakeGame.move("R"); // return 0
        snakeGame.move("U");
        snakeGame.move("L");
        snakeGame.move("D");
    }
}
