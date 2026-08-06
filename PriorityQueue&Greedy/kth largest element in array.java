import java.util.PriorityQueue;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        // Min-Heap stores the top k largest elements
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        for (int num : nums) {
            minHeap.offer(num);
            
            // Keep heap size bounded to k
            if (minHeap.size() > k) {
                minHeap.poll(); // Evicts the smallest in the top (k+1)
            }
        }
        
        // Root is the kth largest element
        return minHeap.peek();
    }
}
