class Solution {
    int m;
    int n;
    int[][] dp;
    int solve(int i, int j, int[][] arr){
        if(i==m-1 && j==n-1 && arr[m-1][n-1]!=1){
            return 1;
        }
        if(i>=m || j>=n){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(arr[i][j]==1){
            return 0;
        }
        if(i==m-1){
            return dp[i][j]=solve(i,j+1,arr);
        }
        if(j==n-1){
            return dp[i][j]=solve(i+1,j,arr);
        }
        return dp[i][j]=solve(i+1,j,arr) + solve(i,j+1,arr);
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        m= obstacleGrid.length;
        n= obstacleGrid[0].length;
        dp= new int[m][n];
        for(int[] arr:dp){
            Arrays.fill(arr,-1);
        }
        return solve(0,0,obstacleGrid);
    }
}