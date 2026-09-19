class Solution {
    int n1;
    int n2;
    int[][] dp;
    int solve(int i,int j, char[] s1,char[] s2){
        if(i>=n1 || j>=n2){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(s1[i]==s2[j]){
            return dp[i][j]=1+ solve(i+1,j+1,s1,s2);
        }
        return dp[i][j]= Math.max(solve(i+1,j, s1,s2),solve(i,j+1,s1,s2));
    }
    public int minDistance(String word1, String word2) {
        n1=word1.length();
        n2= word2.length();
        char[] s1= word1.toCharArray();
        char[] s2= word2.toCharArray();
        dp= new int[n1][n2];
        for(int[] ar:dp){
            Arrays.fill(ar,-1);
        }
        int x= solve(0,0,s1,s2);
        return (n1+n2) - 2*x;
    }
}