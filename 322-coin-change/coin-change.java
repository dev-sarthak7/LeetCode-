class Solution {
    int n;
    int[][] dp;
    int solve(int i, int k, int[] arr){
        if(k==0){
            return 0;
        }
        if(i>=n){
            return Integer.MAX_VALUE;
        }
        if(dp[i][k]!=-1){
            return dp[i][k];
        }
        int pick=Integer.MAX_VALUE;
        if(arr[i]<=k){
            pick= solve(i,k-arr[i],arr);
        }
        if(pick!=Integer.MAX_VALUE){
            pick+=1;
        }
        int skip= solve(i+1,k,arr);
        return dp[i][k]=Math.min(skip,pick);

    }
    public int coinChange(int[] coins, int amount) {
        n=coins.length;
        dp= new int[n][amount+1];
        for(int[] ar:dp){
            Arrays.fill(ar,-1);
        }
        int a=solve(0,amount,coins);
        return a==Integer.MAX_VALUE?-1:a;
    }
}