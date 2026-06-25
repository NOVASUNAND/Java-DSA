public class RatInMaze {

    static int N = 4;

    static boolean solve(int[][] maze, int x, int y,
                         boolean[][] visited, int[][] path) {

        // Destination reached
        if (x == N - 1 && y == N - 1) {
            path[x][y] = 1;
            return true;
        }

        // Boundary, blocked cell, or already visited
        if (x < 0 || x >= N || y < 0 || y >= N
                || maze[x][y] == 0
                || visited[x][y]) {
            return false;
        }

        // Mark current cell
        visited[x][y] = true;
        path[x][y] = 1;

        // Down
        if (solve(maze, x + 1, y, visited, path))
            return true;

        // Right
        if (solve(maze, x, y + 1, visited, path))
            return true;

        // Up
        if (solve(maze, x - 1, y, visited, path))
            return true;

        // Left
        if (solve(maze, x, y - 1, visited, path))
            return true;

        // Backtrack
        visited[x][y] = false;
        path[x][y] = 0;

        return false;
    }

    static void printPath(int[][] path) {
        for (int[] row : path) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        int[][] maze = {
                {1, 0, 0, 0},
                {1, 1, 0, 1},
                {0, 1, 0, 0},
                {1, 1, 1, 1}
        };

        boolean[][] visited = new boolean[N][N];
        int[][] path = new int[N][N];

        if (solve(maze, 0, 0, visited, path)) {
            printPath(path);
        } else {
            System.out.println("No Path Found");
        }
    }
}