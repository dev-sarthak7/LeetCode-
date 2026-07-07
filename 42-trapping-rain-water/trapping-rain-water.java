class Solution {
    static int[] leftMax(int[] arr,int n){
        int[] left= new int[n];
        left[0]= arr[0];
        int max=arr[0];
        for(int i=1;i<n;i++){
            max=Math.max(max,arr[i]);
            left[i]=max;
        }
        return left;

    }
    static int[] rightMax(int[] arr,int n){
        int[] right= new int[n];
        right[n-1]= arr[n-1];
        int max=arr[n-1];
        for(int i=n-2;i>=0;i--){
            max=Math.max(max,arr[i]);
            right[i]=max;
        }
        return right;

    }
    public int trap(int[] height) {
        int n= height.length;
        int[] leftMax= leftMax(height,n);
        int[] rightMax= rightMax(height,n);
        int water=0;
        for(int i=0;i<n;i++){
            int h= Math.min(leftMax[i],rightMax[i]);
            water+= h-height[i] ;
        }
        return water;
        
    }
}