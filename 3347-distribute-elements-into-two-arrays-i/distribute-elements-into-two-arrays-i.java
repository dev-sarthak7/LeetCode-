class Solution {
    public int[] resultArray(int[] nums) {
        int n= nums.length;
        int[] result= new int[n];
        result[0]=nums[0];
        ArrayList<Integer> list= new ArrayList<>();
        int ind=1;
        list.add(nums[1]);
        for(int i=2;i<n;i++){
            int a= result[ind-1];
            int b= list.get(list.size()-1);
            if(a>b){
                
                result[ind]=nums[i];
                ind++;
                
            }else{
                list.add(nums[i]);
            }
        }
        for(int x:list){

            result[ind]=x;
            ind++;
            
        }
        return result;

    }
}