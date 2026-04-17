class Solution {
    int reverse(int n){
        int len= (int)Math.log10(n);
        int num=0;
        while(n>0){
            num+=(n%10)*(Math.pow(10,len));
            n=n/10;
            len--;

        }
        return num;
    }
    public int minMirrorPairDistance(int[] nums) {
        HashMap<Integer, List<Integer>> map= new HashMap<>();
        int min=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                List<Integer> list=map.get(nums[i]);
                if(list.size()>=2) continue;
                list.add(i);
                map.put(nums[i],list);
                continue;
            }
            List<Integer> list= new ArrayList<>();
            list.add(i);
            map.put(nums[i],list);

        }
        for(int i=0;i<nums.length;i++){
            int num= reverse(nums[i]);
            if(map.containsKey(num)){
                List<Integer>list=map.get(num);
                int a=list.get(0);
                
                int dif;
                if(a>i){
                    dif=Math.abs(i-a);
                    min=Math.min(min,dif);
                }else if(list.size()==2 && list.get(1)>i){
                    int b= list.get(1);
                    dif=Math.abs(i-b);
                    min=Math.min(min,dif);

                }
                
                
                
            }
        }
        if(min==Integer.MAX_VALUE){
            return -1;
        }else{
            return min;
        }
    }
}