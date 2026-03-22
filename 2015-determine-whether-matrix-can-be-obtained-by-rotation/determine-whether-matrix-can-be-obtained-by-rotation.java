class Solution {
    void rotate(int[][]mat){
        int n=mat.length;
        int [][]copy=new int[n][n];
        for(int i=0;i<n;i++){
            copy[i]=mat[i].clone();
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                mat[i][j]=copy[j][i];
            }
        }
        for(int j=0;j<n;j++){
            int a=0;
            int b=n-1;
            while(a<b){
                int c=mat[a][j];
                mat[a][j]=mat[b][j];
                mat[b][j]=c;
                a++;
                b--;
            }
        }
        
    }
    public boolean findRotation(int[][] mat, int[][] target) {
        for(int i=0;i<4;i++){
            rotate(mat);
            if(Arrays.deepEquals(mat,target)){
                return true;
            }
        }
        return false;
    }
}