class Solution {
    int n;
    int[][] dp;
    int solve(int i, int j, char[] str){
        if(i>=n || j<0){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(str[i]==str[j]){
            return dp[i][j]=1+ solve(i+1, j-1, str);
        }
        return dp[i][j]= Math.max(solve(i+1,j,str),solve(i,j-1,str));

    }
    public int minInsertions(String s) {
        n= s.length();
        dp= new int[n][n];
        for(int[] ar:dp){
            Arrays.fill(ar,-1);
        }
        char[] str= s.toCharArray();
        int x= solve(0,n-1,str);
        return n-x;
    }
}