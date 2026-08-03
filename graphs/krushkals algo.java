import java.util.*;

// 1. Disjoint Set (Union-Find) Class with Path Compression and Union by Size
class DisjointSet {
    int[] parent;
    int[] size;

    public DisjointSet(int n) {
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    // Find ultimate parent with path compression
    public int findUPar(int node) {
        if (node == parent[node]) {
            return node;
        }
        return parent[node] = findUPar(parent[node]);
    }

    // Union by size
    public void unionBySize(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);

        if (ulp_u == ulp_v) return;

        if (size[ulp_u] < size[ulp_v]) {
            parent[ulp_u] = ulp_v;
            size[ulp_v] += size[ulp_u];
        } else {
            parent[ulp_v] = ulp_u;
            size[ulp_u] += size[ulp_v];
        }
    }
}

class Solution {
    // Function to find sum of weights of edges of the Minimum Spanning Tree
    static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) {
        
        // Step 1: Extract edges into a clean list: {weight, u, v}
        List<int[]> edges = new ArrayList<>();

        for (int u = 0; u < V; u++) {
            for (ArrayList<Integer> neighbor : adj.get(u)) {
                int v = neighbor.get(0);
                int wt = neighbor.get(1);
                edges.add(new int[]{wt, u, v});
            }
        }

        // Step 2: Sort edges by weight in ascending order
        edges.sort((a, b) -> a[0] - b[0]);

        // Step 3: Kruskal's Algorithm Loop using Disjoint Set
        DisjointSet ds = new DisjointSet(V);
        int mstWt = 0;

        for (int[] edge : edges) {
            int wt = edge[0];
            int u = edge[1];
            int v = edge[2];

            // If u and v do NOT share the same parent, adding this edge will NOT create a cycle
            if (ds.findUPar(u) != ds.findUPar(v)) {
                mstWt += wt;
                ds.unionBySize(u, v);
            }
        }

        return mstWt;
    }
}
