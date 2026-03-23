class Solution {
    public int maxProductPath(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        
        long[][] maxDp = new long[m][n];
        long[][] minDp = new long[m][n];
        
        maxDp[0][0] = minDp[0][0] = grid[0][0];
        
        // first column
        for(int i = 1; i < m; i++) {
            maxDp[i][0] = minDp[i][0] = maxDp[i-1][0] * grid[i][0];
        }
        
        // first row
        for(int j = 1; j < n; j++) {
            maxDp[0][j] = minDp[0][j] = maxDp[0][j-1] * grid[0][j];
        }
        
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                long val = grid[i][j];
                
                long max1 = maxDp[i-1][j] * val;
                long max2 = maxDp[i][j-1] * val;
                long min1 = minDp[i-1][j] * val;
                long min2 = minDp[i][j-1] * val;
                
                maxDp[i][j] = Math.max(Math.max(max1, max2), Math.max(min1, min2));
                minDp[i][j] = Math.min(Math.min(max1, max2), Math.min(min1, min2));
            }
        }
        
        long res = maxDp[m-1][n-1];
        int MOD = 1_000_000_007;
        
        if(res < 0) return -1;
        return (int)(res % MOD);
    }
}