class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }

        int n = coins.length;
        int dp[][] = new int[n + 1][amount + 1];

        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }

        for (int j = 1; j < dp[0].length; j++) {
            dp[0][j] = Integer.MAX_VALUE; // Initialize to a large value
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                int v = coins[i - 1];
                if (v <= j) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - v] == Integer.MAX_VALUE ? Integer.MAX_VALUE : dp[i][j - v] + 1);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][amount] == Integer.MAX_VALUE ? -1 : dp[n][amount];
    }
}