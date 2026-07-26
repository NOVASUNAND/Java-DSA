import java.util.*;

class Solution {
    public static int strokeCount(List<String> picture) {
        if (picture == null || picture.size() == 0) return 0;

        int h = picture.size();
        int w = picture.get(0).length();
        char[][] grid = new char[h][w];
        
        for (int i = 0; i < h; i++) {
            grid[i] = picture.get(i).toCharArray();
        }

        int strokes = 0;
        
        for (int r = 0; r < h; r++) {
            for (int c = 0; c < w; c++) {
                // If cell is not painted yet
                if (grid[r][c] != '#') {
                    strokes++; 
                    dfs(grid, r, c, grid[r][c], h, w); // Paint the whole region
                }
            }
        }
        return strokes;
    }

    private static void dfs(char[][] grid, int r, int c, char color, int h, int w) {
        // Base case: out of bounds OR different color OR already visited
        if (r < 0 || r >= h || c < 0 || c >= w || grid[r][c] != color) {
            return;
        }

        // Paint it
        grid[r][c] = '#';

        // Visit 4 neighbors (Up, Down, Left, Right)
        dfs(grid, r - 1, c, color, h, w); // Up
        dfs(grid, r + 1, c, color, h, w); // Down
        dfs(grid, r, c - 1, color, h, w); // Left
        dfs(grid, r, c + 1, color, h, w); // Right
    }
}
