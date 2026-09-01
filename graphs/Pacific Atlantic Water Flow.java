

class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        if (heights == null || heights.length == 0 || heights[0].length == 0) {
            return result;
        }

        int rows = heights.length;
        int cols = heights[0].length;

        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        // 1. Run DFS from top (Pacific) and bottom (Atlantic) borders
        for (int c = 0; c < cols; c++) {
            dfs(heights, pacific, 0, c, heights[0][c]);                   // Pacific Top
            dfs(heights, atlantic, rows - 1, c, heights[rows - 1][c]);    // Atlantic Bottom
        }

        // 2. Run DFS from left (Pacific) and right (Atlantic) borders
        for (int r = 0; r < rows; r++) {
            dfs(heights, pacific, r, 0, heights[r][0]);                   // Pacific Left
            dfs(heights, atlantic, r, cols - 1, heights[r][cols - 1]);    // Atlantic Right
        }

        // 3. Collect all cells reachable by both oceans
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (pacific[r][c] && atlantic[r][c]) {
                    result.add(Arrays.asList(r, c));
                }
            }
        }

        return result;
    }

    private void dfs(int[][] heights, boolean[][] reachable, int r, int c, int prevHeight) {
        int rows = heights.length;
        int cols = heights[0].length;

        // Boundary, visited, and uphill height check
        if (r < 0 || r >= rows || c < 0 || c >= cols) return;
        if (reachable[r][c] || heights[r][c] < prevHeight) return;

        reachable[r][c] = true;

        // Explore 4 adjacent neighbors going uphill
        dfs(heights, reachable, r + 1, c, heights[r][c]); // Down
        dfs(heights, reachable, r - 1, c, heights[r][c]); // Up
        dfs(heights, reachable, r, c + 1, heights[r][c]); // Right
        dfs(heights, reachable, r, c - 1, heights[r][c]); // Left
    }
}
