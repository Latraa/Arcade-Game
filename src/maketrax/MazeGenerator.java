package maketrax;

import java.util.*;

public class MazeGenerator {
    private int[][] maze;
    private final Random rand = new Random();

    private final int[] dr = {-1, 1, 0, 0};
    private final int[] dc = {0, 0, -1, 1};
    public int[][] generate(int rows, int cols) {
        maze = new int[rows][cols];
        for (int[] row : maze) {
            Arrays.fill(row, 1);
        }

        dfs(1, 1);
        removeDeadEnds();

        return maze;
    }
    private void dfs(int r, int c) {
        if (r > 0 && r < maze.length - 1 &&
                c > 0 && c < maze[0].length - 1 &&
                maze[r][c] == 1) {

            maze[r][c] = 0;

            if (r > 1 && maze[r - 2][c] == 0)
                maze[r - 1][c] = 0;

            else if (r < maze.length - 2 && maze[r + 2][c] == 0)
                maze[r + 1][c] = 0;

            else if (c > 1 && maze[r][c - 2] == 0)
                maze[r][c - 1] = 0;

            else if (c < maze[0].length - 2 && maze[r][c + 2] == 0)
                maze[r][c + 1] = 0;

            dfs(r - 2, c);
            dfs(r + 2, c);
            dfs(r, c - 2);
            dfs(r, c + 2);
        }
    }

    private void removeDeadEnds() {
        for (int r = 1; r < maze.length - 1; r += 2) {
            for (int c = 1; c < maze[0].length - 1; c += 2) {
                int paths = 0;
                ArrayList<Integer> walls = new ArrayList<>();

                for (int d = 0; d < 4; d++) {
                    if (maze[r + dr[d]][c + dc[d]] == 0) {
                        paths++;
                    } else if (inside(r + dr[d] * 2, c + dc[d] * 2)) {
                        walls.add(d);
                    }
                }
                if (paths == 1 && !walls.isEmpty()) {
                    int d = walls.get(rand.nextInt(walls.size()));
                    maze[r + dr[d]][c + dc[d]] = 0;
                }
            }
        }
    }

    private boolean inside(int r, int c) {
        return r > 0 && r < maze.length - 1
                && c > 0 && c < maze[0].length - 1;
    }
}