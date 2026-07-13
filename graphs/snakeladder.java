import java.util.*;

public class Solution {
    public int minDiceRolls(int[][] moves) {
        // Step 1: Initialize our board array (Squares 1 to 36)
        int[] board = new int[37];
        Arrays.fill(board, -1); // -1 means a normal square with no snakes/ladders

        // Fill the board with the ladders and snakes given in the input
        for (int[] move : moves) {
            int start = move[0];
            int end = move[1];
            board[start] = end; // e.g., board[3] = 7 means square 3 moves you to 7
        }

        // Step 2: Set up the BFS Queue and a visited checklist
        // The queue will hold a tiny 2-element array: [squareNumber, rollsCount]
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[37];

        // Start at square 1 with 0 dice rolls
        queue.add(new int[]{1, 0});
        visited[1] = true;

        // Step 3: Process the queue layer-by-layer
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentSquare = current[0];
            int rolls = current[1];

            // If we managed to stand on square 36, we win! 
            // (BFS guarantees this is the minimum path)
            if (currentSquare == 36) {
                return rolls;
            }

            // Simulate rolling a 6-sided die (values 1 to 6)
            for (int die = 1; die <= 6; die++) {
                int nextSquare = currentSquare + die;

                // Don't jump off the edge of the board
                if (nextSquare <= 36) {
                    
                    // Step 4: If there is a snake or ladder, take it!
                    if (board[nextSquare] != -1) {
                        nextSquare = board[nextSquare]; 
                    }

                    // If we haven't processed this landing square yet
                    if (!visited[nextSquare]) {
                        visited[nextSquare] = true;
                        queue.add(new int[]{nextSquare, rolls + 1}); // Add to queue with 1 more roll
                    }
                }
            }
        }

        return -1; // Return -1 if it's impossible to reach square 36
    }
}