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
        int[] dRow = {-1, 1, 0, 0}; // Up, Down, Left, Right
        int[] dCol = {0, 0, -1, 1};
        
        for (int r = 0; r < h; r++) {
            for (int c = 0; c < w; c++) {
                // If cell is not painted yet
                if (grid[r][c] != '#') {
                    strokes++; 
                    
                    // Start BFS
                    Queue<int[]> queue = new LinkedList<>();
                    queue.add(new int[]{r, c});
                    char color = grid[r][c];
                    grid[r][c] = '#'; // Mark as painted IMMEDIATELY
                    
                    while (!queue.isEmpty()) {
                        int[] current = queue.poll();
                        int currR = current[0];
                        int currC = current[1];
                        
                        // Check all 4 neighbors
                        for (int i = 0; i < 4; i++) {
                            int nextR = currR + dRow[i];
                            int nextC = currC + dCol[i];
                            
                            // If within bounds and matches the target color
                            if (nextR >= 0 && nextR < h && nextC >= 0 && nextC < w && grid[nextR][nextC] == color) {
                                grid[nextR][nextC] = '#'; // Mark as painted
                                queue.add(new int[]{nextR, nextC});
                            }
                        }
                    }
                }
            }
        }
        return strokes;
    }
}
