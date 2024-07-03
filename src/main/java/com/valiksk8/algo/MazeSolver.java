package com.valiksk8.algo;

public class MazeSolver {
    static final int WAY = 0;
    static final int WALL = 1;
    static final int STARTING_POINT = 2;
    static final int DESTINATION = 3;

    private int[][] maze;
    private boolean[][] visited;
    private int startRow;
    private int startCol;

    public MazeSolver(int[][] maze, int startRow, int startCol) {
        this.maze = maze;
        visited = new boolean[maze.length][maze.length];
        this.startRow = startRow;
        this.startCol = startCol;
    }

    public void findWay() {
        if (dfs(startRow, startCol)) {
            System.out.println("Solution exists ...");
            printWay();
        } else {
            System.out.println("No solution exists ...");
        }
    }

    private void printWay() {
        for (int y = 0; y < visited.length; y++) {
            for (int x = 0; x < visited[0].length; x++) {
                if (y == startRow && x == startCol) {
                    System.out.print("2 ");
                // if finish found
                } else  if (x == maze.length - 1 && y == maze.length - 1) {
                    System.out.print("3 ");
                } else if (visited[y][x]) {
                    System.out.print("S ");
                } else {
                    System.out.print("- ");
                }
            }
            System.out.println();
        }
    }

    private boolean dfs(int x, int y) {
        //if finish found
        if (x == maze.length - 1 && y == maze.length - 1) {
            visited[x][y] = true;
            return true;
        }
        if (isFeasible(x,y)) {
            visited[x][y] = true;

            //going right
            if (dfs(x + 1, y)) {
                return true;
            }
            // going left
            if (dfs(x - 1, y)) {
                return true;
            }
            // going up
            if (dfs(x, y - 1)) {
                return true;
            }
            // going down
            if (dfs(x, y + 1)) {
                return true;
            }

            //backtrack
            visited[x][y] = false;
            return false;
        }

        return false;
    }

    private boolean isFeasible(int x, int y) {
        //check the vertical dimension
        if (x < 0 || x > maze.length - 1) {
            return false;
        }
        //check the horizontal dimension
        if (y < 0 || y > maze.length - 1) {
            return false;
        }
        if (visited[x][y]) {
            return false;
        }
        if (maze[x][y] == WALL) {
            return false;
        }
        return true;
    }
}
