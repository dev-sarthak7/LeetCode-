class Solution {
    Integer[] t;
    int solve(int[] coins, int amount){
        if(amount<0){
            return -1;
        }
        if(t[amount]!=null){
            return t[amount];
        }
        if(amount==0){
            return 0;
        }
        
        int min=Integer.MAX_VALUE;
        for(int i=0;i<coins.length;i++){
            int result= solve(coins,amount-coins[i]);
            if(result!=-1){
                min=Math.min(min,1+result);
            }
        }
        if(min==Integer.MAX_VALUE){
            return t[amount]=-1;
        }
        return t[amount]=min;

    }
    public int coinChange(int[] coins, int amount) {
        t= new Integer[amount+1];

        return solve(coins,amount);
    }
}