import java.util.*;

public class TopologicalSort {
    public static List<Integer> topologicalSort(int[][] edges) {
        // Determine all nodes
        Set<Integer> nodesSet = new HashSet<>();
        for (int[] edge : edges) {
            nodesSet.add(edge[0]);
            nodesSet.add(edge[1]);
        }
        int n = Collections.max(nodesSet) + 1;
        
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        int[] indegree = new int[n];
        
        // Build graph: edge [a, b] means a depends on b so b -> a
        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            graph.get(b).add(a);
            indegree[a]++;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        
        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            int node = queue.poll();
            result.add(node);
            for (int neighbor : graph.get(node)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        
        if(result.size() != n) {
            return new ArrayList<>(); // cycle present
        }
        return result;
    }
    
    public static void main(String[] args) {
        int[][][] testCases = {
            { {1,0}, {2,0}, {3,1}, {3,2} },
            { {1,0} },
            { {0,1}, {0,2}, {1,3}, {2,3} }
        };
        
        for (int[][] edges : testCases) {
            List<Integer> order = topologicalSort(edges);
            System.out.println(order);
        }
    }
}
