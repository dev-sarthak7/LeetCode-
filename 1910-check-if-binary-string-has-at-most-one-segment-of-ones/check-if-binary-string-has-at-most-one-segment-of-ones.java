class Solution {
    public boolean checkOnesSegment(String s) {
        
        int n= s.length();

        boolean ones=true;
        for(int i=0;i<n;i++){
            if(!ones && s.charAt(i)=='1') return false;
            if(s.charAt(i)=='1'){
                ones= true;
            }else{
                ones=false;
            }
            
        }
        return true;
    }
}