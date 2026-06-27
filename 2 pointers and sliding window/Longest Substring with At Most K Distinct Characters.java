/// Java implementation
public class Solution {
    public static int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (k == 0)
            return 0;
        int left = 0, maxLen = 0;
        java.util.HashMap<Character, Integer> freq = new java.util.HashMap<>();
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            freq.put(c, freq.getOrDefault(c, 0) + 1);
            while (freq.size() > k) {
                char leftChar = s.charAt(left);
                freq.put(leftChar, freq.get(leftChar) - 1);
                if (freq.get(leftChar) == 0) {
                    freq.remove(leftChar);
                }
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        // Example 1
        String s1 = "eceba";
        int k1 = 2;
        System.out.println(lengthOfLongestSubstringKDistinct(s1, k1)); // Expected output: 3

        // Example 2
        String s2 = "aa";
        int k2 = 1;
        System.out.println(lengthOfLongestSubstringKDistinct(s2, k2)); // Expected output: 2

        // Example 3
        String s3 = "a";
        int k3 = 1;
        System.out.println(lengthOfLongestSubstringKDistinct(s3, k3)); // Expected output: 1
    }
}
