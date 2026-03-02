class Solution {
    public int minSwaps(int[][] grid) {
        int [] zeroes=new int[grid.length];
        int n= grid.length;
        for(int i=0;i<n;i++){
            int count=0;
            int j=n-1;
            while(j>=0 && grid[i][j]==0){
                count++;
                j--;
            }
            zeroes[i]=count;
        }
        int swaps=0;
        for(int i=0;i<n;i++){
            int need= n-i-1;
            int j=i;
            while(j<n && zeroes[j]<need){
                j++;
            }
            swaps+=j-i;
            if(j==n){
                return -1;
            }
            while(j>i){
                int temp= zeroes[j];
                zeroes[j]=zeroes[j-1];
                zeroes[j-1]=temp;
                j--;
            }
        }
        return swaps;
    }
}