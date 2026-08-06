import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Step 1: Count frequencies
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Min-Heap ordered by frequency (smallest frequency at top)
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(
            (a, b) -> countMap.get(a) - countMap.get(b)
        );

        // Step 3: Keep only top k elements in heap
        for (int num : countMap.keySet()) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll(); // Remove element with smallest frequency
            }
        }

        // Step 4: Extract k elements into result array
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = minHeap.poll();
        }

        return result;
    }
}
