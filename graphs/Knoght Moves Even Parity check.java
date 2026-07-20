import java.util.*;

class Solution {
    public boolean canReach(int[] start, int[] target) {
        if (start[0] == target[0] && start[1] == target[1]) return true;

        int[] rowOffsets = {-2, -2, -1, -1, 1, 1, 2, 2};
        int[] colOffsets = {-1, 1, -2, 2, -2, 2, -1, 1};

        boolean[][][] visited = new boolean[8][8][2]; 
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start[0], start[1], 0});
        visited[start[0]][start[1]][0] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];
            int moves = curr[2];

            for (int i = 0; i < 8; i++) {
                int nextR = r + rowOffsets[i];
                int nextC = c + colOffsets[i];
                int nextMoves = moves + 1;
                int nextParity = nextMoves % 2;

                if (nextR >= 0 && nextR < 8 && nextC >= 0 && nextC < 8) {
                    if (nextR == target[0] && nextC == target[1] && nextParity == 0) {
                        return true;
                    }

                    if (!visited[nextR][nextC][nextParity]) {
                        visited[nextR][nextC][nextParity] = true;
                        queue.offer(new int[]{nextR, nextC, nextMoves});
                    }
                }
            }
        }
        return false;
    }
}
