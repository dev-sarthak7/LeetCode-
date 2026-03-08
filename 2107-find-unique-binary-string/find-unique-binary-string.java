class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int n= nums.length;
        int len= 1<<n;

        for(int i=0;i<len;i++){
            String str= Integer.toBinaryString(i);
            int strlen=str.length();
            for(int k=0;k<n-strlen;k++){
                str="0"+str;
            }
            boolean c=false;
            for(int j=0;j<nums.length;j++){
                if(nums[j].equals(str)){
                    c=true;
                    break;
                }
            }
            if(!c){
                return str;
            }
        }
        return "0";
    }
}