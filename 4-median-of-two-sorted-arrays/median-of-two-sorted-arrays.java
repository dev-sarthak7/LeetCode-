class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n= nums1.length;
        int m= nums2.length;
        int i=0;
        int j=0;
        int[] sorted= new int[m+n];
        int count=0;
        while(i<n && j<m){
            if(nums1[i]<=nums2[j]){
                sorted[count]=nums1[i];
                i++;
            }else{
                sorted[count]=nums2[j];
                j++;
            }
            count++;
        }
        while(i<n){
            sorted[count]=nums1[i];
            i++;
            count++;
        }
        while(j<m){
            sorted[count]=nums2[j];
            j++;
            count++;
        }
        if((m+n)%2==0){
            return (double) (sorted[(m+n)/2 ] +sorted[((m+n)/2) -1])/2;
        }else{
            return (double) sorted[((m+n)/2) ];
        }
    }
}