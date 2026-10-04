class Solution {
    int t;
    int[][][] dp;
    int solve(int i, int j, int[] arr, int k){
        if(i==arr.length || k==t){
            return 0;
        }
        if(dp[i][j][k]!=-1){
            return dp[i][j][k];
        }

        if(j==0){
            int buy= -arr[i] + solve(i+1,1,arr,k);
            int skip= solve(i+1,0,arr,k);
            return dp[i][j][k]= Math.max(buy,skip);
        }else{
            int sell= arr[i] + solve(i+1,0,arr,k+1);
            int skip= solve(i+1,1,arr,k);
            return dp[i][j][k]= Math.max(sell,skip);
        }
    }
    public int maxProfit(int k, int[] prices) {
        t=k;
        dp= new int[prices.length][2][k+1];
        for(int[][] x:dp){
            for(int[]y:x){
                Arrays.fill(y,-1);
            }
        }
       return solve(0,0,prices,0);
    }
}