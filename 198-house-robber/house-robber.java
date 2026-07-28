class Solution {
    int[] dp;
    int solve(int n,int[] nums){
        if (n < 0) return 0;
        if (n == 0) return nums[0];
        if(dp[n]!=-1){
            return dp[n];
        }
        dp[n]=Math.max(nums[n]+solve(n-2,nums),solve(n-1,nums));
        return dp[n];
        
    }
    public int rob(int[] nums) {
        int n= nums.length;
        if(n==1) return nums[0];
        if(n==2) return Math.max(nums[0],nums[1]);
        dp= new int[nums.length+1];
        Arrays.fill(dp,-1);

        dp[0]=nums[0];
      
        return solve(n-1,nums);
    }
}