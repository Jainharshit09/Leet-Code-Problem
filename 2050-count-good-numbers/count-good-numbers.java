class Solution {
    private long powMod(long base, long exp, long mod) {
        long result = 1;
        base %= mod;
        
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exp >>= 1;
        }
        return result;
    }
    public int countGoodNumbers(long n) {
         long MOD = 1_000_000_007;
         long even=(n+1)/2;
         long odd=n/2;
         long evenPart = powMod(5, even, MOD);
         long oddPart = powMod(4, odd, MOD);
         if(odd==0){
            return (int)( (evenPart)%MOD);
         }
         return (int)((evenPart*oddPart)%MOD);
    }
}