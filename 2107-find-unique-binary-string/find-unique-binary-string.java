class Solution {
    public String findDifferentBinaryString(String[] nums) {
        HashSet<String> set= new HashSet<>();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        int n=1<<nums.length;
        for(int i=0;i<n;i++){
            String str= Integer.toBinaryString(i);
            int len= str.length();
            for(int j=0;j<(nums.length)-len;j++){
                str="0"+str;
            }
            if(!set.contains(str)){
                return str;
            }
        }
        return nums[0];
    }
}