class Solution {
    public int bitwiseComplement(int n) {
        if(n==0) return 1;
        int num=0;
        int temp= n;
        while(n>0){
            num=(num<<1)|1;

            n=n>>1;
        }
        return num^temp;
    }
}