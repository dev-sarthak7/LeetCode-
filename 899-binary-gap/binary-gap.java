class Solution {
    public int binaryGap(int n) {

        //sarthak
        String s= Integer.toBinaryString(n);

        int max=0;
        int x=s.length()-1;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)=='1'){
                int diff=x-(s.length()-i-1);
                max=Math.max(max,diff);
                x=s.length()-i-1;
            }
        }
        return max;
    }
}