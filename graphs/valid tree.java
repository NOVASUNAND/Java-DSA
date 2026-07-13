import java.util.*;

public class Solution {
    public boolean validTree(int n, int[][] edges) {
        // Rule: A valid tree MUST have exactly n - 1 connections.
        if (edges.length != n - 1) {
            return false;
        }

        // ==========================================
        // PART 1: BUILD THE MAP
        // ==========================================
        ArrayList<Integer>[] map = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            map[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            map[edge[0]].add(edge[1]);
            map[edge[1]].add(edge[0]);
        }

        // ==========================================
        // PART 2: THE QUEUE (No Recursion!)
        // ==========================================
        boolean[] visited = new boolean[n]; // Our checklist
        Queue<Integer> queue = new LinkedList<>(); // Our "To-Do List" line

        // Start by putting Room 0 into the queue to visit it
        queue.add(0);
        visited[0] = true; // Mark it as visited immediately

        // While there are still rooms waiting in our To-Do List line...
        while (!queue.isEmpty()) {
            int currentRoom = queue.poll(); // Step out of the line to explore this room

            // Look at all the doors inside this current room
            for (int neighborRoom : map[currentRoom]) {
                
                // If we haven't put this neighbor room in our queue yet:
                if (visited[neighborRoom] == false) {
                    visited[neighborRoom] = true; // Mark it on our checklist
                    queue.add(neighborRoom);      // Throw it into the back of the queue line
                }
            }
        }

        // ==========================================
        // PART 3: FINAL VERIFICATION
        // ==========================================
        // Count how many rooms our queue actually managed to visit
        int count = 0;
        for (boolean roomVisited : visited) {
            if (roomVisited == true) {
                count++;
            }
        }

        // If we visited every single room, it's a valid tree!
        return count == n;
    }
}