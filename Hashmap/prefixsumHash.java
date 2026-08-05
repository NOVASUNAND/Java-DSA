import java.util.HashMap;
import java.util.Map;

class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int currentSum = 0;
        
        // Key: prefixSum, Value: frequency of that prefixSum
        Map<Integer, Integer> map = new HashMap<>();
        
        // Base case: a prefix sum of 0 has occurred once (before index 0)
        map.put(0, 1);
        
        for (int num : nums) {
            currentSum += num;
            
            // Check if there is a prefix sum that we can subtract to get k
            if (map.containsKey(currentSum - k)) {
                count += map.get(currentSum - k);
            }
            
            // Store / update the frequency of the current prefix sum
            map.put(currentSum, map.getOrDefault(currentSum, 0) + 1);
        }
        
        return count;
    }
}
