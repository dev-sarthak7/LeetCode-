class Solution {
    int n;
    boolean[][] dp;
    boolean[][] visited;
    char[] arr;
    boolean solve(int i,int j){
        if(i>=j) return true;
        if(visited[i][j]){
            return dp[i][j];
        }
        visited[i][j]=true;
        if(arr[i]!=arr[j]){
            return dp[i][j]=false;
        }else{
            return dp[i][j]=solve(i+1,j-1);
        }
    }
    public String longestPalindrome(String s) {
        n=s.length();
        arr=s.toCharArray();
        dp= new boolean[n+1][n+1];
        visited= new boolean[n+1][n+1];
        int maxlen= 1;
        int ind=0;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(j-i+1<maxlen){
                    continue;
                }else if(solve(i,j)){
                    maxlen= j-i+1;
                    ind=i;
                }
            }
        }
        return s.substring(ind,ind+maxlen);

    }
}