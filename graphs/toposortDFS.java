import java.util.*;

class Solution {
    
    // DFS Helper Function
    private static void dfs(int node, int[] vis, Stack<Integer> st, ArrayList<ArrayList<Integer>> adj) {
        vis[node] = 1; // Mark as visited
        
        // Visit all unvisited neighbors
        for (int neighbor : adj.get(node)) {
            if (vis[neighbor] == 0) {
                dfs(neighbor, vis, st, adj);
            }
        }
        
        // Push current node to stack ONLY after all neighbors are fully processed
        st.push(node);
    }
    
    // Function to return list containing vertices in Topological order.
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] vis = new int[V];
        Stack<Integer> st = new Stack<Integer>();
        
        // Ensure all disconnected components are visited
        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                dfs(i, vis, st, adj);
            }
        }
        
        // Pop from stack to get the correct topological order
        int[] ans = new int[V];
        int i = 0;
        while (!st.isEmpty()) {
            ans[i++] = st.pop(); // Your cleaner logic!
        }
        
        return ans;
    }
}
