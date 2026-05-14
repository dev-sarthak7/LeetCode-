class Solution {
    public boolean isGood(int[] nums) {
        int len=nums.length;
        Arrays.sort(nums);
        int[] arr= new int[len];
        for(int i=0;i<len-1;i++){
            arr[i]=i+1;
        }
        arr[len-1]=len-1;
        for(int i=0;i<len;i++){
            if(arr[i]!=nums[i]){
                return false;
            }
        }
        return true;
        
    }
}