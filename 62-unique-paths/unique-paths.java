class Solution {
    int r;
    int c;
    int [][] dp;
    int solve(int i, int j){
        if(i==r-1 && j==c-1){
            return 1;
        }
        if(i>=r || j>=c){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(i==r-1){
            return dp[i][j]=solve(i,j+1);
        }
        if(j==c-1){
            return dp[i][j]=solve(i+1,j);
        }
        return dp[i][j]=solve(i+1,j)+ solve(i,j+1);

    }
    public int uniquePaths(int m, int n) {
        r=m;
        c=n;
        dp= new int[m][n];
        for(int [] arr:dp){
            Arrays.fill(arr,-1);
        }
        return solve(0,0);
    }
}