class Solution {
    int dp[];
    public int solve(int n){
        if(n==0 || n==1){
            return 1;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        int ans=solve(n-1)+solve(n-2);
        return dp[n]= ans;
    }
    public int climbStairs(int n) {
        dp=new int[n+1];
        Arrays.fill(dp,-1);
        dp[0]=1;
        dp[1]=1;
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        return solve(n);
    }
}