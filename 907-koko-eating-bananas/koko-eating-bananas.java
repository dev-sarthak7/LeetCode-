class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low=1;
        int high=1;
        for(int x:piles){
            high=Math.max(high, x);
        }
        while(low<high){
            int k=low +(high-low)/2;
            int time=0;
            for(int p:piles){
                time+=(p+k-1)/k;
                if(time>h){
                    break;
                }
            }
            if(time<=h){
                high= k;
            }else{
                low=k+1;
            }
        }
        return low;
    }
}