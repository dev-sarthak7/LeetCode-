class Solution {
    public int largestInteger(int[] nums, int k) {
        HashMap<Integer,Integer>map= new HashMap<>();
        int n= nums.length;
        for(int i=0;i<n;i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }else{
                map.put(nums[i],1);
            }
        }
        int[] arr= new int[n];
        for(int i=0;i<n;i++){
            arr[i]=nums[i];
        }
        Arrays.sort(arr);
        if(k==1 && n!=1){
            for(int i=n-1;i>=0;i--){
                if(map.get(arr[i])==1){
                    return arr[i];
                }
            }
        }
        if(k==n){
            
            return arr[n-1];
        }

        if(map.get(nums[n-1])==1 && map.get(nums[0])==1){
            return (nums[n-1]>nums[0])?nums[n-1]:nums[0];
        }else if(map.get(nums[0])==1){
            return nums[0];
        }else if(map.get(nums[n-1])==1){
            return nums[n-1];
        }
        else{
            return -1;
        }
    }
}