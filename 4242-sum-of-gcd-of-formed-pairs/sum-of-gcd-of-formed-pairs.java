class Solution {
    static int gcd(int a , int b){
        if(b%a==0){
            return a;
        }
        return gcd(b%a,a);
    }
    public long gcdSum(int[] nums) {
        int n= nums.length;
        int [] prefixGCD= new int [n];
        int max=nums[0];
        prefixGCD[0]=nums[0];
        for(int i=1;i<n;i++){
            max=Math.max(max,nums[i]);
            prefixGCD[i]=gcd(max,nums[i]);
        }
        Arrays.sort(prefixGCD);
        int i=0;
        int j=n-1;
        HashSet<Integer> set= new HashSet<>();
        long sum=0;
        while(i<j){
            sum+=gcd(prefixGCD[i],prefixGCD[j]);
            i++;
            j--;
        }
        return sum;
    }
}