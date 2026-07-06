class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)-> {
            if(a[0]==b[0]){
                return Integer.compare(b[1],a[1]);
            }
            return Integer.compare(a[0],b[0]);
        });
        int n= intervals.length;

        boolean [] covered=new boolean[n];
        Arrays.fill(covered,false);
        int cov=0;

        for(int i=0;i<n;i++){
            int a=intervals[i][0];
            int b= intervals[i][1];
            for(int j=i+1;j<n;j++){
                if(!covered[j]){
                    int c= intervals[j][0];
                    int d= intervals[j][1];

                    if(c>=a && d<=b){
                        covered[j]=true;
                        cov++;
                    } 
                }
            }
            
        }
        return n-cov;
    }
}