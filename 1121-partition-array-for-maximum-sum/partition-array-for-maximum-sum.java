class Solution {
    int[] dp;
    int n;
    int solve(int i,int j, int[] arr, int k){
        if(i==j){
            return arr[i];
        }
        if(i>j){
            return 0;
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        int max=0;
        int cur=0;
        for(int a=i;a<=Math.min(j,i+k-1);a++){
            cur= Math.max(cur,arr[a]);
            max= Math.max(max, cur * (a-i+1) + solve(a+1,j,arr,k));
        }
        return dp[i]= max;
    }
    public int maxSumAfterPartitioning(int[] arr, int k) {
        // Your code goes here
        n= arr.length;
        dp= new int[n];
        Arrays.fill(dp,-1);
        return solve(0,n-1,arr,k);
    }
}