import java.util.Arrays;

class Solution {
    int[][] dp;
    int n;
    
    int solve(int i, int amount, int[] coins) {
        // Base cases
        if (amount < 0 || i >= n) {
            return Integer.MAX_VALUE;
        }
        if (amount == 0) {
            return 0;
        }
        
        // Fix 1: Check against the initialization value (-1)
        if (dp[i][amount] != -1) {
            return dp[i][amount];
        }
        
        // Fix 2: Prevent Integer Overflow by checking the result before adding 1
        int pickRes = solve(i, amount - coins[i], coins);
        int pick = (pickRes == Integer.MAX_VALUE) ? Integer.MAX_VALUE : 1 + pickRes;
        
        int skip = solve(i + 1, amount, coins);
        
        return dp[i][amount] = Math.min(pick, skip);
    }
    
    public int coinChange(int[] coins, int amount) {
        n = coins.length;
        dp = new int[n + 1][amount + 1];
        
        // Standard initialization for unvisited DP states
        for (int[] ar : dp) {
            Arrays.fill(ar, -1); 
        }
        
        int result = solve(0, amount, coins);
        
        // Fix 3: Return -1 if the amount cannot be made up
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}