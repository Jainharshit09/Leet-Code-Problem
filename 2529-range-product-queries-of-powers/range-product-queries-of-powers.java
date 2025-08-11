//queires is there than check can we use segment tee
// first find all power and make sure the max power will be 29
// store all power in array
// than create a segment tree
//in which we do multiply
// from that range we can find

// also we can use spare table becacuse in that no need of update 
// rather than using segment tree direct use the prefix approach


class Solution {
    int mod = 1000000007;
        long inverse(long a, int mod) {
        return pow(a, mod - 2);
    }

    long pow(long base, long exp) {
        long res = 1;
        base %= mod;
        while (exp > 0) {
            if ((exp & 1) != 0) {
                res = (res * base) % mod;
            }
            base = (base * base) % mod;
            exp >>= 1;
        }
        return res;
    }
    public int[] productQueries(int n, int[][] queries) {
        long power[]=new long[32];
        int index=0;
        for(int i=0;i<33;i++){
            if ((n & (1 << i)) != 0) {
                power[index++]=(1 << i);
            }
        }
        long prefix[]=new long [index];
        prefix[0]=power[0];
        for(int i=1;i<index;i++){
            prefix[i]=(prefix[i-1]*power[i])%mod;
        }
        int ans[]=new int[queries.length];
        for(int i=0;i<queries.length;i++){
            int start=queries[i][0];
            int end=queries[i][1];
            if(start==0){
                ans[i]=(int)(prefix[end]%mod);
            }
            else{
                int num=(int)prefix[end];
                int den=(int)prefix[start-1];
                ans[i]=(int)((num* inverse(den,mod))%mod);
            }
        }
        return ans;
    }
}