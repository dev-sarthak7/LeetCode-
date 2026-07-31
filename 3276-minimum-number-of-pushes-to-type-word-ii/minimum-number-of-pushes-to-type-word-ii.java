class Pair{
    int count;
    char ch;
    Pair(char ch, int count){
        this.ch= ch;
        this.count=count;
    }
}
class Solution {
    public int minimumPushes(String word) {
        HashMap<Character, Integer> map= new HashMap<>();
        for(int i=0;i<word.length();i++){
            if(map.containsKey(word.charAt(i))){
                map.put(word.charAt(i),map.get(word.charAt(i))+1);
            }else{
                map.put(word.charAt(i),1);
            }
        }
        ArrayList<Pair> list = new ArrayList<>();
        for(char c:map.keySet()){
            list.add(new Pair(c,map.get(c)));
        }
        Collections.sort(list, (a,b)->{
            return Integer.compare(a.count, b.count);
        });
        int result=0;
        int x=0;
        for(int i=list.size()-1;i>=0;i--){
            if(x<8){
                result+= list.get(i).count;
            }else if(x<16){
                result+=list.get(i).count * 2;
            }else if(x<24){
                result+=list.get(i).count* 3;
            }else{
                result+=list.get(i).count *4;
            }
            x++;
        }
        return result;

    }
}