class Solution {
    int[][] dp;
    int n;
    int solve(int i, int k,int[] arr){
        if(i==n ){
            return k==0?1:0;
        }
        
        if(dp[i][k]!=-1){
            return dp[i][k];
        }
        int pick= 0;
        if(arr[i]<=k){
            pick= solve(i+1,k-arr[i],arr);
        }
        int skip= solve(i+1, k ,arr);
        return dp[i][k]=pick + skip;
    }
    public int findTargetSumWays(int[] nums, int target) {
        n= nums.length;
        int sum=0;
        for(int x:nums){
            sum+=x;
        }
        if(Math.abs(target)>sum){
            return 0;
        }
        if((target+sum)%2!=0){
            return 0;
        }
        int k=( sum+ target)/2;
        dp= new int[n][k +1];
        for(int[] ar:dp){
            Arrays.fill(ar,-1);
        }
        
        return solve(0,k,nums);
    }
}