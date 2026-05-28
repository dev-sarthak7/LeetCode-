class Solution {
    public int numberOfSpecialChars(String word) {
        int count=0;
        int[] low= new int[26];
        int[] high= new int[26];
        Arrays.fill(high,-1);
        Arrays.fill(low,-1);
        for(int i=0;i<word.length();i++){
            char ch= word.charAt(i);
            if(Character.isUpperCase(ch )){
                if(high[ch-'A']==-1){
                    high[ch-'A']=i;
                }
            }else{
                low[ch-'a']=i;
            }
        }
        for(int i=0;i<26;i++){
            if(high[i]!=-1 && low[i]!=-1 && low[i]<high[i]){
                count++;
            }
        }
        return count;
    }
}