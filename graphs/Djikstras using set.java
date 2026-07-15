import java.util.*;

class Pair {
    int distance;
    int node;

    public Pair(int distance, int node) {
        this.distance = distance;
        this.node = node;
    }
}

class Solution {
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
        HashSet<Pair> set = new HashSet<>();

        int[] dist = new int[V];
        for (int i = 0; i < V; i++) {
            dist[i] = (int)(1e9);
        }

        dist[S] = 0;
        set.add(new Pair(0, S));

        while (!set.isEmpty()) {
            Pair curr = null;
            for (Pair p : set) {
                if (curr == null || p.distance < curr.distance) {
                    curr = p;
                }
            }

            int dis = curr.distance;
            int node = curr.node;
            set.remove(curr);

            for (int i = 0; i < adj.get(node).size(); i++) {
                int edgeWeight = adj.get(node).get(i).get(1);
                int adjNode = adj.get(node).get(i).get(0);

                if (dis + edgeWeight < dist[adjNode]) {
                    
                    for (Pair p : set) {
                        if (p.node == adjNode) {
                            set.remove(p);
                            break;
                        }
                    }

                    dist[adjNode] = dis + edgeWeight;
                    set.add(new Pair(dist[adjNode], adjNode));
                }
            }
        }

        return dist;
    }
}
