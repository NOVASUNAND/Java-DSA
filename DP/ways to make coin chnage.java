class Solution {
    public int change(int amount, int[] coins) {
        // dp[x] stores the number of combinations to make amount x
        int[] dp = new int[amount + 1];
        
        // Base case: 1 way to make amount 0 (using no coins)
        dp[0] = 1;

        // Outer loop over coins ensures combinations, not permutations
        for (int coin : coins) {
            for (int x = coin; x <= amount; x++) {
                dp[x] += dp[x - coin];
            }
        }

        return dp[amount];
    }
}
