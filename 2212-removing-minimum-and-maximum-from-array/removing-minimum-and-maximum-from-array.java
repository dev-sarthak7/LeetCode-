class Solution {
    public int minimumDeletions(int[] nums) {
        int min=0;
        int max=0;
        int n= nums.length;
        if(n==1) return 1;
        for(int i=1;i<n;i++){
            if(nums[i]>nums[max]){
                max=i;
            }
            if(nums[i]<nums[min]){
                min=i;
            }
        }
        int a= Math.min(max,min);
        int b= Math.max(max,min);

        return Math.min(b+1,Math.min(n-a, n-b+a+1));
    }
}