import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> partitions = new ArrayList<>();
        
        // Array to store the last seen index of each character ('a' through 'z')
        int[] lastIndex = new int[26];
        
        // Pass 1: Precompute the last index for every character
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }
        
        // Pass 2: Find partitions in a single greedy scan
        int startIndex = 0;
        int endIndex = 0;
        
        for (int i = 0; i < s.length(); i++) {
            // Continuously push boundary to the furthest index needed for current character
            endIndex = Math.max(endIndex, lastIndex[s.charAt(i) - 'a']);
            
            // Once i reaches the required endIndex, we found a complete partition
            if (i == endIndex) {
                partitions.add(endIndex - startIndex + 1);
                startIndex = i + 1; // Set start for next partition
            }
        }
        
        return partitions;
    }
}
