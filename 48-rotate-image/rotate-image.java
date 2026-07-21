class Solution {
    public void rotate(int[][] matrix) {
        int n= matrix.length;
        int[][]visited= new int[n][n];
        for(int []arr:visited){
            Arrays.fill(arr,0);
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(visited[i][j]==0){
                    int a=matrix[i][j];
                    matrix[i][j]=matrix[j][i];
                    matrix[j][i]=a;
                    visited[j][i]=1;
                }
                
            }
        }
        for(int i=0;i<n;i++){
            int a=0;
            int b=n-1;
            while(a<b){
                int x=matrix[i][a];
                matrix[i][a]=matrix[i][b];
                matrix[i][b]=x;
                a++;
                b--;
            }
            
        }
    }
}