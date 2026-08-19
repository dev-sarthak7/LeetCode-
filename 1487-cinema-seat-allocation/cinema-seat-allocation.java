class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        HashMap<Integer,HashSet<Integer>> map= new HashMap<>();
        for(int[] arr: reservedSeats){
            if(map.containsKey(arr[0])){
                HashSet<Integer> set1= map.get(arr[0]);
                set1.add(arr[1]);
                map.put(arr[0],set1);
            }else{
                HashSet<Integer> set2 = new HashSet<>();
                set2.add(arr[1]);
                map.put(arr[0],set2);
            }
        }
        int count=0;
        for(int k:map.keySet()){
            boolean s1= true;
            boolean s2= true;
            boolean s3= true;
            HashSet<Integer> set= map.get(k);
            for(int i=2;i<=5;i++){
                if(set.contains(i)){
                    s1=false;
                    break;
                }
            }
            for(int i=4;i<=7;i++){
                if(set.contains(i)){
                    s2=false;
                    break;
                }
            }
            for(int i=6;i<=9;i++){
                if(set.contains(i)){
                    s3=false;
                    break;
                }
            }
            if(s1&& s3){
                count+=2;
            }else if(s1 || s2 || s3){
                count++;
            }
            
        }
        count+= (n-map.size()) *2;
        return count;
    }
}