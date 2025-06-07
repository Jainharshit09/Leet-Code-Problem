class Solution {
    long[][][] dp;

    // there are 3 state 1.buy , 2.sell 3. do nothing
    // in buy having 2 thing sell or nothing state 1
    // in sell only do buy or nothing state 2
    // in nothing we can buy sell nothing is 0 state
    // remember if on last index than check the state also beacuse either 3 chances occuer like for 0 ,1,2 sell buy nothing

    public long solve(int[] prices, int i, int k, int state) {
        if (k == 0) return 0;

        if (i == prices.length - 1) {
            if (state == 0) return 0;
            if (state == 1) return prices[i];
            return -prices[i];
        }

       
        if (dp[i][k][state] != Long.MIN_VALUE)
            return dp[i][k][state];

        long profit = Long.MIN_VALUE;

        // do nothing
        profit = Math.max(profit, solve(prices, i + 1, k, state));

        // prev do nothing
        if (state == 0) {
            // buy
            profit = Math.max(profit, -prices[i] + solve(prices, i + 1, k, 1));
            // sell
            profit = Math.max(profit, prices[i] + solve(prices, i + 1, k, 2));
        } 
        // prev bought
        else if (state == 1) {
            // sell
            profit = Math.max(profit, prices[i] + solve(prices, i + 1, k - 1, 0));
        } 
        
        //prev sold
        else {
            // buy
            profit = Math.max(profit, -prices[i] + solve(prices, i + 1, k - 1, 0));
        }

        return dp[i][k][state] = profit;
    }

    public long maximumProfit(int[] prices, int k) {
        int n = prices.length;
        dp = new long[n][k + 1][3];
        for (int i = 0; i < n; i++)
            for (int j = 0; j <= k; j++)
                for (int s = 0; s < 3; s++)
                    dp[i][j][s] = Long.MIN_VALUE;

        return solve(prices, 0, k, 0);
    }
}
