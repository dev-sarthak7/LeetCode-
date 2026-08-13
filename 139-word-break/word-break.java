class Solution {
    int n;
    Boolean[] t;
    HashSet<String> set= new HashSet<>();
    boolean solve(String s, int idx){
        if(idx>=n){
            return true;
        }
        if(t[idx]!=null){
            return t[idx];
        }
        for(int end=idx+1;end<=n;end++){
            String str= s.substring(idx,end);
            if(set.contains(str)&& solve(s,end)){
                return t[idx]=true;
            }
        }
        return t[idx]=false;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        n= s.length();
        t= new Boolean[n+1];
        for(int i=0;i<wordDict.size();i++){
            set.add(wordDict.get(i));
        }
        return solve(s,0);
    }
}