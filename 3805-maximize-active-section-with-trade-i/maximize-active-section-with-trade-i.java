class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int c=0;
        int[] arr= new int[s.length()];
        for(char ch:s.toCharArray()){
            arr[c]=Character.getNumericValue(ch);
            c++;
        }
        int n= arr.length;
        int[] left= new int[n];
        int[] right= new int[n];
        int lz=0;
        if(arr[0]==0){
            left[0]=-1;
            lz++;
        }else{
            left[0]=0;
        }
        for(int i=1;i<n;i++){
            if(arr[i]==1){
                left[i]=lz;
            }else{
                if(arr[i-1]==1){
                    lz=1;
                    
                }else{
                    lz++;
                }
                left[i]=-1;
            }
        }
        int rz=0;
        if(arr[n-1]==1){
            right[n-1]=0;
        }else{
            right[n-1]=-1;
            rz++;
        }
        for(int i=n-2;i>=0;i--){
            if(arr[i]==1){
                right[i]=rz;
            }else{
                if(arr[i+1]==1){
                    rz=1;
                }else{
                    rz++;
                }
                right[i]=-1;
            }
        }

        int max=0;
        for(int i=0;i<n;i++){
            int num=0;
            if(left[i]>0 && right[i]>0){
                num+=left[i]+right[i];
            }
            

            max=Math.max(max,num);
        }

        for(int x:arr){
            if(x==1){
                max++;
            }
        }
        return max;


    }
}