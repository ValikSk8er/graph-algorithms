package com.valiksk8.algo;

public class MazeBacktracking {

    static final int WAY = 0;
    static final int WALL = 1;
    static final int STARTING_POINT = 2;
    static final int DESTINATION = 3;

    public static final int[][] MAZE = new int[][]{
            {2, 0, 0, 0, 0},
            {1, 1, 0, 1, 0},
            {0, 0, 0, 1, 0},
            {1, 1, 1, 1, 0},
            {0, 0, 0, 1, 3},
    };

    public static void showPaths(int[][] maze) {
        String[][] result = new String[maze.length][maze[0].length];

        for (int y = 0; y < maze.length; y++) {
            for (int x = 0; x < maze[0].length; x++) {
                int currentPosition = maze[y][x];

                if (currentPosition == WALL) {
                    result[y][x] = "-";
                } else if (currentPosition == STARTING_POINT) {
                    result[y][x] = String.valueOf(STARTING_POINT);
                } else if (currentPosition == DESTINATION) {
                    result[y][x] = String.valueOf(DESTINATION);
                } else if (currentPosition == WAY) {
                    result[y][x] = "S";
                }
            }
        }

        showResult(result);
    }

    private static void showResult(String[][] result) {
        for (int y = 0; y < result.length; y++) {
            for (int x = 0; x < result[0].length; x++) {
                System.out.print(result[y][x] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        MazeBacktracking.showPaths(MazeBacktracking.MAZE);
        System.out.println();
        MazeSolver mazeSolver = new MazeSolver(MAZE, 0, 0);
        mazeSolver.findWay();
    }
}
