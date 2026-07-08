class Solution {
    static int dfs(int[][] dp, int r,int c, int m,int n){
        if(r<0 || r>=m || c<0 || c>=n){
            return 0;
        }
        if(r==m-1 && c==n-1){
            return 1;
        }
        if(dp[r][c]!=-1){
            return dp[r][c];
        }
        dp[r][c]=dfs(dp,r+1,c,m,n)+ dfs(dp,r,c+1,m,n);

        return dp[r][c];
    }
    public int uniquePaths(int m, int n) {
        int [][] dp= new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i],-1);
        }
        return dfs(dp,0,0,m,n);
    }
}