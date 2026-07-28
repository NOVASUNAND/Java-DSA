import java.util.*;

class DisjointSet {
    private List<Integer> parent = new ArrayList<>();
    private List<Integer> size = new ArrayList<>();

    // Constructor: Initializes sets from 0 to totalNodes
    public DisjointSet(int totalNodes) {
        for (int i = 0; i <= totalNodes; i++) {
            parent.add(i); // Each node starts as its own parent
            size.add(1);   // Each set initially has a size of 1
        }
    }

    // Finds the ultimate parent (root) of a node with Path Compression
    public int findRoot(int node) {
        if (node == parent.get(node)) {
            return node; // Base case: node is its own root
        }
        
        int ultimateParent = findRoot(parent.get(node));
        parent.set(node, ultimateParent); // Path compression step
        return parent.get(node);
    }

    // Connects two nodes using Union by Size
    public void unionBySize(int u, int v) {
        int rootU = findRoot(u);
        int rootV = findRoot(v);

        // If they already have the same root, they are already connected
        if (rootU == rootV) return;

        // Attach the smaller set under the larger set
        if (size.get(rootU) < size.get(rootV)) {
            parent.set(rootU, rootV);
            size.set(rootV, size.get(rootV) + size.get(rootU));
        } else {
            parent.set(rootV, rootU);
            size.set(rootU, size.get(rootU) + size.get(rootV));
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // Create a Disjoint Set for 7 nodes (1 to 7)
        DisjointSet ds = new DisjointSet(7);

        // Build Component 1: {1, 2, 3}
        ds.unionBySize(1, 2);
        ds.unionBySize(2, 3);

        // Build Component 2: {4, 5, 6, 7}
        ds.unionBySize(4, 5);
        ds.unionBySize(6, 7);
        ds.unionBySize(5, 6);

        // Check if 3 and 7 are in the same component
        if (ds.findRoot(3) == ds.findRoot(7)) {
            System.out.println("3 and 7 are in the Same component");
        } else {
            System.out.println("3 and 7 are NOT in the Same component");
        }

        // Connect Component 1 and Component 2 by connecting 3 and 7
        ds.unionBySize(3, 7);

        // Check again after merging
        if (ds.findRoot(3) == ds.findRoot(7)) {
            System.out.println("3 and 7 are NOW in the Same component");
        } else {
            System.out.println("3 and 7 are NOT in the Same component");
        }
    }
}
