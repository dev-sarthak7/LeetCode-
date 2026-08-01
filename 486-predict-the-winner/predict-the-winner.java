class Solution {
    int[][] dp = new int[21][21];
    int solve(int i, int j, int[] nums) {
        if (i > j) {
            return 0;
        }
        if (i == j) {
            return nums[i];
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int take_i = nums[i] + Math.min(solve(i + 2, j, nums), solve(i + 1, j - 1, nums));
        int take_j = nums[j] + Math.min(solve(i + 1, j - 1, nums), solve(i, j - 2, nums));
        return dp[i][j] = Math.max(take_i, take_j);
    }

    public boolean predictTheWinner(int[] nums) {
        
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        int sum = 0;
        for (int x : nums) {
            sum += x;
        }
        int i = 0;
        int j = nums.length - 1;
        int player1 = solve(i, j, nums);
        int player2 = sum - player1;
        return player1 >= player2;

    }
}