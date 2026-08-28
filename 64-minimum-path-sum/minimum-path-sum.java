class Solution {
    int[][]dp;
    int n;
    int m;
    int solve(int i,int j, int[][] grid){
        if(i==m-1 && j==n-1){
            return grid[i][j];
        }
        if(i==m-1){
            return dp[i][j]= grid[i][j] + solve(i,j+1,grid);
        }
        if(j==n-1){
            return dp[i][j]=grid[i][j]+ solve(i+1,j,grid);
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int right= solve(i,j+1,grid);
        int down = solve(i+1, j,grid);
        int minPath= Math.min(right,down);
        
        return dp[i][j]=grid[i][j]+ minPath;
    }
    public int minPathSum(int[][] grid) {
        m= grid.length;
        n= grid[0].length;
        dp= new int[m+1][n+1];
        for(int [] arr:dp){
            Arrays.fill(arr,-1);
        }
        return solve(0,0,grid);
    }
}