class Solution {
    public int nthRoot(int x, int n) {
        // Base cases: 0 and 1 don't change regardless of the root
        if (x == 0 || x == 1) return x;
        
        // Setting up our binary search boundaries
        int low = 1;
        int high = x; // High is set to x to safely cover small edge cases
        
        while (low <= high) {
            // Find the median (midpoint) of our current range
            int mid = low + (high - low) / 2;
            
            // Calculate mid^n using our custom loop function
            long guessPower = multiplyPower(mid, n, x);
            
            if (guessPower == x) {
                return mid; // Found the exact root!
            } else if (guessPower > x) {
                high = mid - 1; // Too big! Shift our search to the left side
            } else {
                low = mid + 1;  // Too small! Shift our search to the right side
            }
        }
        
        // Return -1 if no perfect integer root exists (like the square root of 5)
        return -1; 
    }
    
    // Custom loop method to calculate base^exp without using Math.pow()
    private long multiplyPower(int base, int exp, int limit) {
        long result = 1;
        
        for (int i = 0; i < exp; i++) {
            result *= base;
            
            // Safety Check: If our result passes 'x', we stop the loop early.
            // This protects us from integer overflow (numbers turning negative).
            if (result > limit) {
                return result;
            }
        }
        return result;
    }
}
