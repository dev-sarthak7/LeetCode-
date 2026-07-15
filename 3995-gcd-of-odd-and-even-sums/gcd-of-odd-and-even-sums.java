class Solution {
    static int gcd(int a,int b){
        if(b%a==0){
            return a;
        }
        return gcd(b%a,a);
    }
    public int gcdOfOddEvenSums(int n) {
        int odd=0;
        int even=0;

        for(int i=1;i<=2*n;i++){
            if(i%2==0){
                even+=i;
            }else{
                odd+=i;
            }
        }

        


        return gcd(odd,even);
    }
}