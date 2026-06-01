class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        
        int totalCost=0;
        int n= cost.length;
        int num=0;
        for(int i=n-1;i>=0;i--){
            if(num<2){
                totalCost+=cost[i];
                num++;
            }else{
                num=0;
            }
        }
        return totalCost;
    }
}