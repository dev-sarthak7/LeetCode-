class Solution {
    int[][] dp;
    int n;
    int solve(int i, int p,int[] arr){
        if(i>=n){
            return 0;
        }
        if(p!=-1 && dp[i][p]!=-1){
            return dp[i][p];
        }
        int take=0;
        if(p==-1 || arr[i]>arr[p]){
            take=1+ solve(i+1,i,arr);
        }
        int skip= solve(i+1,p,arr);
        if(p!=-1) return dp[i][p]=Math.max(take,skip);
        
        return Math.max(take,skip);
        
    }
    public int lengthOfLIS(int[] nums) {
        n= nums.length;
        dp=new int[n+1][n+1];
        for(int [] arr: dp){
            Arrays.fill(arr,-1);
        }
        return solve(0,-1,nums);

    }
}