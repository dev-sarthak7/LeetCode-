class Solution {
    int[][][] dp;

    int solve(int i, int h, int t, int[] arr) {

        // t = number of completed transactions
        if (i == arr.length || t == 2) {
            return 0;
        }

        if (dp[i][h][t] != -1) {
            return dp[i][h][t];
        }

        if (h == 0) {

            // Buy
            int buy = -arr[i] + solve(i + 1, 1, t, arr);

            // Skip
            int skip = solve(i + 1, 0, t, arr);

            return dp[i][h][t] = Math.max(buy, skip);

        } else {

            // Sell -> one transaction completed
            int sell = arr[i] + solve(i + 1, 0, t + 1, arr);

            // Don't sell
            int skip = solve(i + 1, 1, t, arr);

            return dp[i][h][t] = Math.max(sell, skip);
        }
    }

    public int maxProfit(int[] arr) {
        int n= arr.length;
        dp = new int[n][2][3];

        for (int[][] x : dp) {
            for (int[] y : x) {
                Arrays.fill(y, -1);
            }
        }

        return solve(0, 0, 0, arr);
    }
}