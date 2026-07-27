class Solution {
    public int maxProduct(int[] nums) {
        int a=nums[0];
        int b= nums[1];
        if(a>b){
            int c=a;
            a=b;
            b=c;
        }
        int n= nums.length;
        for(int i=2;i<n;i++){
            if(nums[i]>=b){
                a=b;
                b=nums[i];
            }else if(nums[i]>a){
                a=nums[i];
            }
        }
        return (a-1)*(b-1);
    }
}