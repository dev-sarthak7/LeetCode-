class Solution {
    int m;
    int n;
    int[][] dp;
    int solve(int i, int j, int[][] arr){
        if(i==m-1 && j==n-1){
            return arr[i][j];
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(i==m-1){
            return dp[i][j]=arr[i][j]+ solve(i,j+1,arr);
        }
        if(j==n-1){
            return dp[i][j]=arr[i][j] + solve(i+1,j,arr);
        }
        return dp[i][j]= Math.min(solve(i,j+1,arr), solve(i+1,j,arr))+ arr[i][j];
    }
    public int minPathSum(int[][] grid) {
        m= grid.length;
        n= grid[0].length;
        dp= new int[m][n];
        for(int[] arr:dp){
            Arrays.fill(arr,-1);
        }
        return solve(0,0,grid);
    }
}