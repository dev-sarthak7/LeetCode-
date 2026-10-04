class Solution {
    int[][] dp;
    int n;
    int m;
    int solve(int i, int j, int[][] arr){
        if(i>=m || j>=n){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(arr[i][j]==0){
            return dp[i][j]=0;
        }
        int right= solve(i,j+1,arr);
        int down= solve(i+1,j,arr);
        int diagonal= solve(i+1,j+1,arr);
        return dp[i][j]= 1+ Math.min(right,Math.min(down,diagonal));
    }
    public int countSquares(int[][] matrix) {
        m=matrix.length;
        n=matrix[0].length;
        dp= new int[m][n];
        for(int[] ar:dp){
            Arrays.fill(ar,-1);
        }
        int ans=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                ans+= solve(i,j,matrix);
            }
        }
        return ans;

    }
}