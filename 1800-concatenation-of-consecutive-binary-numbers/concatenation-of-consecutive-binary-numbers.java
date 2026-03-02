class Solution {
    public int concatenatedBinary(int n) {
        long result = 0;
        int mod = 1000000007;
        int bitLength = 0;

        for (int i = 1; i <= n; i++) {
            if ((i & (i - 1)) == 0) { 
                bitLength++;   // new bit length when power of 2
            }

            result = ((result << bitLength) + i) % mod;
        }

        return (int) result;
    }
}