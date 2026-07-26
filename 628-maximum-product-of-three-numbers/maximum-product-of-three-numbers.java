class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        if(n==3 || nums[n-1]<0){
            return nums[n-1]*nums[n-2]*nums[n-3];
        }
        int a=nums[n-1];
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n-1;j++){
                max=Math.max(max,nums[i]*nums[j]*a);
            }
        }
        return max;
    }
}