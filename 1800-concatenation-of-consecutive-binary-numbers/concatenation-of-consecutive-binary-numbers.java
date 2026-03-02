class Solution {
    public int concatenatedBinary(int n) {
        long result=0;
        int mod=1000000007;
        for(int i=1;i<=n;i++){
            int shift= (int)(Math.log(i)/ Math.log(2))+1;
            result=((result<<shift)+i)%mod;

            
        }
        return (int)result;
    }
}