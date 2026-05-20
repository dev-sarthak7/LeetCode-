class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n= A.length;
        HashSet<Integer> set= new HashSet<>();
        int count=0;
        int[] C= new int[n];
        for(int i=0;i<n;i++){
            if(A[i]==B[i]){
                count++;
                set.add(A[i]);

            }else{
                if(set.contains(A[i])){
                    count++;
                }
                if(set.contains(B[i])){
                    count++;
                }
                set.add(A[i]);
                set.add(B[i]);
            }
            C[i]=count;
        }
        return C;
    }
}