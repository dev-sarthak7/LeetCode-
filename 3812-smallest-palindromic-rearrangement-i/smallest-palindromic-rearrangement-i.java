class Solution {
    public String smallestPalindrome(String s) {
        int n = s.length();

        char[] arr = new char[n / 2];
        for (int i = 0; i < n / 2; i++) {
            arr[i] = s.charAt(i);

        }
        Arrays.sort(arr);
        StringBuilder sb= new StringBuilder();
        for(int i=0;i<arr.length;i++){
            sb.append(arr[i]);
        }
        if(n%2!=0){
            sb.append(s.charAt(n/2));
        }
        for(int i=arr.length-1;i>=0;i--){
            sb.append(arr[i]);
        }
        return sb.toString();

    }
}