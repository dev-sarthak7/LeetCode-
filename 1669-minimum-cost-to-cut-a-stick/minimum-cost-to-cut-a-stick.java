class Solution {
    int[][] dp;
    int solve(int i, int j, int[] arr){
        if(i+1==j){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int min=Integer.MAX_VALUE;
        for(int k=i+1;k<j;k++){
            min=Math.min(min, arr[j]-arr[i] + solve(i,k,arr)+ solve(k,j,arr));
            
        }

        return dp[i][j]=min;
    }
    public int minCost(int n, int[] cuts) {
        int m=cuts.length+2;
        int[] arr= new int[m];
        arr[0]=0;
        arr[m-1]=n;
        for(int i=0;i<cuts.length;i++){
            arr[i+1]=cuts[i];
        }
        dp= new int[m][m];
        for(int[] ar:dp){
            Arrays.fill(ar,-1);
        }
        Arrays.sort(arr);
        return solve(0,m-1,arr);
    }
}