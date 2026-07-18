import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static class MazeCell {
        int row;
        int col;
        int steps;

        MazeCell(int row, int col, int steps) {
            this.row = row;
            this.col = col;
            this.steps = steps;
        }
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        int totalrows = grid.length;
        int totalcolumns = grid[0].length;

        // Base Case: If start or end is blocked (1), no path can exist
        if (grid[0][0] == 1 || grid[totalrows - 1][totalcolumns - 1] == 1) {
            return -1;
        }

        // Single cell edge case: If grid is 1x1 and open, path length is 1 cell
        if (totalrows == 1 && totalcolumns == 1) {
            return 1;
        }

        Queue<MazeCell> q = new LinkedList<>();
        int[][] notebook = new int[totalrows][totalcolumns];
        
        for (int i = 0; i < totalrows; i++) {
            for (int j = 0; j < totalcolumns; j++) {
                notebook[i][j] = Integer.MAX_VALUE;
            }
        }

        // CORRECTION: Start step count at 1 because the starting cell counts as part of the path
        int startrow = 0;
        int startcolumn = 0;
        notebook[startrow][startcolumn] = 1;
        q.add(new MazeCell(startrow, startcolumn, 1));

        // CORRECTION: Expanded offset arrays to check all 8 directions (including diagonals)
        int[] rowoffsets = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] columnoffsets = {-1, 0, 1, -1, 1, -1, 0, 1};

        while (!q.isEmpty()) {
            MazeCell current = q.poll();
            
            // Loop 8 times instead of 4
            for (int i = 0; i < 8; i++) {
                int nextrow = current.row + rowoffsets[i];
                int nextcolumn = current.col + columnoffsets[i];
                int nextstepcount = current.steps + 1;

                if (nextrow >= 0 && nextrow < totalrows && 
                    nextcolumn >= 0 && nextcolumn < totalcolumns && 
                    grid[nextrow][nextcolumn] == 0) {
                    
                    if (nextstepcount < notebook[nextrow][nextcolumn]) {
                        notebook[nextrow][nextcolumn] = nextstepcount;
                        
                        // If we reached the bottom-right corner, return the cell count
                        if (nextrow == totalrows - 1 && nextcolumn == totalcolumns - 1) {
                            return nextstepcount;
                        }
                        
                        q.add(new MazeCell(nextrow, nextcolumn, nextstepcount));
                    }
                }
            }
        }
        return -1;
    }
}
