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
        int one=0;
        if(s1[i]==s2[j]){
            one=1+solve(i+1,j+1);
        }
        int two= solve(i,j+1);
        int three= solve(i+1,j);
        int four= solve(i+1,j+1);
        return dp[i][j]=Math.max(Math.max(one,two),Math.max(three,four));
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