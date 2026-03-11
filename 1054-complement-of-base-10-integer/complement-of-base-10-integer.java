class Solution {
    public int bitwiseComplement(int n) {
        StringBuilder sb= new StringBuilder();
        if(n==0) return 1;
        while(n>0){
            char ch=((n&1)==1)?'0':'1';
            sb.append(ch);
            n=n>>1;
        }
        sb.reverse();
        String str=sb.toString();
        return Integer.parseInt(str,2);
    }
}