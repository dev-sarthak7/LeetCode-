class Solution {
    String invert(String s){
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1'){
                sb.append(0);
            }else{
                sb.append(1);
            }
        }
        return sb.reverse().toString();
        
    }
    public char findKthBit(int n, int k) {
        String[] bn= new String[n+1];
        bn[0]="0";
        for(int i=1;i<=n;i++){
            StringBuilder sb= new StringBuilder();
            sb.append(bn[i-1]);
            sb.append(1);
            sb.append(invert(bn[i-1]));
            bn[i]=sb.toString();


        }
        String sn=bn[n];

        return sn.charAt(k-1);
    }
}