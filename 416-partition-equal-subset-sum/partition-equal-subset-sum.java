class Solution {
    int n;
    int[][] dp;
    boolean solve(int i, int[] arr, int k){
        if(k==0){
            return true;
        }
        if(i>=n){
            return false;
        }
        if(dp[i][k]!=-1){
            return (dp[i][k]==1)? true:false;
        }
        boolean a=false;
        if(arr[i]<=k){
            a=solve(i+1,arr,k-arr[i]);
        }
        if(a){
            dp[i][k]=1;
            return true;
        }
        dp[i][k]=solve(i+1,arr,k)? 1:0;
        return (dp[i][k]==1)?true:false;
    }
    public boolean canPartition(int[] nums) {
        n= nums.length;
        int sum=0;
        for(int x:nums){
            sum+=x;
        }
        if(sum%2!=0){
            return false;
        }
        sum=sum/2;
        dp= new int [n+1][sum+1];
        for(int[]ar:dp){
            Arrays.fill(ar,-1);
        }
        return solve(0,nums,sum);
    }
}