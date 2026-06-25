class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int count=0;
        int n= nums.length;
        for(int i=0;i<n;i++){
            int c=0;
            int len=0;
            for(int j=i;j<n;j++){
                if(nums[j]==target){
                    c++;
                }
                len=j-i+1;
                if(c>len/2){
                count++;
            }

            }
            
        }
        return count;
    }
}