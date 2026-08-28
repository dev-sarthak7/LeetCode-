class Solution {
    int [][] dp;
    int n;
    boolean [][] visited;
    int solve(int i, int j,List<List<Integer>> list){
        if(i>=n){
            return 0;
        }
        
        if(visited[i][j]){
            return dp[i][j];
        }
        visited[i][j]=true;
        int a= solve(i+1,j,list);
        int b= solve(i+1,j+1,list);
        return dp[i][j]=Math.min(a,b) + list.get(i).get(j);
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        n=triangle.size();
        dp= new int[n+1][n+1];
        visited= new boolean[n+1][n+1];
        for(boolean[] arr:visited){
            Arrays.fill(arr,false);
        }
        for(int [] arr: dp){
            Arrays.fill(arr,-1);
        }
        return solve(0,0,triangle);
    }
}