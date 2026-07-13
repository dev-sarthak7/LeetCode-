class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        Queue<Integer> q= new LinkedList<>();
        for(int i=1;i<9;i++){
            q.offer(i);
        }
        List<Integer>list= new ArrayList<>();
        while(!q.isEmpty()){
            int digit=q.poll();
            if(digit>=low && digit<=high){
                list.add(digit);
            }

            int ld=digit%10;
           
            ld+=1;
            if(ld>9){
                continue;
            }
            digit=digit*10+ ld;
            
            if(digit<=high){
                q.offer(digit);
            }

        }
        return list;
    }
}