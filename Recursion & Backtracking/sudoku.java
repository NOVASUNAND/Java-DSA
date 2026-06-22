class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private boolean solve(char[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                
                // LeetCode uses '.' for empty cells
                if (board[row][col] == '.') {
                    for (char num = '1'; num <= '9'; num++) {
                        
                        // Using our 3 distinct validation functions
                        if (isSafeInRow(board, row, num) && 
                            isSafeInCol(board, col, num) && 
                            isSafeInBox(board, row, col, num)) {
                            
                            board[row][col] = num; // Make the move

                            if (solve(board)) {
                                return true; // Found a solution!
                            }

                            board[row][col] = '.'; // Backtrack (undo move)
                        }
                    }
                    return false; // No number 1-9 fits here; trigger backtracking
                }
            }
        }
        return true; // Entire board successfully filled
    }

    // Function 1: Checks if the character already exists in the row
    private boolean isSafeInRow(char[][] board, int row, char num) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num) {
                return false;
            }
        }
        return true;
    }

    // Function 2: Checks if the character already exists in the column
    private boolean isSafeInCol(char[][] board, int col, char num) {
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == num) {
                return false;
            }
        }
        return true;
    }

    // Function 3: Checks if the character already exists in the 3x3 box
    private boolean isSafeInBox(char[][] board, int row, int col, char num) {
        int boxRowStart = row - row % 3;
        int boxColStart = col - col % 3;

        for (int r = boxRowStart; r < boxRowStart + 3; r++) {
            for (int c = boxColStart; c < boxColStart + 3; c++) {
                if (board[r][c] == num) {
                    return false;
                }
            }
        }
        return true;
    }
}