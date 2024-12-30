class Solution {
    int Z,O,L,H;
    int dp[];
    int MOD=1_000_000_007;
    public int solve(int l){
        if(l>H){
            return 0;
        }
        if(dp[l]!=-1){
            return dp[l];
        }
        boolean add=false;
        if(l >= L && l <= H){
            add=true;
        }
        int addone=solve(l+O);
        int addzero=solve(l+Z);
         dp[l]=(add ? 1:0)+addone+addzero;
        dp[l]%=MOD;
        return dp[l];

    }
    public int countGoodStrings(int low, int high, int zero, int one) {
        Z=zero;
        O=one;
        L=low;
        H=high;
        dp = new int[H + 1];
        Arrays.fill(dp,-1);
        return solve(0);
    }
}