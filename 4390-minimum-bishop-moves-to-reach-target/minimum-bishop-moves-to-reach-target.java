class Solution {
    public int minBishopMoves(int[] source, int[] target) {
        int x1=source[0];
        int y1=source[1];
        int x2=target[0];
        int y2=target[1];
        boolean a= (x1+y1)%2==0;
        boolean b= (x2+y2)%2==0;
        if(a!=b)return -1;
        if(x1+y1==x2+y2 || Math.abs(x1-x2)==Math.abs(y1-y2)) return 1;

        return 2;
    }
}