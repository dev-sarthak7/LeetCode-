class Solution {
    int [][]dp;
    int m;
    int n;
    int solve(int i,int j,int[][]grid){
        if(i>=m || j>=n) return 0;
        if(grid[i][j]==1) return 0;
        if(i==m-1 && j==n-1){
            return 1;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        
        
        return dp[i][j]=solve(i,j+1,grid) + solve(i+1,j,grid);
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        m=obstacleGrid.length;
        n=obstacleGrid[0].length;
        dp= new int[m+1][n+1];
        for(int []arr:dp){
            Arrays.fill(arr,-1);
        }
        return solve(0,0,obstacleGrid);
    }
}