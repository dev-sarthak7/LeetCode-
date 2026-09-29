class Solution {
    int n;
    int[][] dp;
    int[][] pal;
    boolean isPalindrome(int i, int j, char[] c){
        if(dp[i][j]!=-1){
            return dp[i][j]==1?true:false;
        }
        while(i<j){
            if(c[i]!=c[j]){
                dp[i][j]=0;
                return false;
            }
            i++;
            j--;
        }
        dp[i][j]=1;
        return true;
    }
    int solve(int i, int j, char[] c){
        if(i==j){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(isPalindrome(i,j,c)){

            return dp[i][j]=0;
        }
        int min=Integer.MAX_VALUE;
        for(int k=i;k<j;k++){
            if(isPalindrome(i,k,c)){
            min= Math.min(min, 1 + solve(k+1,j,c));
            }
        }
        return dp[i][j]= min;
    }
    int minCut(String s) {
        //your code goes here
        char[] c = s.toCharArray();
        n= c.length;
        dp= new int[n][n];
        pal= new int[n][n];
        for(int[] ar:pal){
            Arrays.fill(ar,-1);
        }
        for(int[] ar:dp){
            Arrays.fill(ar,-1);
        }
        return solve(0,n-1,c);

    }
}