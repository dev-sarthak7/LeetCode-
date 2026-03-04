class Solution {
    public int numSpecial(int[][] mat) {
        int count=0;
        int m= mat.length;
        int n= mat[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==1){
                    boolean hasZero=true;
                    for(int k=i-1;k>=0;k--){
                        if(mat[k][j]==1){
                            hasZero=false;
                            break;
                        }
                    }
                    for(int k=i+1;k<m;k++){
                        if(mat[k][j]==1){
                            hasZero=false;
                            break;
                        }
                    }
                    for(int k=j-1;k>=0;k--){
                        if(mat[i][k]==1){
                            hasZero=false;
                            break;
                        }
                    }
                    for(int k=j+1;k<n;k++){
                        if(mat[i][k]==1){
                            hasZero=false;
                            break;
                        }
                    }
                    if(hasZero){
                        count++;
                    }
                }   
            }
        }
        return count;
    }
}