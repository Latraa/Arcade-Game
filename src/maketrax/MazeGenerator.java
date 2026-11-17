package maketrax;

import java.util.*;

public class MazeGenerator {
    private int[][] maze;
    private ArrayList<Integer> rowPoints;
    private ArrayList<Integer> colPoints;
    private final Random rand = new Random();
    private final int[] dr = {-1, 1, 0, 0};
    private final int[] dc = {0, 0, -1, 1};

    public int[][] generate(int rows, int cols) {
        if (rows < 15 || cols < 23 || rows % 2 == 0 || cols % 2 == 0) {
            throw new IllegalArgumentException("Use odd sizes, at least 15 by 23.");
        }
        maze = new int[rows][cols];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                maze[r][c] = 1;
            }
        }
        rowPoints = points(rows - 2);
        colPoints = points(cols - 2);
        dfs(0, 0);
        removeDeadEnds();

        carve(1, 1, 1, cols - 2);
        carve(rows - 2, 1, rows - 2, cols - 2);
        carve(1, 1, rows - 2, 1);
        carve(1, cols - 2, rows - 2, cols - 2);

        int middleR = rowPoints.get(rowPoints.size() / 2);
        int middleC = colPoints.get(colPoints.size() / 2);
        for (int r = middleR - 1; r <= middleR + 1; r++) {
            for (int c = middleC - 1; c <= middleC + 1; c++) {
                maze[r][c] = 0;
            }
        }
        return maze;
    }

    private ArrayList<Integer> points(int last) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i < last; i += 4) {
            list.add(i);
        }
        list.add(last);
        return list;
    }

    private void dfs(int r, int c) {
        maze[rowPoints.get(r)][colPoints.get(c)] = 0;
        ArrayList<Integer> directions = new ArrayList<>();
        for (int d = 0; d < 4; d++) {
            directions.add(d);
        }
        Collections.shuffle(directions, rand);
        for (int d : directions) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            if (inside(nr, nc) && maze[rowPoints.get(nr)][colPoints.get(nc)] == 1) {
                carve(rowPoints.get(r), colPoints.get(c), rowPoints.get(nr), colPoints.get(nc));
                dfs(nr, nc);
            }
        }
    }

    private void removeDeadEnds() {
        for (int r = 0; r < rowPoints.size(); r++) {
            for (int c = 0; c < colPoints.size(); c++) {
                int y = rowPoints.get(r);
                int x = colPoints.get(c);
                int paths = 0;
                ArrayList<Integer> walls = new ArrayList<>();
                for (int d = 0; d < 4; d++) {
                    if (inside(r + dr[d], c + dc[d])) {
                        if (maze[y + dr[d]][x + dc[d]] == 0) {
                            paths++;
                        } else {
                            walls.add(d);
                        }
                    }
                }
                if (paths == 1 && !walls.isEmpty()) {
                    int d = walls.get(rand.nextInt(walls.size()));
                    carve(y, x, rowPoints.get(r + dr[d]), colPoints.get(c + dc[d]));
                }
            }
        }
    }

    private boolean inside(int r, int c) {
        return r >= 0 && r < rowPoints.size() && c >= 0 && c < colPoints.size();
    }

    private void carve(int r, int c, int endR, int endC) {
        for (int y = Math.min(r, endR); y <= Math.max(r, endR); y++) {
            for (int x = Math.min(c, endC); x <= Math.max(c, endC); x++) {
                maze[y][x] = 0;
            }
        }
    }

    public static void main(String[] args) {
        MazeGenerator generator = new MazeGenerator();
        int[][] maze = generator.generate(27, 39);
        for (int r = 0; r < maze.length; r++) {
            for (int c = 0; c < maze[r].length; c++) {
                if (maze[r][c] == 1) {
                    System.out.print("██");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
}
