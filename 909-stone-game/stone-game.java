class Solution {
    int solve(int i, int j,int[] piles, int[][] dp){
        if(i>j){
            return 0;
        }
        if(i==j){
            return piles[i];
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int take_i= piles[i] + Math.min(solve(i+1,j-1,piles,dp),solve(i+2,j,piles,dp));
        int take_j= piles[j]+ Math.min(solve(i,j-1,piles,dp),solve(i+1,j-1,piles,dp));

        return dp[i][j]=Math.max(take_i,take_j);
    }
    public boolean stoneGame(int[] piles) {
        int sum=0;
        for(int x: piles){
            sum+=x;
        }
        int n= piles.length;
        int i=0;
        int j= n-1;
        int[][] dp= new int[n][n];
        for(int [] arr: dp){
            Arrays.fill(arr,-1);
        }
        int alice= solve(i,j,piles,dp);
        int bob= sum-alice;
        return alice>=bob;
    }
}