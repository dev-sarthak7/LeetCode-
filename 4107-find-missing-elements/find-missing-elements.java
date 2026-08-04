class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int max=nums[0];
        int min= nums[1];
        if(min>max){
            int c= max;
            max=min;
            min=c;
        }
        int n= nums.length;
        for(int i=0;i<n;i++){
            max=Math.max(max,nums[i]);
            min= Math.min(min,nums[i]);
        }
        HashSet<Integer>set=new HashSet<>();
        for(int i:nums){
            set.add(i);
        }
        List<Integer>list= new ArrayList<>();
        for(int i=min;i<=max;i++){
            if(!set.contains(i)){
                list.add(i);
            }
        }
        return list;
    }
}