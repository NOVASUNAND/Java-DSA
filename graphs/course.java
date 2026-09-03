import java.util.ArrayList;
import java.util.List;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 1. Build adjacency list: prereq -> course (b -> a)
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] pair : prerequisites) {
            int course = pair[0];
            int prereq = pair[1];
            adj.get(prereq).add(course);
        }

        // 2. State array:
        //    0 = Unvisited
        //    1 = Visiting (currently in the active recursion call stack)
        //    2 = Visited (fully explored, known to be cycle-free)
        int[] state = new int[numCourses];

        // 3. Run DFS for every unvisited node to cover disconnected components
        for (int i = 0; i < numCourses; i++) {
            if (state[i] == 0) {
                // If a cycle is detected, we cannot finish all courses
                if (hasCycleDFS(i, adj, state)) {
                    return false;
                }
            }
        }

        // No cycle found anywhere in the graph
        return true;
    }

    private boolean hasCycleDFS(int course, List<List<Integer>> adj, int[] state) {
        // Mark node as currently visiting (active in recursion stack)
        state[course] = 1;

        for (int nextCourse : adj.get(course)) {
            // Case 1: Neighbor is already in the current recursion path -> CYCLE!
            if (state[nextCourse] == 1) {
                return true;
            }

            // Case 2: Neighbor not yet visited -> explore recursively
            if (state[nextCourse] == 0) {
                if (hasCycleDFS(nextCourse, adj, state)) {
                    return true;
                }
            }

            // Case 3: state[nextCourse] == 2 -> already fully explored and safe, skip!
        }

        // Backtrack / finalize: All descendants are explored with no cycles
        state[course] = 2;
        return false;
    }
}
