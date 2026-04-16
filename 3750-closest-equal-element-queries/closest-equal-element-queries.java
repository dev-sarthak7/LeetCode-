class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int len=nums.length;
        HashMap<Integer, List<Integer>>map= new HashMap<>();
        List<Integer>result=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                List<Integer>list= map.get(nums[i]);
                list.add(i);
                map.put(nums[i],list);
            }else{
                List <Integer> list= new ArrayList<>();
                list.add(i);
                map.put(nums[i],list);
            }
        }
        for(int i=0;i<queries.length;i++){

            List<Integer> list=map.get(nums[queries[i]]);
            if(list.size()==1){
                result.add(-1);
                continue;
            }
            int left=0;
            int right=list.size()-1;
            int mid=left + (right-left)/2;
            int p=mid;
            while(left<=right){
                if(list.get(mid)==queries[i]){
                    p=mid;
                    break;
                }else if(list.get(mid)<queries[i]){
                    left=mid+1;
                }else{
                    right=mid-1;
                }
                mid=left+ (right-left)/2;
            }

            int r=list.get((p+1)%list.size());
            int rd= Math.abs(r-list.get(p));
            int rcd= len-rd;
            int min= Math.min(rd,rcd);
            int l= list.get((p-1+ list.size())%list.size());
            int ld=Math.abs(l-list.get(p));
            int lcd=len-ld;
            min=Math.min(min,Math.min(ld,lcd));
            result.add(min);
           

        }
        return result;
    }
}