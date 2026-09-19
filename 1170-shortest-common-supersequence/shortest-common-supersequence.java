class Solution {
    int n1;
    int n2;
    int[][] dp;
    int solve(int i, int j,char[] s1, char[] s2){
        if(i==n1){
            return n2-j;
        }
        if(j==n2){
            return n1-i;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(s1[i]==s2[j]){
            return dp[i][j]= 1+ solve(i+1,j+1,s1,s2);
        }
        return dp[i][j]= Math.min(solve(i+1,j,s1,s2),solve(i,j+1,s1,s2))+ 1;
    }
    public String shortestCommonSupersequence(String str1, String str2) {
        char[] s1=str1.toCharArray();
        char[] s2=str2.toCharArray();
        n1=s1.length;
        n2=s2.length;
        dp= new int[n1][n2];
        for(int[] ar:dp){
            Arrays.fill(ar,-1);
        }
        int i=0;
        int j=0;
        StringBuilder sb= new StringBuilder();
        while(i<n1 && j<n2){
            if(s1[i]==s2[j]){
                sb.append(s1[i]);
                i++;
                j++;
            }else{
                if(solve(i+1,j,s1,s2)<=solve(i,j+1,s1,s2)){
                    sb.append(s1[i]);
                    i++;
                }else{
                    sb.append(s2[j]);
                    j++;
                }
            }
        }
        while(i<n1){
            sb.append(s1[i]);
            i++;
        }
        while(j<n2){
            sb.append(s2[j]);
            j++;
        }
        return sb.toString();
    }
}