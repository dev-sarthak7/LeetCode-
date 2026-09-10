class Solution {
    int n;
    int[][] dp;
    int solve(int i, int j, List<List<Integer>> list){
        if(i==n-1){
            return list.get(i).get(j);
        }
        if(i>=n){
            return 0;
        }
       
        if(dp[i][j]!=Integer.MAX_VALUE){
            return dp[i][j];
        }
        return dp[i][j]=Math.min(solve(i+1,j,list),solve(i+1,j+1,list))+ list.get(i).get(j);
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        n= triangle.size();
        dp=new int[n][n];
        for(int [] arr:dp){
            Arrays.fill(arr,Integer.MAX_VALUE);
        }
        return solve(0,0,triangle);
    }
}