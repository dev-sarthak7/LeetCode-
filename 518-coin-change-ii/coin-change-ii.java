class Solution {
    int n;
    int[][] dp;
    int solve(int i, int k, int[] arr){
        if(k==0){
            return 1;
        }
        if(i>=n){
            return 0;
        }
        if(dp[i][k]!=-1){
            return dp[i][k];
        }
        int pick=0;
        if(arr[i]<=k){
            pick= solve(i,k-arr[i],arr);
        }
        int take= solve(i+1,k,arr);

        return dp[i][k]= pick+take;
    }
    public int change(int amount, int[] coins) {
        n=coins.length;
        dp= new int[n][amount+1];
        for(int[] ar: dp){
            Arrays.fill(ar,-1);
        }
        return solve(0,amount,coins);
    }
}