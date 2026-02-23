class Solution {
    public boolean hasAllCodes(String s, int k) {
        HashSet<String> set= new HashSet<>();

        int codes=1<<k;
        for(int i=0;i<=s.length()-k;i++){
            set.add(s.substring(i,i+k));
            if(set.size()==codes){
                return true;
            }
        }
        return false;
    }
}