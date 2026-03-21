class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        for(int i=y;i<y+k;i++){
            int a=x;
            int b= x+k-1;
            while(a<b){
                int c=grid[a][i];
                grid[a][i]=grid[b][i];
                grid[b][i]=c;
                a++;
                b--;
            }
        }
        return grid;
    }
}