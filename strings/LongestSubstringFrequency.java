import java.util.HashMap;

public class LongestSubstringFrequency {
    public static void main(String[] args) {
        String input1 = "abbac";
        String input2 = "abcabcbb";

        System.out.println("Input: " + input1 + " -> Length is " + lengthOfLongestSubstring(input1)); 
        System.out.println("Input: " + input2 + " -> Length is " + lengthOfLongestSubstring(input2)); 
    }

    public static int lengthOfLongestSubstring(String s) {
        // This map tracks the frequency of each character inside our current window
        HashMap<Character, Integer> frequencyMap = new HashMap<>();
        
        int maxLength = 0;
        int left = 0; // Left boundary of our sliding window

        // 'right' expands the window character by character
        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);

            // Step 1: Add the current character to our frequency map
            frequencyMap.put(rightChar, frequencyMap.getOrDefault(rightChar, 0) + 1);

            // Step 2: If the frequency of rightChar is > 1, we have a duplicate!
            // This loop shrinks the window from the left and cleans the map until frequency drops back to 1.
            while (frequencyMap.get(rightChar) > 1) {
                char leftChar = s.charAt(left);
                
                // Decrement the count of the character 'left' is pointing to
                frequencyMap.put(leftChar, frequencyMap.get(leftChar) - 1);
                
                // Shrink the window by moving left forward
                left++;
            }

            // Step 3: At this point, the window from 'left' to 'right' is guaranteed 
            // to have zero duplicates. Calculate its size and update our maximum.
            int currentWindowLength = right - left + 1;
            maxLength = Math.max(maxLength, currentWindowLength);
        }

        return maxLength;
    }
}