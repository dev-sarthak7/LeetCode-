class Solution {
    int[][]dp;
    int n1;
    int n2;
    char[] s1;
    char[] s2;
    int solve(int i, int j){
        if(i>=n1 || j>=n2){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }

        if(s1[i]==s2[j]){
            return dp[i][j]=1+solve(i+1,j+1);
        }
       
        return dp[i][j]=Math.max(solve(i+1,j),solve(i,j+1));
    }
    public int longestCommonSubsequence(String text1, String text2) {
        n1=text1.length();
        n2=text2.length();
        dp= new int[n1+1][n2+1];
        for(int[] ar:dp){
            Arrays.fill(ar,-1);
        }
        s1=text1.toCharArray();
        s2=text2.toCharArray();
        int result= solve(0,0);
        return result;
    }
}