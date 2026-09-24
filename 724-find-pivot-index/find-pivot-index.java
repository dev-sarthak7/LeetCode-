class Solution {
    public int pivotIndex(int[] nums) {
        int sum=0;
        for(int x: nums){
            sum+=x;
        }
        int left=0;
        int right=sum;
        int n= nums.length;
        for(int i=0;i<n;i++){
            
            
            right-=nums[i];
            if(left==right){
                return i;
            }
            left+=nums[i];
        }
        return -1;
    }
}