class Solution {
    int[][] dp;
    int n;
    int solve(int i, int holding, int[] arr) {

        if (i == arr.length) {
            return 0;
        }

        if (dp[i][holding] != -1) {
            return dp[i][holding];
        }

        if (holding == 0) {
            // Don't have stock
            int buy = -arr[i] + solve(i + 1, 1, arr);
            int skip = solve(i + 1, 0, arr);

            return dp[i][holding] = Math.max(buy, skip);

        } else {
            // Have stock
            int sell = arr[i] + solve(i + 1, 0, arr);
            int skip = solve(i + 1, 1, arr);

            return dp[i][holding] = Math.max(sell, skip);
        }
    }

    public int maxProfit(int[] prices) {
        n= prices.length;
        dp = new int[n][2];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(0, 0, prices);
    }
}