import java.util.*;

class Pair {
    int weight;
    int node;

    public Pair(int weight, int node) {
        this.weight = weight;
        this.node = node;
    }
}

class Solution {
    static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.weight - y.weight);

        boolean[] visited = new boolean[V];

        pq.add(new Pair(0, 0));
        int sum = 0;

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int weight = curr.weight;
            int node = curr.node;

            if (visited[node]) {
                continue;
            }

            visited[node] = true;
            sum += weight;

            for (int i = 0; i < adj.get(node).size(); i++) {
                int adjNode = adj.get(node).get(i).get(0);
                int edW = adj.get(node).get(i).get(1);

                if (!visited[adjNode]) {
                    pq.add(new Pair(edW, adjNode));
                }
            }
        }

        return sum;
    }
}
