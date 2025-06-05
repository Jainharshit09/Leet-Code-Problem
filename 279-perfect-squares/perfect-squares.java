class Solution {
    int dp[]=new int[10001];
    public int solve(int n){
        if(n<=3){
            return n;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        int choice=(int)Math.sqrt(n);
        int ans=n;
        for(int i=choice;i>0;i--){
            ans=Math.min(1+solve(n-(i*i)),ans);
        }

        return dp[n]=ans;
    }
    public int numSquares(int n) {
        Arrays.fill(dp,-1);
        return solve(n);
    }
}