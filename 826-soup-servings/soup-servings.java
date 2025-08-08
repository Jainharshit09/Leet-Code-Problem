class Solution {
    private final int[][] serves = {
        {100, 0}, {75, 25}, {50, 50}, {25, 75}
    };
    
    private double[][] memo;
    public double solve(int a ,int b){
        if(a<=0 && b<=0)return 0.5;
        if(a<=0)return 1.0;
        if(b<=0)return 0.0;
        if(memo[a][b]!=-1)return memo[a][b];
        double prob=0.0;
        for(int s[]:serves){
            int givenA=s[0];
            int givenB=s[1];
            prob+=solve(a-givenA,b-givenB);
        }
        return memo[a][b]= 0.25*prob;
    }
    public double soupServings(int n) {
        if(n>=5000)return 1;
        memo=new double[n+1][n+1];
        for(double dp[]:memo){
            Arrays.fill(dp,-1.0);
        }
        return solve(n,n);
    }
}