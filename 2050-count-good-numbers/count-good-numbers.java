class Solution {
    private long powMod(long base, long exp, long mod) {
       if(exp==0){
        return 1;
       }
       long result=1;
       long half=powMod(base,exp/2,mod);
       result=(half*half)%mod;
       if(exp%2==1){
        result=(result*base)%mod;
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